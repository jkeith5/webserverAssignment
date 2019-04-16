package edu.missouriwestern.csc445.integration.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import edu.missouriwestern.csc445.integration.R

/**
 * A simple [Fragment] subclass.
 */
class ReviewsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reviews, container, false)
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

        //I figured out what to use to get the current class's name generically.
        Toast.makeText(activity, this.javaClass.simpleName + " is displayed.", Toast.LENGTH_SHORT).show();
    }
}
