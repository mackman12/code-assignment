package com.kry.assignment.service;

public class Service {
    private String Key;
    private String Name;
    private String Url;
    private String Status;
    private String CreateDate;
    private String LastChanged;

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String createDate) {
        CreateDate = createDate;
    }

    public String getLastChanged() {
        return LastChanged;
    }
    public void setLastChanged(String lastChanged) {
        LastChanged = lastChanged;
    }
}
