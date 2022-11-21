//package com;
//
//import lombok.extern.slf4j.Slf4j;
//import org.jasypt.encryption.StringEncryptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.ApplicationContext;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@Component
//public class TestApp implements CommandLineRunner {
//
//    @Autowired
//    ApplicationContext applicationContext;
//    @Autowired
//    StringEncryptor stringEncryptor;
//
//    private String encrypt(String originPassword) {
//        return stringEncryptor.encrypt(originPassword);
//    }
//
//    private String decrypt(String encryptedPassword) {
//        return stringEncryptor.decrypt(encryptedPassword);
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        log.info("開始測試 Service");
//
//        Environment environment = applicationContext.getBean(Environment.class);
//
//        String originUsername = environment.getProperty("spring.datasource.username");
//        String encryptUsername = encrypt(originUsername);
//        System.out.println(originUsername);
//
//        String originPassword = environment.getProperty("spring.datasource.password");
//        String encryptPassword = encrypt(originPassword);
//        System.out.println(originPassword);
//
//        log.info("結束測試 Service");
//    }
//
//}
