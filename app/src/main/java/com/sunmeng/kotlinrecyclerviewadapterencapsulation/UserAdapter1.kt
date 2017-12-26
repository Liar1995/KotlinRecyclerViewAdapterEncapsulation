package com.sunmeng.kotlinrecyclerviewadapterencapsulation

import android.content.Context
import android.databinding.DataBindingUtil
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
class UserAdapter1(private var context: Context, private var items:MutableList<User>) : RecyclerView.Adapter<UserAdapter1.UserViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): UserViewHolder {
        val itemUserBinding = DataBindingUtil.inflate<ItemUserBinding>(LayoutInflater.from(context), R.layout.item_user, parent, false)
        return UserViewHolder(itemUserBinding.root)
    }

    override fun onBindViewHolder(holder: UserViewHolder?, position: Int) {
        val binding=DataBindingUtil.getBinding<ItemUserBinding>(holder?.itemView)
        binding.model=items[position]
        binding.executePendingBindings()
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}