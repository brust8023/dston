litemall
=====

又一个小商场系统。

项目代码
====

* [码云](https://gitee.com/linlinjava/litemall)
* [GitHub](https://github.com/linlinjava/litemall)

项目架构
====
![](./doc/pic/1.png)    

技术栈
===

> 1. Spring Boot
> 2. Vue
> 3. 微信小程序

![](doc/pic/2.png)    

效果
==

### 小商城效果

![](doc/pic/3.png)    

* 首页
* 专题列表、专题详情
* 分类列表、分类详情
* 品牌列表、品牌详情
* 新品首发
* 人气推荐
* 商品搜索
* 商品详情
* 商品评价列表、商品评价
* 购物车
* 下单
* 我的主页
* 订单列表、订单详情
* 地址列表、地址添加、地址删除
* 我的收藏
* 我的足迹


### 管理平台效果

![](doc/pic/4.png)    

* 会员管理

* 商场管理

* 商品管理

* 推广管理

* 系统管理


云演示
==

### 小商城演示访问

由于没有上线，只能在微信开发工具中测试运行：

1. 微信开发工具导入litemall-wx项目;
2. 项目配置，启用“不校验合法域名、web-view（业务域名）、TLS 版本以及 HTTPS 证书”
3. 点击“编译”，即可在微信开发工具预览效果；
4. 也可以点击“预览”，然后手机扫描登陆。

![](doc/pic/5.gif)    

### 管理平台演示访问

1. 浏览器打开，输入以下网址`http://122.152.206.172:8080/#/login`
2. 用户名`admin123`，密码`admin123`

文档
==

1. [系统架构](doc/1.md)
2. [基础子系统](doc/2.md)
3. [小程序子系统](doc/3.md)
4. [管理后台子系统](doc/4.md)
5. [商场子系统](doc/5.md)
6. [下一步计划](doc/6.md)

更新
==

* V 0.1.0，项目架构基本完成。
  
警告
==

> 1. 本项目仅用于学习练习
> 2. 数据库数据来自nideshop
> 3. 项目代码目前还不完善，仍处在开发中
> 4. 项目开源（MIT），但不承担任何使用后果


致谢
==

本项目基于或参考以下项目：
> 1. [nideshop-mini-program](https://github.com/tumobi/nideshop-mini-program)
> 如果后端希望采用nodejs，用户可以访问nideshop项目
> 2. [platform](https://gitee.com/fuyang_lipengjun/platform)
> 如果后端希望采用非spring boot版的普通spring版或者更多功能，
> 用户可以访问platform项目
> 3. [vue-element-admin](https://github.com/PanJiaChen/vue-element-admin)
> 一个基于Vue和Element的后台集成方案

本项目所依赖的其他开源项目见相关章节

问题
==

用户有问题或者好的建议可以用Issues反馈交流，请给出详细信息，本人会尽可能解决。
 * 如果问题是共性问题（如代码bug或文档不全），本人会及时解决。
 * 如果问题是个人问题（如用户了解不深入或者没有相关技术），请见谅（本人也是百度和谷歌）。