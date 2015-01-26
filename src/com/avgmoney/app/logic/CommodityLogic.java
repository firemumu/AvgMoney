package com.avgmoney.app.logic;

import java.util.List;

import android.content.Context;

import com.avgmoney.app.AvgMoneyApplication;
import com.avgmoney.app.db.AvgMoneyDb;
import com.avgmoney.app.model.Commodity;

public class CommodityLogic {

    private AvgMoneyDb db;

    public CommodityLogic(Context context) {
        db = ((AvgMoneyApplication) context.getApplicationContext()).getDb();
    }

    public void addCommodity(Commodity c) {
        db.saveCommodity(c);
    }

    public List<Commodity> queryCommodity() {
        return db.getCommoditys();
    }

}
