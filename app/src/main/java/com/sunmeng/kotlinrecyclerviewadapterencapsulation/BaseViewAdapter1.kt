package com.sunmeng.kotlinrecyclerviewadapterencapsulation

import android.content.Context
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.databinding.DataBindingUtil
import android.os.Build.VERSION_CODES.M
import android.support.annotation.LayoutRes


/**
 * Created by sunmeng on 2017/12/22.
 * Email:sunmeng995@gmail.com
 * Description:
 */
abstract class BaseViewAdapter1<in M, in B : ViewDataBinding>(private var context: Context, private var items: MutableList<M>)
    : RecyclerView.Adapter<BaseBindingViewHolder<ViewDataBinding>>() {


    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseBindingViewHolder<ViewDataBinding> {
        return BaseBindingViewHolder(DataBindingUtil.inflate<B>(LayoutInflater.from(this.context), this.getLayoutResId(viewType), parent, false))
    }

    override fun onBindViewHolder(holder: BaseBindingViewHolder<ViewDataBinding>?, position: Int) {
        val binding = DataBindingUtil.getBinding<B>(holder?.itemView)
        this.onBindItem(binding, this.items[position])
    }

    @LayoutRes protected abstract fun getLayoutResId(viewType: Int): Int

    protected abstract fun onBindItem(binding: B, item: M)

}