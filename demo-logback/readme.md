
> 注: 不使用slf4j版本的logback本身用起来是比较麻烦的. 还是推荐使用slf4j接口的 logback 



以下是一个使用 Logback 自带的 API，而不是使用 SLF4j 的 demo：


当然，以下是一个使用 Logback 自带的 API，而不是使用 SLF4j 的 demo：

首先，在 pom.xml 中添加 logback-classic 依赖：
```xml
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>1.2.3</version>
</dependency>
```

创建 logback.xml 文件，用于配置 Logback。

在代码中，使用 org.slf4j.Logger 和 org.slf4j.LoggerFactory 时一样的方式，定义一个 Logger 对象：

```java
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

```
这个 demo 中使用了 Logback 自带的 Logger 对象，可以通过 LoggerContext 来获取它。
然后，通过 Level 对象设置日志级别，
使用 Logger.debug()、Logger.info()、Logger.warn()、Logger.error() 等方法来输出日志。

