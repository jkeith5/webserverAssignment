package edu.missouriwestern.csc445.integration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), FragmentManager.OnBackStackChangedListener {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toggle = ActionBarDrawerToggle(this, drawer_layout, R.string.open, R.string.close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        setupDrawerContentTransition(navigationView)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return if (toggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

    private fun setupDrawerContentTransition(navigationView: NavigationView) {
        navigationView.setNavigationItemSelectedListener { item ->
            drawMenuItemSelected(item)
            true
        }
    }

    fun drawMenuItemSelected(menuItem: MenuItem) {
        var fragmentClass: Class<*>? = null

        when (menuItem.itemId) {
            R.id.menu_item_home -> fragmentClass = HomeFragment::class.java
            R.id.menu_item_photos -> fragmentClass = PhotosFragment::class.java
            R.id.menu_item_restaurants -> fragmentClass = RestaurantsFragment::class.java
            R.id.menu_item_accounts -> fragmentClass = SigninFragment::class.java
            else -> {
            }
        }

        if (fragmentClass != null) {
            try {
                val mFragment = fragmentClass.newInstance() as Fragment
                val fragmentManager = supportFragmentManager
                fragmentManager.beginTransaction().replace(R.id.fragmentContent, mFragment).commit()
                menuItem.isChecked = true
                title = menuItem.title
                drawer_layout.closeDrawers()
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }

    fun switchContent(id: Int, fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(id, fragment, fragment.toString())
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun onBackStackChanged() {
        try {
            for (fragment in supportFragmentManager.fragments) {
                if (fragment != null && fragment.isVisible) {
                    if (fragment.tag == HomeFragment::class.java!!.getSimpleName()) {
                        title = "Home"
                    } else if (fragment.tag == PhotosFragment::class.java!!.getSimpleName()) {
                        title = "Photos"
                    } else if (fragment.tag == RestaurantsFragment::class.java!!.getSimpleName()) {
                        title = "Restaurants"
                    } else if (fragment.tag == SingleRestaurantFragment::class.java!!.getSimpleName()) {
                        title = "Restaurant Info, Menu, Reviews"
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

}
