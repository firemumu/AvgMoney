package com.avgmoney.app.model;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Id;

public class CommodityType {
    @Id
    private int Id;

    @Column(column = "name")
    private String name;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CommodityType [Id=" + Id + ", name=" + name + "]";
    }

}
