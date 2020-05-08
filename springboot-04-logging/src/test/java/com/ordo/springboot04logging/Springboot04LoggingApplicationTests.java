package com.ordo.springboot04logging;

import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class Springboot04LoggingApplicationTests {

    @Test
    public void contextLoads() {
        //日志记录器
        Logger logger = LoggerFactory.getLogger(getClass());//用slf4j的jar
        logger.trace("这是trace日志...");
        logger.debug("这是bebug日志...");
    }

}
