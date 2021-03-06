整合思路
![SSM框架架构图](https://upload-images.jianshu.io/upload_images/6010417-c70f2fc5b8847daf.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
#####1 整合dao层

mybatis和springmvc整合，通过spring管理mapper接口

使用mapper的扫描器自动扫描mapper接口在spring中注册

#####3 整合service层

通过spring管理servic接口

使用配置方式将service接口配置在spring配置文件中，实现事物控制

#####4 整合springmvc

由于springmvc是spring的模块，不需要整合

遇到问题

1 在配置监听器时，导入文件错误，应该倒入
![正确导入](https://upload-images.jianshu.io/upload_images/6010417-0c0f1a6eb88d45be.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

自己错误导入成`org.springframework.web.context.ContextCleanupListener`

2 在springmvc配置文件中，可以使用`<mvc:annotation-driven />`代替映射器和适配器配置，自己在配置过程中导入错误的头文件，导致配置无法识别

3 jdk版本不要过高

[整合详细说明](https://www.jianshu.com/p/dd1d957ea715)

功能说明 

简单的crud操作例如：商品信息查询，商品信息修改，商品批量删除[参数绑定](https://www.jianshu.com/p/4958085f4d03)

[商品修改信息效验](https://www.jianshu.com/p/200a5a9b1281)

[异常处理](https://www.jianshu.com/p/e5e71414a21e)

[图片上传](https://www.jianshu.com/p/c118888bec5f)

[json数据交互](https://www.jianshu.com/p/7b20248ce88e)

[RESTful支持](https://www.jianshu.com/p/2efc6f42aa17)
