package com.kiduyu.kingooproject.crimereporter.Models;

public class Reports {
    String name,format,size,date,url;

    public Reports(String name, String format, String size, String date, String url) {
        this.name = name;
        this.format = format;
        this.size = size;
        this.date = date;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
