# Locker

## 开发环境
 - JDK1.8+
 
## 业务需求

需求描述：储物柜(Locker)可以存包、取包
![locker](./locker.png)

评分标准：参考Classroom中的评分标准Excel文档

### 需求澄清总结：

1. Given robot 管理 2 个 locker: lockerA, lockerB， lockerA 剩余容量大于B, 一个待存包，when 存包， then 存包于lockerA， 返回小票
2. Given robot 管理 2 个 locker: lockerA, lockerB， lockerB 剩余容量大于A, 一个待存包，when 存包， then 存包于lockerB， 返回小票
3.Given robot 管理 2 个 locker: lockerA, lockerB， lockerA 剩余容量等于B, 一个待存包，when 存包， then 存包于lockerA， 返回小票
4. Given robot 管理 2 个 locker: lockerA, lockerB， lockerA,B 均无空格, 一个待存包，when 存包， then 存包失败， 提示信息
5. Given robot 管理 2 个 locker, 1 张有效小票， when 取包， then 返回包
6. Given robot 管理 2 个 locker, 1 张无效小票，when 取包，then 不返回包，提示信息
