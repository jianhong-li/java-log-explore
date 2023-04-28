package com.fresh.jianhongl.demo.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackDemo {
    private static Logger logger = LoggerFactory.getLogger(LogbackDemo.class);

    public static void main(String[] args) {
        logger.debug("Debug message");
        logger.info("Info message");
        logger.warn("Warn message");
        logger.error("Error message");
    }
}
