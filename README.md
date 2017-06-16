# OpenApi Demo Java

* 该工程是一个标准的`Java web`工程, 打好的`war`包可以部署到`tomcat`等`servlet`容器
* 工程使用`maven`构建请提前安装`maven`, 打包命令:`mvn clean package`
* 配置修改, 工程使用的配置文件`src/main/resources/app.properties`,详细配置说明如下:

```properties
#应用appId
openapi.appId=94181123
#应用密钥
openapi.appSecret=6fe73d451cd37f8a
#开放平台接口地址必须以"/"结尾
openapi.http.baseUrl=http://10.0.10.49:8081/openapi/
#接口建立连接超时时间
openapi.http.connectTimeoutMillis=3000
```
