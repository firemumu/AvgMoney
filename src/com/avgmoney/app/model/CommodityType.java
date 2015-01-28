package com.avgmoney.app.model;

import com.avgmoney.app.db.EntityBase;
import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Table;

@Table(name = "CommodityType")
public class CommodityType extends EntityBase {

    @Column(column = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CommodityType [name=" + name + "]";
    }

}
