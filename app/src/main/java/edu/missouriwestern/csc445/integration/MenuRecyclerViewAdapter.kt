package edu.missouriwestern.csc445.integration

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater

class MenuRecyclerViewAdapter(var context: Context, var foods:List<Food>): RecyclerView.Adapter<MenuRecyclerViewAdapter.MenuItemViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_food_list, parent, false)
        return MenuItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return foods.size
    }

    override fun onBindViewHolder(holder: MenuItemViewHolder, position: Int) {
        holder.imageView!!.setImageResource(foods[position].image)
        holder.titleTextView!!.setText(foods[position].title)
        holder.descTextView!!.setText(foods[position].description)
    }


    class MenuItemViewHolder(view:View): RecyclerView.ViewHolder(view) {
        var imageView: ImageView? = null
        var titleTextView: TextView? = null
        var descTextView: TextView? = null

        init {
            imageView = itemView.findViewById(R.id.foodImage)
            titleTextView = itemView.findViewById(R.id.foodName)
            descTextView = itemView.findViewById(R.id.foodDesc)
        }
    }
}