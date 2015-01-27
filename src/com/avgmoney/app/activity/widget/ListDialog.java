package com.avgmoney.app.activity.widget;

import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.avgmoney.app.R;
import com.avgmoney.app.logic.CommodityTypeLogic;
import com.avgmoney.app.model.CommodityType;

public class ListDialog extends ListActivity {

    private ArrayAdapter<CommodityType> adapter;
    private CommodityTypeLogic commodityTypeLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        commodityTypeLogic = new CommodityTypeLogic(this);
        List<CommodityType> list = commodityTypeLogic.queryCommodityType();

        adapter = new MyAdapter(this, R.layout.list_dialog_item, list);
        this.setListAdapter(adapter);
        this.getListView().setBackgroundColor(getResources().getColor(R.color.white));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        CommodityType type = adapter.getItem(position);
        Intent data = new Intent();
        data.putExtra("type_id", type.getId());
        data.putExtra("type_name", type.getName());
        setResult(20, data);
        finish();
    }

    class MyAdapter extends ArrayAdapter<CommodityType> {

        private Context context;
        private int textViewResourceId;

        public MyAdapter(Context context, int textViewResourceId, List<CommodityType> objects) {
            super(context, textViewResourceId, objects);
            this.context = context;
            this.textViewResourceId = textViewResourceId;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            CommodityType type = getItem(position);
            View view;
            ViewHolder holder;
            if (convertView == null) {
                view = LayoutInflater.from(context).inflate(textViewResourceId, null);
                holder = new ViewHolder();
                holder.typeName = (TextView) view.findViewById(R.id.type_name);
            } else {
                view = convertView;
                holder = (ViewHolder) view.getTag();
            }
            holder.type = type;
            holder.typeName.setText(type.getName());
            view.setTag(holder);
            return view;
        }

        class ViewHolder {
            CommodityType type;
            TextView typeName;
        }

    }

}
