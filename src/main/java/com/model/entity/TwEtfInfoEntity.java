package com.model.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "tw_etf_info", schema = "stock_dev", catalog = "")
public class TwEtfInfoEntity {
    private int id;
    private String stockId;
    private String name;
    private double marketPrice;
    private double netValue;
    private double disPrePer;
    private double preNetValue;
    private int totalShare;
    private int deltaShare;
    private Date updateDate;
    private double deltaPrice;
    private double deltaPricePer;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "stock_id")
    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "market_price")
    public double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(double marketPrice) {
        this.marketPrice = marketPrice;
    }

    @Basic
    @Column(name = "net_value")
    public double getNetValue() {
        return netValue;
    }

    public void setNetValue(double netValue) {
        this.netValue = netValue;
    }

    @Basic
    @Column(name = "dis_pre_per")
    public double getDisPrePer() {
        return disPrePer;
    }

    public void setDisPrePer(double disPrePer) {
        this.disPrePer = disPrePer;
    }

    @Basic
    @Column(name = "pre_net_value")
    public double getPreNetValue() {
        return preNetValue;
    }

    public void setPreNetValue(double preNetValue) {
        this.preNetValue = preNetValue;
    }

    @Basic
    @Column(name = "total_share")
    public int getTotalShare() {
        return totalShare;
    }

    public void setTotalShare(int totalShare) {
        this.totalShare = totalShare;
    }

    @Basic
    @Column(name = "delta_share")
    public int getDeltaShare() {
        return deltaShare;
    }

    public void setDeltaShare(int deltaShare) {
        this.deltaShare = deltaShare;
    }

    @Basic
    @Column(name = "update_date")
    @CreationTimestamp
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Basic
    @Column(name = "delta_price")
    public double getDeltaPrice() {
        return deltaPrice;
    }

    public void setDeltaPrice(double deltaPrice) {
        this.deltaPrice = deltaPrice;
    }

    @Basic
    @Column(name = "delta_price_per")
    public double getDeltaPricePer() {
        return deltaPricePer;
    }

    public void setDeltaPricePer(double deltaPricePer) {
        this.deltaPricePer = deltaPricePer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TwEtfInfoEntity entity = (TwEtfInfoEntity) o;
        return id == entity.id && Double.compare(entity.marketPrice, marketPrice) == 0 && Double.compare(entity.netValue, netValue) == 0 && Double.compare(entity.disPrePer, disPrePer) == 0 && Double.compare(entity.preNetValue, preNetValue) == 0 && totalShare == entity.totalShare && deltaShare == entity.deltaShare && Double.compare(entity.deltaPrice, deltaPrice) == 0 && Double.compare(entity.deltaPricePer, deltaPricePer) == 0 && Objects.equals(stockId, entity.stockId) && Objects.equals(name, entity.name) && Objects.equals(updateDate, entity.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stockId, name, marketPrice, netValue, disPrePer, preNetValue, totalShare, deltaShare, updateDate, deltaPrice, deltaPricePer);
    }
}
