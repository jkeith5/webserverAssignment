package edu.missouriwestern.csc445.integration

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.slide.view.*

class PlanetAdapter(internal var context: Context): PagerAdapter() {

    var inflater: LayoutInflater? = null

    var images = intArrayOf(R.drawable.image_1, R.drawable.image_2, R.drawable.image_3, R.drawable.image_4)
    var titles = arrayOf("Title 1", "Title 2", "Title 3", "Title 4")
    var bgcolors =
            intArrayOf(
                    Color.rgb(55, 55, 55),
                    Color.rgb(239, 85, 85),
                    Color.rgb(110, 49, 89),
                    Color.rgb(1, 188, 212))

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as ConstraintLayout
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        //super.destroyItem(container, position, `object`)
        container.removeView(`object` as ConstraintLayout)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        if (inflater == null) {
            inflater = LayoutInflater.from(context)
        }
        val view = inflater!!.inflate(R.layout.slide, container, false)
        view.itemImage.setImageResource(images[position])
        view.itemTitle.setText(titles[position])
        view.planetConstraintLayout.setBackgroundColor(bgcolors[position])

        container.addView(view)

        return view
    }
}