package com.model.prop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesBean {

    @Value("${testApi}")
    String testApi;

    @Value("${databaseApi}")
    String databaseApi;

    @Value("${readExcelApi}")
    String readExcelApi;

    @Value("${timeOut}")
    int timeOut;

    @Value("${excelUrl}")
    String excelUrl;

    public String getTestApi() {
        return testApi;
    }

    public void setTestApi(String testApi) {
        this.testApi = testApi;
    }

    public String getDatabaseApi() {
        return databaseApi;
    }

    public void setDatabaseApi(String databaseApi) {
        this.databaseApi = databaseApi;
    }

    public String getReadExcelApi() {
        return readExcelApi;
    }

    public void setReadExcelApi(String readExcelApi) {
        this.readExcelApi = readExcelApi;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public String getExcelUrl() {
        return excelUrl;
    }

    public void setExcelUrl(String excelUrl) {
        this.excelUrl = excelUrl;
    }
}
