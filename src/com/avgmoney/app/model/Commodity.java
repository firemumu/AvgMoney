package com.avgmoney.app.model;

import java.util.Date;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.Id;

public class Commodity {

    @Id
    private int Id;

    // 头像路径
    @Column(column = "imageUrl")
    private String imageUrl;

    @Column(column = "name")
    private String name;

    // 购买时间
    @Column(column = "date")
    private Date date;

    // 价格
    @Column(column = "price")
    private double price;

    @Foreign(column = "typeId", foreign = "id")
    private CommodityType type;

    // 备注
    @Column(column = "notes")
    private String notes;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CommodityType getType() {
        return type;
    }

    public void setType(CommodityType type) {
        this.type = type;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Commodity [Id=" + Id + ", imageUrl=" + imageUrl + ", name=" + name + ", date=" + date + ", price=" + price + ", type=" + type
                + ", notes=" + notes + "]";
    }

}
