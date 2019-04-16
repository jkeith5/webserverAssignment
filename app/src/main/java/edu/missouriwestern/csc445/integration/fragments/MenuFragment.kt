package edu.missouriwestern.csc445.integration.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import edu.missouriwestern.csc445.integration.Food
import edu.missouriwestern.csc445.integration.MainActivity
import edu.missouriwestern.csc445.integration.MenuRecyclerViewAdapter
import edu.missouriwestern.csc445.integration.R

import kotlinx.android.synthetic.main.fragment_menu.*

/**
 * A simple [Fragment] subclass.
 */
class MenuFragment : Fragment() {

    lateinit var foodList:ArrayList<Food>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun setMenuVisibility(menuVisible: Boolean) {
        super.setMenuVisibility(menuVisible)
        if (menuVisible) {

        }
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
        populateFoods()

        val menuRecyclerViewAdapter = MenuRecyclerViewAdapter(context!!, foodList)
        menuRecyclerView.layoutManager = LinearLayoutManager(context!!)
        menuRecyclerView.adapter = menuRecyclerViewAdapter
        //I figured out what to use to get the current class's name generically.
        Toast.makeText(activity, this.javaClass.simpleName + " is displayed.", Toast.LENGTH_SHORT).show();
    }

    fun populateFoods(){
        foodList = ArrayList<Food>()
        foodList.add(Food(R.drawable.pizza, "Pizza", "Pizza has a lot of calories."))
        foodList.add(Food(R.drawable.bread, "Bread", "Bread may not be yummy."))
        foodList.add(Food(R.drawable.salad, "Salad", "Salad is typically healthy."))
        foodList.add(Food(R.drawable.taco, "Taco", "I can take some tacos."))
        foodList.add(Food(R.drawable.pizza, "Pizza", "Pizza has a lot of calories."))
        foodList.add(Food(R.drawable.bread, "Bread", "Bread may not be yummy."))
        foodList.add(Food(R.drawable.salad, "Salad", "Salad is typically healthy."))
        foodList.add(Food(R.drawable.taco, "Taco", "I can take some tacos."))
        foodList.add(Food(R.drawable.pizza, "Pizza", "Pizza has a lot of calories."))
        foodList.add(Food(R.drawable.bread, "Bread", "Bread may not be yummy."))
        foodList.add(Food(R.drawable.salad, "Salad", "Salad is typically healthy."))
        foodList.add(Food(R.drawable.taco, "Taco", "I can take some tacos."))
        foodList.add(Food(R.drawable.pizza, "Pizza", "Pizza has a lot of calories."))
        foodList.add(Food(R.drawable.bread, "Bread", "Bread may not be yummy."))
        foodList.add(Food(R.drawable.salad, "Salad", "Salad is typically healthy."))
        foodList.add(Food(R.drawable.taco, "Taco", "I can take some tacos."))
        foodList.add(Food(R.drawable.pizza, "Pizza", "Pizza has a lot of calories."))
        foodList.add(Food(R.drawable.bread, "Bread", "Bread may not be yummy."))
        foodList.add(Food(R.drawable.salad, "Salad", "Salad is typically healthy."))
        foodList.add(Food(R.drawable.taco, "Taco", "I can take some tacos."))
    }
}
