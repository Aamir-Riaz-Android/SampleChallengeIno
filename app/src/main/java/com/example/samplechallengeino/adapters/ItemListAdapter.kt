package com.example.samplechallengeino.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.samplechallengeino.databinding.ItemsRowBinding
import com.example.samplechallengeino.models.response.Item
import javax.inject.Inject

class  ItemListAdapter @Inject constructor():RecyclerView.Adapter<ItemListAdapter.ItemsViewHolder>() {

  private var itemList = ArrayList<Item>()
     inner  class ItemsViewHolder( private val itemsRowBinding: ItemsRowBinding):RecyclerView.ViewHolder(itemsRowBinding.root){
        fun bindData(items:Item){
            itemsRowBinding.apply {
                this.tvItemName.text=items.name
                this.tvPrice.text="Price:${items.price}"
                this.tvItemDesc.text=items.description
                if(items.description.isNullOrEmpty()) tvItemDesc.visibility= View.GONE
                else tvItemDesc.visibility= View.VISIBLE

            }

        }

    }
    fun setItemList(newListOfNewsItems: List<Item>) {
        itemList = ArrayList<Item>()
        itemList.addAll(newListOfNewsItems )
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        return ItemsViewHolder(
            ItemsRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.bindData(itemList[position])
    }

    override fun getItemCount(): Int {
        return  itemList.size
    }
}