# 前言
在实际开发中，如果遇到多次使用同一个功能，那么我们会把这个功能封装成一个模块，方便在日后开发中调用。功能模块有很多种，其中，最为常用的，应该就是dialog模块。请求成功要弹框、请求失败要弹框、权限不足要弹框、没登录要弹框、会员也要弹框，在APP开发中，弹框几乎是无处不在的。那么，如果每个弹框都要手写，那工作量是巨大的。所以，我就自己封装了一个通用的，创建dialog的工具类，方便于快速开发一个dialog。
<h3>导入</h3>

```
compile 'com.hebin:hxbdialog:1.0.0'
```
<h3>使用</h3>
导入库之后，就可以使用了，具体使用如下：

```
	val dialog = UniversalDialog
                    .setContext(this@MainActivity)
                    // 设置dialog布局
                    .setLayoutId(R.layout.dialog_test)
                    // 设置dialog的Gravity
                    .setGravity(Gravity.TOP or Gravity.RIGHT)
                    /*
                    * 设置dialog类型
                    *  <p>
                    * WIDTH_MATCH_PARENT 宽度全屏、高度自适应
                    * <p>
                    * HEIGHT_MATCH_PARENT 高度全屏、宽度自适应
                    * <p>
                    * ALL_WRAP_CONTENT 宽、高自适应
                    * <p>
                    * ALL_MATCH_PARENT宽、高全屏
                    * */
                    .setType(UniversalDialog.ALL_WRAP_CONTENT)
                    // 背景是否透明、不设置则背景模糊
                    .setTransparent()
                    // 点击dialog其他地方，dialog是否消失，true为可消失、false为不可消失
                    .setCanceledOnTouchOutside(true)
                    // 设置dialog的弹出、消失动画
                    .setAnimations(R.style.dialog_scale)
                    // 设置dialogY轴距离
                    .setMarginY(resources.getDimension(R.dimen.dp_10).toInt())
                    // 设置dialogX轴距离
                    .setMarginX(resources.getDimension(R.dimen.dp_10).toInt())
                    // 显示dialog
                    .show()
            dialog.tvTest.setOnClickListener {
                Toast.makeText(this@MainActivity, "点击了测试标题", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
```
因为工具类，接收的是layout，所以，基本上所有的dialog都是可以创建的，dialog的布局，在layout上实现，逻辑操作在拿到dialog之后，即可进行操作。
