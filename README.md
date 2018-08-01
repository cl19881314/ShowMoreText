# ShowMoreText
动态设置TextView的maxLines

###设置“展开”文字显示状态
        val layout = desc_tv.layout
        val text = layout.text.toString()
  
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
