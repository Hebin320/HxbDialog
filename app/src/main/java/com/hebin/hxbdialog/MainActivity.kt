package com.hebin.hxbdialog

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import com.hebin.dialog.UniversalDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_test.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("RtlHardcoded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnShow.setOnClickListener {
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
        }
    }
}
