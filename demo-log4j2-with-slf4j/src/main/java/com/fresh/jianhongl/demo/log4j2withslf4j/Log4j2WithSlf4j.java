package com.fresh.jianhongl.demo.log4j2withslf4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2WithSlf4j {

    // 注意: 这个是最始的 log4j2 logger.  与直接组长 log4j-core & log4j-api 是一样的
    //      具体的由引入了 log4j-slf4j-impl-2.14.0.jar 后的不同的地方在于下面的示例
    // 即: 可以直接使用 slf4j的接口来声明日志,同时这个logger的记录最终也会转发到 log4j2
    private static final Logger logger = LogManager.getLogger(Log4j2WithSlf4j.class);

    // 注:
    // 这里的 Logger 和 LoggerFactory 都是由 slf4j-api包提供的api接口.
    // LoggerFactory.getLogger 在创建logger时, 会先实例化一个 logger工厂: org.slf4j.ILoggerFactory
    // 而这个工厂的实例是由:  org.slf4j.LoggerFactory.bind 方法查找类: "org/slf4j/impl/StaticLoggerBinder.class"; 来实现的.
    // 换句话说: 这个bind 函数会去查找全局 classpath 范围的这个 StaticLoggerBinder 的实现.
    // 而在这个环境下, 这个实现由:  log4j-slf4j-impl-2.14.0.jar 包中的
    // 类: log4j-slf4j-impl-2.14.0.jar!/org/slf4j/impl/StaticLoggerBinder.class 提供.
    // 而这个类: 最终是由 org.apache.logging.slf4j.Log4jLoggerFactory 这个工厂类来提供 logger的生成.
    //
    // 而最终生成的logger的实现类是  log4j-slf4j-impl-2.14.0.jar 包中的 org.apache.logging.slf4j.Log4jLogger 类.
    // 其一个具体的方法示例如下:
    //     public void trace(final String format) {
    //        this.logger.logIfEnabled(FQCN, Level.TRACE, (org.apache.logging.log4j.Marker)null, format);
    //    }
    // 这个类实际是一个代理类. 最终的logger是委托给了实现类. 这个对象中的实现类就是
    // private transient ExtendedLogger logger;
    // 这个 ExtendedLogger 的个路径是:  org.apache.logging.log4j.spi.ExtendedLogger (也就是 log4j-api包中的类)

    public static final org.slf4j.Logger slf4jLogger = org.slf4j.LoggerFactory.getLogger(Log4j2WithSlf4j.class);

    public static void main(String[] args) {
        logger.trace("Trace level message");
        logger.debug("Debug level message");
        logger.info("Info level message");
        logger.warn("Warn level message");
        logger.error("Error level message");
        logger.fatal("Fatal level message");


        System.out.println("------------");
        System.out.println("slf4jLogger's class:" + slf4jLogger.getClass());
        slf4jLogger.trace("Trace level message");
        slf4jLogger.debug("Debug level message");
        slf4jLogger.info("Info level message");
        slf4jLogger.warn("Warn level message");
        slf4jLogger.error("Error level message");
        // slf4jLogger.fatal("Fatal level message");
    }
}
