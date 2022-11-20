package com.service.database;

import com.dao.TwEtfInfoDao;
import com.model.entity.TwEtfInfoEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TwEtfInfoEntityService {

    @Resource
    TwEtfInfoDao twEtfInfoDao;

    public void createEntity(TwEtfInfoEntity entity) {
        twEtfInfoDao.save(entity);
    }

    public Optional<TwEtfInfoEntity> readEntity(String stockId, Date date) {
        return twEtfInfoDao.findByStockIdAndUpdateDate(stockId, date);
    }

    public List<TwEtfInfoEntity> readEntityList(Date d1, Date d2) {
        return twEtfInfoDao.findByUpdateDateBetween(d1, d2);
    }

}
