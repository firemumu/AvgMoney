package com.avgmoney.app.db;

import java.util.List;

import android.content.Context;

import com.avgmoney.app.model.Commodity;
import com.avgmoney.app.model.CommodityType;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.db.sqlite.WhereBuilder;
import com.lidroid.xutils.exception.DbException;

public class AvgMoneyDb {

    public static final String DB_NAME = "avg_money";
    public static final int version = 1;

    private static AvgMoneyDb avgMoneyDb;
    private DbUtils db;

    private AvgMoneyDb(Context context) {
        db = DbUtils.create(context, DB_NAME);
        db.configAllowTransaction(true);
        db.configDebug(true);
    }

    public synchronized static AvgMoneyDb getAvgMoneyDb(Context context) {
        if (avgMoneyDb == null) {
            avgMoneyDb = new AvgMoneyDb(context);
        }
        return avgMoneyDb;
    }

    /**
     * 保存商品
     * */
    public void saveCommodity(Commodity commodity) {
        try {
            db.saveBindingId(commodity);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过商品名删除商品
     * */
    public void delCommodityByName(String commodityName) {
        try {
            db.delete(Commodity.class, WhereBuilder.b("name", "=", commodityName));
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有商品
     * */
    public List<Commodity> getCommoditys() {
        try {
            return db.findAll(Commodity.class);
        } catch (DbException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 修改商品
     * */
    public void modifyCommodity(Commodity commodity) {
        try {
            db.update(commodity);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    /**
     * 保存商品类型
     * */
    public void saveCommodityType(CommodityType commodityType) {
        try {
            db.save(commodityType);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有商品类型
     * */
    public List<CommodityType> getCommodityTypes() {
        try {
            return db.findAll(CommodityType.class);
        } catch (DbException e) {
            e.printStackTrace();
        }
        return null;
    }

}
