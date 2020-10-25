## 0x01 简介
`woodpecker-framework`框架jackson漏洞荷载生成插件。目前可以生成如下payload：

* jndi
* local code exec

## 0x02 编译

```
mvn package
```

## 0x03 使用

将编译好的插件复制到`woodpecker-framework`的`plugin`目录下

![](doc/jackson-vuldb.png)