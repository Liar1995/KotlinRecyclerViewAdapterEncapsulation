package com.sunmeng.kotlinrecyclerviewadapterencapsulation

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sunmeng.kotlinrecyclerviewadapterencapsulation.databinding.ItemUserBinding

/**
 * Created by sunmeng on 2017/12/22.
 * Email:sunmeng995@gmail.com
 * Description:
 */
class UserAdapter2(private var context: Context, private var items:MutableList<User>) : RecyclerView.Adapter<BaseBindingViewHolder<ViewDataBinding>>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseBindingViewHolder<ViewDataBinding> {
        return BaseBindingViewHolder(DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(context), R.layout.item_user, parent, false))
    }

    override fun onBindViewHolder(holder: BaseBindingViewHolder<ViewDataBinding>?, position: Int) {
        val binding=DataBindingUtil.getBinding<ItemUserBinding>(holder?.itemView)
        binding.model=items[position]
        binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return items.size
    }



}