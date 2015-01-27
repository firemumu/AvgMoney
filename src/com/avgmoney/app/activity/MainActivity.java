package com.avgmoney.app.activity;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.avgmoney.app.R;
import com.avgmoney.app.activity.adapter.AvgMoneyListViewAdapter;
import com.avgmoney.app.activity.widget.PullToRefreshListView;
import com.avgmoney.app.logic.CommodityLogic;
import com.avgmoney.app.model.Commodity;

public class MainActivity extends Activity implements OnClickListener {

    private CommodityLogic commodityLogic;

    private ImageView menu;
    private TextView title;
    private TextView add;
    private PullToRefreshListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        commodityLogic = new CommodityLogic(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        listview = (PullToRefreshListView) findViewById(R.id.avgmoney_listview);
        List<Commodity> commoditys = commodityLogic.queryCommodity();
        if (commoditys != null) {
            listview.setAdapter(new AvgMoneyListViewAdapter(this, commoditys));
        }
        menu = (ImageView) findViewById(R.id.menu);
        title = (TextView) findViewById(R.id.title);
        title.setText(R.string.commodity_list);
        add = (TextView) findViewById(R.id.add);
        add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.add:
            Intent intent = new Intent(this, AddCommodityActivity.class);
            startActivity(intent);
            break;

        default:
            break;
        }
    }

}
