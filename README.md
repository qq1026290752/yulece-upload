
- 上传地址:`http://47.94.90.76:8283/upload/file`

- 上传请求方式:`POST`

- 上传参数:`path`

- 参数类型:`file`

- 上传类型:`from`

- 上传大小限制:`50MB`

## 返回参数识别:

- 失败

  ```json
  {
  	"code": 1,
  	"data": null,
  	"message": "上传文件为空"
  }
  ```

  

- 成功 

  ```json
  {
  	"code": 0,
  	"data": null,
  	"message": "http://upload-1251448233.cosbj.myqcloud.com/201903234204021643753.png"
  }
  ```

