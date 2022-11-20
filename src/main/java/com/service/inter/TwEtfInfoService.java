package com.service.inter;

import com.model.bean.TwEtfQueryBean;
import com.model.entity.TwEtfInfoEntity;

import java.util.List;

public interface TwEtfInfoService {
    boolean create();
    List<TwEtfInfoEntity> read(TwEtfQueryBean twEtfQueryBean);
}
