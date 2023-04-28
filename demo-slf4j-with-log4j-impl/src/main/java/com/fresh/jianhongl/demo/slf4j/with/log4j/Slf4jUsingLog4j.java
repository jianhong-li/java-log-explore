package com.fresh.jianhongl.demo.slf4j.with.log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jUsingLog4j {

    public static final Logger logger = LoggerFactory.getLogger(Slf4jUsingLog4j.class);

    public static void main(String[] args) {
        logger.info("这是一个使用slf4j接口的日志,具体使用log4j实现: info ....");
        logger.warn("这是一个使用slf4j接口的日志,具体使用log4j实现: warn ....");
        logger.error("这是一个使用slf4j接口的日志,具体使用log4j实现: error ....");
        logger.debug("这是一个使用slf4j接口的日志,具体使用log4j实现: debug ....");
        logger.trace("这是一个使用slf4j接口的日志,具体使用log4j实现: trace ....");
    }
}
