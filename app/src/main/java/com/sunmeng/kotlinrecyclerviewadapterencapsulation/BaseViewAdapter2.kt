package com.sunmeng.kotlinrecyclerviewadapterencapsulation

import android.content.Context
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.databinding.DataBindingUtil
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import android.support.annotation.LayoutRes

/**
 * Created by sunmeng on 2017/12/22.
 * Email:sunmeng995@gmail.com
 * Description:
 */
abstract class BaseViewAdapter2<M, in B : ViewDataBinding>(private var context: Context)
    : RecyclerView.Adapter<BaseBindingViewHolder<ViewDataBinding>>() {

    var items: ObservableList<M> = ObservableArrayList<M>()
    private var itemsChangeCallback:ListChangedCallback=ListChangedCallback()

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


    override fun onAttachedToRecyclerView(recyclerView: RecyclerView?) {
        super.onAttachedToRecyclerView(recyclerView)
        items.addOnListChangedCallback(itemsChangeCallback)
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView?) {
        super.onDetachedFromRecyclerView(recyclerView)
        this.items.removeOnListChangedCallback(itemsChangeCallback)
    }

    protected fun onChanged(newItems: ObservableArrayList<M>) {
        resetItems(newItems)
        notifyDataSetChanged()
    }

    protected fun onItemRangeChanged(newItems: ObservableArrayList<M>, positionStart: Int, itemCount: Int) {
        resetItems(newItems)
        notifyItemRangeChanged(positionStart, itemCount)
    }

    protected fun onItemRangeInserted(newItems: ObservableArrayList<M>, positionStart: Int, itemCount: Int) {
        resetItems(newItems)
        notifyItemRangeInserted(positionStart, itemCount)
    }

    protected fun onItemRangeMoved(newItems: ObservableArrayList<M>) {
        resetItems(newItems)
        notifyDataSetChanged()
    }

    protected fun onItemRangeRemoved(newItems: ObservableArrayList<M>, positionStart: Int, itemCount: Int) {
        resetItems(newItems)
        notifyItemRangeRemoved(positionStart, itemCount)
    }

    private fun resetItems(newItems: ObservableArrayList<M>) {
        this.items = newItems
    }

    internal inner class ListChangedCallback : ObservableList.OnListChangedCallback<ObservableArrayList<M>>() {
        override fun onChanged(newItems: ObservableArrayList<M>) {
            this@BaseViewAdapter2.onChanged(newItems)
        }

        override fun onItemRangeChanged(newItems: ObservableArrayList<M>, i: Int, i1: Int) {
            this@BaseViewAdapter2.onItemRangeChanged(newItems, i, i1)
        }

        override fun onItemRangeInserted(newItems: ObservableArrayList<M>, i: Int, i1: Int) {
            this@BaseViewAdapter2.onItemRangeInserted(newItems, i, i1)
        }

        override fun onItemRangeMoved(newItems: ObservableArrayList<M>, i: Int, i1: Int, i2: Int) {
            this@BaseViewAdapter2.onItemRangeMoved(newItems)
        }

        override fun onItemRangeRemoved(sender: ObservableArrayList<M>, positionStart: Int, itemCount: Int) {
            this@BaseViewAdapter2.onItemRangeRemoved(sender, positionStart, itemCount)
        }
    }

}