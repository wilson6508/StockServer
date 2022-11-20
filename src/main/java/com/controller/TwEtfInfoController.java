package com.controller;

import com.model.bean.TwEtfQueryBean;
import com.model.entity.TwEtfInfoEntity;
import com.service.inter.TwEtfInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TwEtfInfoController {

    @Resource
    TwEtfInfoService twEtfInfoServiceImpl;

    // http://localhost:10002/create
    @PostMapping(value = "/create")
    public ResponseEntity<Object> create() {
        boolean boo = twEtfInfoServiceImpl.create();
        return ResponseEntity.status(HttpStatus.OK).body(boo);
    }

    // http://localhost:10002/read?type=instantInfo
    // http://localhost:10002/read?type=databaseInfo&start=2022-11-01&end=2022-11-30
    @GetMapping(value = "/read")
    public ResponseEntity<Object> read(TwEtfQueryBean twEtfQueryBean) {
        List<TwEtfInfoEntity> list = twEtfInfoServiceImpl.read(twEtfQueryBean);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

}
