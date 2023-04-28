这里是一个基于 Logback 的 Java 日志完整示例：

首先，创建一个 Maven 项目，然后添加以下依赖项：


```xml
<dependencies>
  <!-- Logback Classic模块，包含logback-core模块 -->
  <dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>1.2.3</version>
  </dependency>
</dependencies>
```

友情提示: logback-classic 会依赖 logback-core , 换句话说: logback-classic 会间接引入 logback-core

![](logback-maven-dep.png)


接下来，创建一个名为 logback.xml 的文件，放在 src/main/resources 目录下，用于配置 Logback。以下是一个简单的配置例子：


```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <!--定义日志文件的存储路径和文件名-->
    <property name="LOG_HOME" value="./logs" />
    <property name="PATTERN" value="%d %p %c{1.} [%t] %m%n" />

    <!--控制台输出日志-->
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>${PATTERN}</pattern>
        </encoder>
    </appender>

    <!--按时间切割日志，每隔一天生成一个新的日志文件-->
    <appender name="ROL" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>${LOG_HOME}/test.log</file>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>${LOG_HOME}/test-%d{yyyy-MM-dd}.log</fileNamePattern>
        </rollingPolicy>
        <encoder>
            <pattern>${PATTERN}</pattern>
        </encoder>
    </appender>

    <!--默认日志级别：DEBUG-->
    <root level="DEBUG">
        <appender-ref ref="STDOUT" />
        <appender-ref ref="ROL" />
    </root>
</configuration>
```


该配置文件定义了两个 appender: STDOUT 和 ROL。STDOUT 负责将日志输出到控制台。ROL 负责将日志按时间切割，并将日志输出到文件中。每隔一天，将生成一个新的日志文件。

现在，编写一个使用这个日志配置的示例类：


```java
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

```
