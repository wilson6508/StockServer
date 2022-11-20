package com.dao;

import com.model.entity.TwEtfInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface TwEtfInfoDao extends JpaRepository<TwEtfInfoEntity, Integer> {
    List<TwEtfInfoEntity> findByUpdateDate(Date date);
    List<TwEtfInfoEntity> findByUpdateDateBetween(Date d1, Date d2);
    Optional<TwEtfInfoEntity> findByStockIdAndUpdateDate(String stockId, Date date);
}
