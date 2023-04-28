package com.fresh.jianhongl.demo.log4j;

import org.apache.log4j.Logger;


public class MainEntry {
    // 这里的Logger的类是引用的是: org.apache.log4j.Logger. 也就是具体的log实现框架.
    private static final Logger logger = Logger.getLogger(MainEntry.class);

    public static void main(String[] args) {

        logger.trace("Trace message.");
        logger.debug("Debug message.");
        logger.info("Info message.");
        logger.warn("Warn message.");
        logger.error("Error message.");
        logger.fatal("Fatal message.");
    }
}
