package edu.missouriwestern.csc445.integration


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.missouriwestern.csc445.integration.fragments.InfoFragment
import edu.missouriwestern.csc445.integration.fragments.MenuFragment
import edu.missouriwestern.csc445.integration.fragments.ReviewsFragment
import kotlinx.android.synthetic.main.fragment_single_restaurant.*

/**
 * A simple [Fragment] subclass.
 */
class SingleRestaurantFragment : Fragment() {

    lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurants, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        populateFragments()
    }

    fun populateFragments(){
        viewPagerAdapter = ViewPagerAdapter(activity!!.supportFragmentManager)
        viewPagerAdapter.addFragment(InfoFragment(), "Info", R.drawable.ic_info_outline_24dp)
        viewPagerAdapter.addFragment(MenuFragment(), "Menu", R.drawable.ic_menu_24dp)
        viewPagerAdapter.addFragment(ReviewsFragment(), "Reviews", R.drawable.ic_rate_review_24dp)

        viewPager.adapter = viewPagerAdapter

        for (i in 0 until tabLayout.tabCount) {
            tabLayout.getTabAt(i)!!.setIcon(viewPagerAdapter.getTabIcon(i)!!)
            tabLayout.getTabAt(i)!!.setText(viewPagerAdapter.getPageTitle(i))
        }
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.getTabAt(0)!!.select()
    }
}
