package com.sunmeng.kotlinrecyclerviewadapterencapsulation

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

/**
 * Created by sunmeng on 2017/12/22.
 * Email:sunmeng995@gmail.com
 * Description:
 */
class BaseBindingViewHolder<out T : ViewDataBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root)