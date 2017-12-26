package com.sunmeng.kotlinrecyclerviewadapterencapsulation

import android.content.Context
import com.sunmeng.kotlinrecyclerviewadapterencapsulation.databinding.ItemUserBinding

/**
 * Created by sunmeng on 2017/12/22.
 * Email:sunmeng995@gmail.com
 * Description:
 */
class UserAdapter3(context: Context, items: MutableList<User>) : BaseViewAdapter1<User, ItemUserBinding>(context, items) {
    override fun getLayoutResId(viewType: Int): Int = R.layout.item_user
    override fun onBindItem(binding: ItemUserBinding, item: User) {
        binding.model=item
        binding.executePendingBindings()
    }
}