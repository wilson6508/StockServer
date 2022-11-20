package com.service.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.model.bean.EtfBean;
import com.model.bean.MsgBean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@EnableRetry
public class GetService {

    private final Gson gson = new Gson();

    public String getStringData(String url) {
        SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(20 * 60 *1000);
        clientHttpRequestFactory.setReadTimeout(20 * 60 * 1000);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(clientHttpRequestFactory);
        String result = null;
        try {
            result = restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Retryable(include = {IllegalStateException.class}, maxAttempts = 2, backoff = @Backoff(value = 9000))
    public Map<String, MsgBean> getMsgBeanMap() {
        Map<String, MsgBean> hashMap = new HashMap<>();
        String url = "https://script.google.com/macros/s/AKfycbwKrUFQelAHVekiaB_JC474mBm9wU8VV77OA0Sh660VqiXloZDsC97majvwmbKqBn0k/exec";
        String stringData = getStringData(url);
        Type type = new TypeToken<ArrayList<EtfBean>>() {}.getType();
        List<EtfBean> beanList = gson.fromJson(stringData, type);
        for (EtfBean bean : beanList) {
            if (bean.getMsgArray() != null) {
                for (MsgBean msgBean : bean.getMsgArray()) {
                    hashMap.put(msgBean.getA(), msgBean);
                }
            }
        }
        return hashMap;
    }

}
