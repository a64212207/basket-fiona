# basket-fiona
1、使用spring boot和sqllite写的一个篮球报名系统，包括一个报名页和后台查询已报名学生的网页
2、后台使用spring security实现鉴权
3、部署在阿里云服务器
4、步骤：
   scp basket-0.0.1-SNAPSHOT.jar root@39.106.26.198:/home/clm
   jps
   nohup java -jar basket-0.0.1-SNAPSHOT.jar --server.port=80 nohup.out 2>&1 &
