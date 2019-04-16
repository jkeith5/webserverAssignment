package edu.missouriwestern.csc445.integration


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import edu.missouriwestern.csc445.integration.fragments.InfoFragment
import edu.missouriwestern.csc445.integration.fragments.MenuFragment
import edu.missouriwestern.csc445.integration.fragments.ReviewsFragment
import kotlinx.android.synthetic.main.fragment_restaurants.*

/**
 * A simple [Fragment] subclass.
 */
class RestaurantsFragment : Fragment() {

    lateinit var restaurantList:ArrayList<Restaurant>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_restaurants, container, false)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser && isResumed())
        {
            //Only manually call onResume if fragment is already visible
            //Otherwise allow natural fragment lifecycle to call onResume
            onResume();
        }
    }

    override fun onResume() {
        super.onResume()
        if (!getUserVisibleHint())
        {
            return;
        }
        populateRestaurants()

        val restaurantsRecyclerViewAdapter = RestaurantsRecyclerViewAdapter(context!!, restaurantList)
        restaurantsRecyclerView.layoutManager = LinearLayoutManager(context!!)
        restaurantsRecyclerView.adapter = restaurantsRecyclerViewAdapter

        Toast.makeText(activity, this.javaClass.simpleName + " is displayed.", Toast.LENGTH_SHORT).show();
    }

    fun populateRestaurants(){
        restaurantList = ArrayList<Restaurant>()
        restaurantList.add(Restaurant(R.drawable.r1, "Restaurant 1"))
        restaurantList.add(Restaurant(R.drawable.r2, "Restaurant 2"))
        restaurantList.add(Restaurant(R.drawable.r3, "Restaurant 3"))
    }
}
