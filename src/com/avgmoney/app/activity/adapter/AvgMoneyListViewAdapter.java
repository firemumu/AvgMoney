package com.avgmoney.app.activity.adapter;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.avgmoney.app.R;
import com.avgmoney.app.model.Commodity;
import com.avgmoney.app.utils.Utils;

public class AvgMoneyListViewAdapter extends BaseAdapter {

    private Context context;
    private List<Commodity> commoditys;

    public AvgMoneyListViewAdapter(Context context, List<Commodity> commoditys) {
        this.commoditys = commoditys;
        this.context = context;
    }

    @Override
    public int getCount() {
        return commoditys.size();
    }

    @Override
    public Commodity getItem(int position) {
        return commoditys.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Commodity commodity = getItem(position);
        View view;
        ViewHolder holder;
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.avgmoney_listview_item, null);
            holder = new ViewHolder();
            holder.commodityImg = (ImageView) view.findViewById(R.id.commodity_img);
            holder.commodityName = (TextView) view.findViewById(R.id.commodity_name_text);
            holder.commodityDate = (TextView) view.findViewById(R.id.commodity_date_text);
            holder.commodityAvgMoney = (TextView) view.findViewById(R.id.commodity_avg_money_text);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        holder.commodityImg.setImageResource(R.drawable.ic_launcher);
        holder.commodityName.setText(commodity.getName());
        holder.commodityDate.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(commodity.getDate()));
        String avgMoney = "";
        try {
            int betweenDay = Utils.daysBetween(commodity.getDate(), new Date()) + 1;
            String temp = new DecimalFormat("#.00").format(commodity.getPrice() / betweenDay);
            avgMoney = String.format(context.getResources().getString(R.string.avg_money_format), temp);
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        holder.commodityAvgMoney.setText(avgMoney);
        return view;
    }

    class ViewHolder {
        ImageView commodityImg;
        TextView commodityName;
        TextView commodityDate;
        TextView commodityAvgMoney;
    }

}
