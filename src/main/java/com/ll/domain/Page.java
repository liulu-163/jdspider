package com.ll.domain;

/**
 * @author wuwenbo
 * @create 2019-12-18 10:40
 */
public class Page {
    private String pageUrl;
    private String currePrice;
    private String originPrice;
    private String crawltime;
    private String skuid;
    private String firCat;
    private String secCat;
    private String thrCat;
    private String brand;
    private String type;
    private String name;

    public Page() {
    }


    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getCrawltime() {
        return crawltime;
    }

    public void setCrawltime(String crawltime) {
        this.crawltime = crawltime;
    }

    public String getSkuid() {
        return skuid;
    }

    public void setSkuid(String skuid) {
        this.skuid = skuid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getFirCat() {
        return firCat;
    }

    public void setFirCat(String firCat) {
        this.firCat = firCat;
    }

    public String getSecCat() {
        return secCat;
    }

    public void setSecCat(String secCat) {
        this.secCat = secCat;
    }

    public String getThrCat() {
        return thrCat;
    }

    public void setThrCat(String thrCat) {
        this.thrCat = thrCat;
    }

    public String getCurrePrice() {
        return currePrice;
    }

    public void setCurrePrice(String currePrice) {
        this.currePrice = currePrice;
    }

    public String getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(String originPrice) {
        this.originPrice = originPrice;
    }
}
