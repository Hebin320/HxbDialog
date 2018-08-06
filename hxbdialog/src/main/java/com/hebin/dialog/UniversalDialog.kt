package com.hebin.dialog

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window

/**
 * Author Hebin
 * <p>
 * created at 2018/8/1 15:36
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * describe：设置通用的Dialog
 */
@SuppressLint("StaticFieldLeak")
object UniversalDialog {


    // 宽度全屏、高度自适应
    const val WIDTH_MATCH_PARENT = 1
    // 高度全屏、宽度自适应
    const val HEIGHT_MATCH_PARENT = 2
    // 宽、高自适应
    const val ALL_WRAP_CONTENT = 3
    // 宽、高全屏
    const val ALL_MATCH_PARENT = 4
    private var isTransparent: Boolean = false
    private var canceledOnTouchOutside: Boolean = true
    private var type: Int = 3
    private var layoutId: Int = 0
    private var animations: Int = 0
    private var marginX: Int = 0
    private var marginY: Int = 0
    private var gravity: Int = Gravity.CENTER
    private var mContext: Context? = null

    fun setContext(context: Context): UniversalDialog {
        this.mContext = context
        return this
    }

    fun setCanceledOnTouchOutside(canceledOnTouchOutside: Boolean): UniversalDialog {
        this.canceledOnTouchOutside = canceledOnTouchOutside
        return this
    }


    // 设置背景透明，默认背景是模糊的
    fun setTransparent(): UniversalDialog {
        isTransparent = true
        return this
    }

    // 对话框类型
    fun setType(type: Int): UniversalDialog {
        this.type = type
        return this
    }

    // 布局
    fun setLayoutId(layoutId: Int): UniversalDialog {
        this.layoutId = layoutId
        return this
    }

    // 动画
    fun setAnimations(animations: Int): UniversalDialog {
        this.animations = animations
        return this
    }

    // 位置，默认居中
    fun setGravity(gravity: Int): UniversalDialog {
        this.gravity = gravity
        return this
    }

    // X轴边距
    fun setMarginX(marginX: Int): UniversalDialog {
        this.marginX = marginX
        return this
    }

    // Y轴边距
    fun setMarginY(marginY: Int): UniversalDialog {
        this.marginY = marginY
        return this
    }


    fun show(): Dialog {
        val dialog = if (isTransparent) {
            Dialog(mContext, R.style.dialog_transparent)
        } else {
            Dialog(mContext, R.style.dialog_dimenabled)
        }
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(layoutId)
        dialog.setCanceledOnTouchOutside(canceledOnTouchOutside)
        val dialogwindow = dialog.window!!
        dialogwindow.setWindowAnimations(animations)
        val lp = dialogwindow.attributes
        dialogwindow.setGravity(gravity)
        when (type) {
            ALL_WRAP_CONTENT -> {
                lp.width = ViewGroup.LayoutParams.WRAP_CONTENT
                lp.height = ViewGroup.LayoutParams.WRAP_CONTENT
            }
            WIDTH_MATCH_PARENT -> {
                lp.width = ViewGroup.LayoutParams.MATCH_PARENT
                lp.height = ViewGroup.LayoutParams.WRAP_CONTENT
            }
            HEIGHT_MATCH_PARENT -> {
                lp.width = ViewGroup.LayoutParams.WRAP_CONTENT
                lp.height = ViewGroup.LayoutParams.MATCH_PARENT
            }
            ALL_MATCH_PARENT -> {
                lp.width = ViewGroup.LayoutParams.MATCH_PARENT
                lp.height = ViewGroup.LayoutParams.MATCH_PARENT
            }
        }
        lp.x = marginX
        lp.y = marginY
        dialogwindow.attributes = lp
        dialog.show()
        return dialog
    }
}