package com.model.prop;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class PropertiesBean {

    @Value("${gooJsonPath}")
    private String gooJsonPath;

    @Value("${testApi}")
    private String testApi;

    @Value("${databaseApi}")
    private String databaseApi;

    @Value("${readExcelApi}")
    private String readExcelApi;

    @Value("${timeOut}")
    private int timeOut;

    @Value("${excelUrl}")
    private String excelUrl;

}
