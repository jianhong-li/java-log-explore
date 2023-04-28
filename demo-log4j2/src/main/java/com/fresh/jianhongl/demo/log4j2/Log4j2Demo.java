package com.fresh.jianhongl.demo.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Demo {

    // ERROR StatusLogger Log4j2 could not find a logging implementation. Please add log4j-core to the classpath. Using SimpleLogger to log to the console...
    // 注意这里的Logger是引用的是 log4j-api中定义的api接口.
    // 此时如果没有同时引入实现包: log4j-core , 就会报这里第一行注释说明的问题. 
    private static final Logger logger = LogManager.getLogger(Log4j2Demo.class);

    public static void main(String[] args) {
        logger.trace("Trace level message");
        logger.debug("Debug level message");
        logger.info("Info level message");
        logger.warn("Warn level message----");
        logger.error("Error level message----");
        logger.fatal("Fatal level message---");
    }
}
