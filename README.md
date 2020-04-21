#### 1. 需求与功能

角色：**普通访客**，**管理员**

- 访客，可以分页查看所有的博客
- 访客，可以快速查看博客数最多的6个分类
- 访客，可以查看所有的分类
- 访客，可以查看某个分类下的博客列表
- 访客，可以快速查看标记博客最多的10个标签
- 访客，可以查看所有的标签
- 访客，可以查看某个标签下的博客列表
- 访客，可以根据年度时间线查看博客列表
- 访客，可以快速查看最新的推荐博客
- 访客，可以用关键字全局搜索博客
- 访客，可以查看单个博客内容
- 访客，可以对博客内容进行评论
- 访客，可以赞赏博客内容
- 访客，可以微信扫码阅读博客内容
- 访客，可以查看音乐节目，播放音乐
- 访客，可以在首页扫描公众号二维码关注
- 管理员，可以用户名和密码登录后台管理
- 管理员，可以管理音乐列表：添加/改变/删除
- 管理员，可以管理博客
  - 管理员，可以发布新博客
  - 管理员，可以对博客进行分类
  - 管理员，可以对博客打标签
  - 管理员，可以修改博客
  - 管理员，可以删除博客
  - 管理员，可以根据标题，分类，标签查询博客
- 管理员，可以管理博客分类
  - 管理员，可以新增一个分类
  - 管理员，可以修改一个分类
  - 管理员，可以删除一个分类
  - 管理员，可以根据分类名称查询分类
- 管理员，可以管理标签
  - 管理员，可以新增一个标签
  - 管理员，可以修改一个标签
  - 管理员，可以删除一个标签
  - 管理员，可以根据名称查询标签

#### 2. 页面设计

#### 3. 框架

##### 1. 异常处理

###### 异常错误定义

- 404


- 500
- 自定义错误

##### 2.日志处理（AOP）

- 请求 url
- 访问 ip
- 调用方法 method
- 参数 args
- 返回内容

#### 4.设计规范

- ##### 4.1 实体类设计

  - 博客类 Blog

  - 分类 Type

  - 标签 Tag 

  - 评论 Comment

  - 用户 User

    ##### 实体关系：

    ![1587441342889](C:\Users\boluofan\AppData\Local\Temp\1587441342889.png)

    ##### 评论类关系：（自关联）

    ![1587441473054](C:\Users\boluofan\AppData\Local\Temp\1587441473054.png)

    ##### 类属性：

    - Blog类:

      | 名称     | 字段           | 字段    | 备注     |
      | -------- | -------------- | ------- | -------- |
      | 标题     | title          | long    |          |
      | 内容     | content        | String  |          |
      | 首图     | firstImg       | String  |          |
      | 标记     | flag           | String  |          |
      | 浏览次数 | views          | Integer |          |
      | 赞赏开启 | openAppreciate | boolean |          |
      | 版权开启 | openCopyright  | boolean | 转载声明 |
      | 评论开启 | openComment    | boolean |          |
      | 推荐状态 | isRecommend    | boolean |          |
      | 发布状态 | isRelease      | boolean |          |
      | 创建时间 | createTime     | Date    |          |
      | 更新时间 | updateTime     | Date    |          |

    - Type类：

      | 名称 | 字段 | 字段   | 备注 |
      | ---- | ---- | ------ | ---- |
      | 名称 | name | String |      |

    - Tag类：

      | 名称 | 字段 | 字段   | 备注 |
      | ---- | ---- | ------ | ---- |
      | 名称 | name | String |      |

    - Comment类：

      | 名称     | 字段       | 字段   | 备注 |
      | -------- | ---------- | ------ | ---- |
      | 昵称     | nickname   | String |      |
      | 邮箱     | email      | String |      |
      | 评论内容 | content    | String |      |
      | 创建时间 | updateTime | Date   |      |
      | 头像     | avatar     | String |      |

    ​

    - User类：

      | 名称     | 字段       | 字段    | 备注               |
      | -------- | ---------- | ------- | ------------------ |
      | 昵称     | nickname   | String  |                    |
      | 用户名   | username   | String  |                    |
      | 密码     | password   | String  |                    |
      | 邮箱     | email      | String  |                    |
      | 类型     | type       | Integer | 用户类型，角色分类 |
      | 头像     | avatar     | String  |                    |
      | 创建时间 | createTime | Date    |                    |
      | 更新时间 | updateTime | Date    |                    |

  ##### 4.2 命名约定

  - 获取单个对象用get做前缀
  - 获取多个对象用list做前缀
  - 获取统计数据用count做前缀
  - 插入数据用save做前缀
  - 删除数据用remove做前缀
  - 修改数据用update做前缀

#### 5. 功能实现



