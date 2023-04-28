package com.fresh.jianhongl.demo.logback.single;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;

public class LogbackSingleDemo {

    public static void main(String[] args) {

        // 这个 demo 中使用了 Logback 自带的 Logger 对象，可以通过 LoggerContext 来获取它。
        // 然后，通过 Level 对象设置日志级别，
        // 使用 Logger.debug()、Logger.info()、Logger.warn()、Logger.error() 等方法来输出日志。
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        Logger logger = loggerContext.getLogger(LogbackSingleDemo.class);

        logger.setLevel(Level.INFO);

        logger.debug("Debug message");
        logger.info("Info message");
        logger.warn("Warn message");
        logger.error("Error message");
    }
}
