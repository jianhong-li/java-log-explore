这是一个完整的log4j2示例.并且没有依赖slf4j框架. 


log4j2 的配置文件是必须的，用于配置 log4j2 的行为和输出方式。以下是一个简单的 log4j2 配置文件示例，你可以将它放在项目的 src/main/resources 目录下，命名为 log4j2.xml。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="WARN">
    <Appenders>
        <Console name="console" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n" />
        </Console>
    </Appenders>
    <Loggers>
        <Root level="debug">
            <AppenderRef ref="console" />
        </Root>
    </Loggers>
</Configuration>
```


上述配置文件中定义了一个 console 的 Appender，目标是 SYSTEM_OUT，也就是输出到 console。然后我们定义了一个 PatternLayout，这个 Layout 将日志记录的时间、线程、日志级别、Logger 名称以及日志内容输出到 console。

接着，我们定义了一个 logger，并将其绑定到根 logger 上。在这里，我们将日志级别设置成 debug，因此所有 debug 级别及以上的日志记录都会进入该 logger，并通过 Appender 输出到 console 中。

需要注意的是，log4j2.xml 配置文件和 Log4j2Demo.java 文件必须位于同一级目录下，才能被正确读取。如果配置文件名称或路径不同，需要在代码中指定配置文件的路径。

希望这个例子能帮助你更好地了解 log4j2 的使用。