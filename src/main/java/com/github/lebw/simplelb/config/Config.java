package com.github.lebw.simplelb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Value(value = "${com.github.lebw.simplelb.backEnds}")
    private String backEndURLs;

    @Bean
    public String[] getURLs() {
        return checkValue(backEndURLs);
    }

    private String[] checkValue(String backEndURLs) {
        String[] urlArray = backEndURLs.split(",");
        int len = urlArray.length;
        if (len <= 0) {
            System.out.println("Error: No URLs.");
            return null;
        }
        System.out.printf("一共发现%d个服务器\n", len);
        for (int i = 0; i < len; i++) {
            System.out.printf("服务器%d: %s\n", i+1, urlArray[i]);
        }
        return urlArray;
    }
}
