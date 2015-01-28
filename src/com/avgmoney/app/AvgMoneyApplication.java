package com.avgmoney.app;

import android.app.Application;

import com.avgmoney.app.db.AvgMoneyDb;

public class AvgMoneyApplication extends Application {

    private AvgMoneyDb db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = AvgMoneyDb.getAvgMoneyDb(this);
    }

    public AvgMoneyDb getDb() {
        return db;
    }

    public void setDb(AvgMoneyDb db) {
        this.db = db;
    }

}
