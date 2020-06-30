# basket-fiona
1、使用spring boot和sqllite写的一个篮球报名系统，包括一个报名页和后台查询已报名学生的网页
2、后台使用spring security实现鉴权
3、部署在阿里云服务器
   刚购买的阿里云服务器，需要重置实例密码，安装jdk，配置安全组，开放80端口
4、步骤：
   scp basket-0.0.1-SNAPSHOT.jar root@47.114.100.253:/home/clm
   jps
   nohup java -jar basket-0.0.1-SNAPSHOT.jar --server.port=80 nohup.out 2>&1 &


