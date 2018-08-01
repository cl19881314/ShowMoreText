package com.example.showmoretext

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.collapsible_textview.view.*

/**
 * @author Chenhong
 * @date 2018/7/20.
 * @des 底部换行显示 查看展开跟多
 */
class CollapsibleTextView : LinearLayout, View.OnClickListener {
    private var DEFAULT_MAX_LINE_COUNT = 3
    private var shrinkup: String ?= null
    private var spread: String ?= null
    private var flag: Boolean = false
    private var isFirst: Boolean = true

    constructor(context: Context, attrs: AttributeSet?) : super(context,attrs) {
        shrinkup = "收起"
        spread = "展开"
        val view = inflate(context, R.layout.collapsible_textview, this)
        view.setPadding(0, -1, 0, 0)
        desc_op_tv.setOnClickListener(this)
        desc_tv.maxLines = DEFAULT_MAX_LINE_COUNT
    }

    constructor(context: Context):  this(context, null)

    fun setDesc(charSequence: String) {
        desc_tv.text = charSequence
        requestLayout()
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
        val layout = desc_tv.layout
        val text = layout.text.toString()
        if (!isFirst){
            return
        }
        if (layout.lineCount < DEFAULT_MAX_LINE_COUNT){
            desc_op_tv.visibility = View.GONE
            return
        }
        var start = layout.getLineStart(DEFAULT_MAX_LINE_COUNT - 1)
        val end = layout.getLineEnd(DEFAULT_MAX_LINE_COUNT - 1)
        var res = text.substring(start, end)
        if (desc_tv.text.contains(res)){
            desc_op_tv.visibility = View.GONE
        } else {
            desc_op_tv.visibility = View.VISIBLE
        }
        isFirst = false
    }

    override fun onClick(v: View) {
        desc_tv.maxLines = if (flag) DEFAULT_MAX_LINE_COUNT else Integer.MAX_VALUE
        desc_op_tv.text = if (flag) spread else shrinkup
        flag = !flag
    }
}