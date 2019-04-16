package edu.missouriwestern.csc445.integration

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.os.Bundle
import androidx.fragment.app.Fragment
import edu.missouriwestern.csc445.integration.fragments.MenuFragment


class RestaurantsRecyclerViewAdapter(var context: Context, var restaurants:List<Restaurant>): RecyclerView.Adapter<RestaurantsRecyclerViewAdapter.RestaurantViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        //Inflat the restaurant item view
        val view = LayoutInflater.from(context).inflate(R.layout.item_restaurant_list, parent, false)
        return RestaurantViewHolder(view)
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        holder.imageView.setImageResource(restaurants[position].restaurantImage)
        holder.nameTextView.setText(restaurants[position].restaurantName)
        holder.restaurant = restaurants[position]
        holder.context = context
    }

    //ViewHolder takes a view and connect its fields with the widgets we have in that view.
    class RestaurantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        lateinit var imageView: ImageView
        lateinit var nameTextView: TextView
        lateinit var restaurant: Restaurant
        lateinit var context: Context

        init {
            imageView = itemView.findViewById(R.id.restaurant_image)
            nameTextView = itemView.findViewById(R.id.restaurant_name)
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            Log.d("RecyclerView", "CLICK!")
            fragmentJump(restaurant);
        }

        private fun fragmentJump(restaurantSelected: Restaurant) {
            var mFragment = MenuFragment()
            var mBundle = Bundle()
            mBundle.putString("restaurantName", restaurantSelected.restaurantName)
            mFragment.setArguments(mBundle)
            switchContent(R.id.fragment_restaurants, mFragment)
        }

        fun switchContent(id: Int, fragment: Fragment) {
            if (context == null)
                return
            if (context is MainActivity) {
                val mainActivity = context as MainActivity
                mainActivity.switchContent(id, fragment)
            }
        }
    }
}