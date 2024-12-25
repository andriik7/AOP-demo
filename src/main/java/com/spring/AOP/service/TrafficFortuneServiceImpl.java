package com.spring.AOP.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {

    Logger logger = LogManager.getLogger(TrafficFortuneServiceImpl.class);

    @Override
    public void getFortune(boolean tripWire) {
        logger.warn("Executing void getFortune(boolean tripWire) method");
        if (tripWire) {
            throw new RuntimeException("Exception caused!");
        }
        getFortune();
    }

    @Override
    public String getFortune() {

        logger.warn("Executing getFortune() method");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "The result of getFortune()";
    }
}
