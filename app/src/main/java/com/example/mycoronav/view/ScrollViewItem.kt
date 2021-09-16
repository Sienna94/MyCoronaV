package com.example.mycoronav.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.mycoronav.databinding.ItemRowBinding
import com.example.mycoronav.vo.Row

class ScrollViewItem: FrameLayout{
    lateinit var binding : ItemRowBinding
    var onClickDel : ((Row) -> Unit) ?= null

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(
        context: Context,
        attrs: AttributeSet?
    ) : super(context, attrs) {
        init()
    }

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init(){
        binding = ItemRowBinding.inflate(
            LayoutInflater.from(context),
            this,
            false
        )
        addView(binding.root)
    }

    fun bind(rowItem: Row){
        binding.tvId.text = rowItem.corona19Id
        binding.tvArea.text = rowItem.corona19Area
        binding.tvContactHistory.text = rowItem.corona19ContactHistory
        binding.tvInfectedDate.text = rowItem.corona19Date
        binding.delBtn.setOnClickListener { onClickDel?.invoke(rowItem) }
    }
}