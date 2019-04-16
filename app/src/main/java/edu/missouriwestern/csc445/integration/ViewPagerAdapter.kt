package edu.missouriwestern.csc445.integration

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fm:FragmentManager): FragmentPagerAdapter(fm) {

    private val fragmentList = ArrayList<Fragment>()
    private val titleList = ArrayList<String>()
    private val iconList = ArrayList<Int>()

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titleList[position]
    }

    fun getTabIcon(position: Int):Int?{
        return iconList[position]
    }

    fun addFragment(fragment: Fragment, title: String, iconId: Int?) {
        fragmentList.add(fragment)
        titleList.add(title)
        iconList.add(iconId!!)
    }
}