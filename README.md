> 背景: 
> 不知道你是否在看到一堆的日志配置时手足无措,一些看起来很相似的包,不知道该用哪一个. 

比如: 
- `log4j-over-slf4j.jar`
- `slf4j-log4j12.jar`
- `log4j-slf4j-impl.jar`

这些包看起来非常相似,名称经常换来换去. 不知道该引入哪一个好. 如果都存在,又会产生什么问题. 而这个Project就是来把这些问题一一说明白的.

# java-log-explore

此项目旨在搞明白java不同的日志框架之间的使用细节. 旨在理明白那些让人迷惑的日志桥接以及混用的处理办法. 对于每一种典型的用法提供一个完整的最小demo.
争取把所有的问题一次性说明白. 


## log4j-over-slf4j.jar AND bound slf4j-log4j12.jar on the class path 是什么问题 

这个问题通常发生在使用 slf4j 和 log4j 的组合记录日志时，出现了两个日志框架互相依赖的情况。其中 log4j-over-slf4j.jar 是 slf4j 提供的一种适配器，在使用 slf4j-wrapped log4j 时使用的，而 slf4j-log4j12.jar 是 slf4j 和 log4j 集成的一个 jar 包。

这个问题的原因是，log4j-over-slf4j.jar 和 slf4j-log4j12.jar 都包含了 slf4j 和 log4j 的相关类。在应用程序的 classpath 上如果同时存在这两个 jar 包，就会出现类冲突，导致日志框架无法正确记录日志信息，出现不可预期的错误和异常。

解决这个问题的方法是，只选择使用其中一个日志框架并移除另一个依赖。如果选择使用 log4j，就需把 log4j-over-slf4j.jar 从 classpath 中排除，并只使用 slf4j-log4j12.jar。反之亦然，如果选择使用 slf4j，就需把 slf4j-log4j12.jar 从 classpath 中排除，并确保只使用 log4j-over-slf4j.jar。

在 Maven 中，可以通过在 pom.xml 文件中排除不需要的依赖来解决这个问题。例如：


```xml
<dependencies>  
  <dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>1.7.25</version>
    <scope>compile</scope>
  </dependency>  
  <dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>log4j-over-slf4j</artifactId>
    <version>1.7.25</version>
    <scope>compile</scope>
    <exclusions>
      <exclusion>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-log4j12</artifactId>
      </exclusion>
    </exclusions>
  </dependency>
</dependencies>
```