package com.service.impl;

import com.model.bean.MsgBean;
import com.model.bean.TwEtfQueryBean;
import com.model.entity.TwEtfInfoEntity;
import com.service.api.GetService;
import com.service.database.TwEtfInfoEntityService;
import com.service.inter.TwEtfInfoService;
import com.tool.DateTimeTool;
import com.tool.NumberTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TwEtfInfoServiceImpl implements TwEtfInfoService {

    private final String[] stockIdArr = new String[]{"00668", "00646", "00662"}; // "00830"
    @Resource
    GetService getService;
    @Resource
    TwEtfInfoEntityService twEtfInfoEntityService;

    @Override
    public boolean create() {
        boolean boo = true;
        try {
            Map<String, MsgBean> msgBeanMap = getService.getMsgBeanMap();
            for (String stockId : stockIdArr) {
                // 取得今日與昨日entity
                TwEtfInfoEntity newEntity = convertBeanToEntity(msgBeanMap.get(stockId));
                Optional<TwEtfInfoEntity> optional = twEtfInfoEntityService.readEntity(stockId, DateTimeTool.getPreviousTradingDay());
                optional.ifPresent((oldEntity) -> {
                    // 計算漲跌
                    double deltaPrice = NumberTool.getSubtractDouble(newEntity.getMarketPrice(), oldEntity.getMarketPrice());
                    double deltaPricePer = NumberTool.getDivideDouble(deltaPrice, oldEntity.getMarketPrice(), 4);
                    newEntity.setDeltaPrice(deltaPrice);
                    newEntity.setDeltaPricePer(deltaPricePer * 100);
                    // 存入DB
                    twEtfInfoEntityService.createEntity(newEntity);
                });
            }
        } catch (Exception e) {
            boo = false;
        }
        return boo;
    }

    @Override
    public List<TwEtfInfoEntity> read(TwEtfQueryBean twEtfQueryBean) {
        List<TwEtfInfoEntity> list = new ArrayList<>();
        String type = twEtfQueryBean.getType();
        switch (type) {
            case "instantInfo": {
                list = readInstantInfo();
                break;
            }
            case "databaseInfo": {
                list = readDatabaseInfo(twEtfQueryBean);
                break;
            }
        }
        return list;
    }

    public List<TwEtfInfoEntity> readInstantInfo() {
        Map<String, MsgBean> msgBeanMap = getService.getMsgBeanMap();
        Stream<String> stream = Arrays.stream(stockIdArr);
        return stream.map((stockId) -> convertBeanToEntity(msgBeanMap.get(stockId))).collect(Collectors.toList());
    }

    public List<TwEtfInfoEntity> readDatabaseInfo(TwEtfQueryBean twEtfQueryBean) {
        Date start = Date.valueOf(twEtfQueryBean.getStart());
        Date end = Date.valueOf(twEtfQueryBean.getEnd());
        return twEtfInfoEntityService.readEntityList(start, end);
    }

    public TwEtfInfoEntity convertBeanToEntity(MsgBean msgBean) {
        TwEtfInfoEntity entity = new TwEtfInfoEntity();
        entity.setStockId(msgBean.getA());
        entity.setName(msgBean.getB());
        entity.setMarketPrice(Double.parseDouble(msgBean.getE()));
        entity.setNetValue(Double.parseDouble(msgBean.getF()));
        entity.setDisPrePer(Double.parseDouble(msgBean.getG()));
        entity.setPreNetValue(Double.parseDouble(msgBean.getH()));
        entity.setTotalShare(Integer.parseInt(msgBean.getC().replace(",", "")));
        entity.setDeltaShare(Integer.parseInt(msgBean.getD().replace(",", "")));
        // entity.setDeltaPrice();
        // entity.setDeltaPricePer();
        return entity;
    }

}
