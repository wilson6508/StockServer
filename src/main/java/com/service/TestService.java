package com.service;

import com.google.gson.Gson;
import com.model.entity.TwEtfInfoEntity;
import com.service.api.GoogleSheetService;
import com.service.database.TwEtfInfoEntityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;

@Service
public class TestService {

    @Resource
    TwEtfInfoEntityService twEtfInfoEntityService;
    @Resource
    GoogleSheetService googleSheetService;

    public void test() {
        List<List<Object>> objectListList = googleSheetService.readData("1wbM1eLhonUleIRb82B0HHlKYzP-N1xov-kZLKy6pkXs", "DSN");
        System.out.println(new Gson().toJson(objectListList));
//        for (List<Object> objectList : objectListList) {
//            TwEtfInfoEntity entity = new TwEtfInfoEntity();
//            entity.setStockId("00" + objectList.get(1));
//            entity.setName(objectList.get(2).toString());
//            entity.setMarketPrice(Double.parseDouble(objectList.get(3).toString()));
//            entity.setNetValue(Double.parseDouble(objectList.get(4).toString()));
//            entity.setDisPrePer(Double.parseDouble(objectList.get(5).toString()));
//            entity.setPreNetValue(Double.parseDouble(objectList.get(6).toString()));
//            entity.setTotalShare(Integer.parseInt(objectList.get(7).toString()));
//            entity.setDeltaShare(Integer.parseInt(objectList.get(8).toString()));
//            entity.setUpdateDate(Date.valueOf(objectList.get(9).toString()));
//            entity.setDeltaPrice(Double.parseDouble(objectList.get(10).toString()));
//            entity.setDeltaPricePer(Double.parseDouble(objectList.get(11).toString()));
////            System.out.println(new Gson().toJson(entity));
//            twEtfInfoEntityService.createEntity(entity);
//        }

    }

}
