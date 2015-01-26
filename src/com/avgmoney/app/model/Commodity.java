package com.avgmoney.app.model;

import java.util.Date;

import com.lidroid.xutils.db.annotation.Id;

public class Commodity {

    @Id
    private int Id;

    private String name;

    // 购买时间
    private Date data;

    // 价格
    private double price;

    // 备注
    private String notes;

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Commodity [Id=" + Id + ", name=" + name + ", data=" + data + ", price=" + price + ", notes=" + notes + "]";
    }

}
