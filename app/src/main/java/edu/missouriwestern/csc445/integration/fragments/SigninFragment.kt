package edu.missouriwestern.csc445.integration


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.widget.Toast
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest

import kotlinx.android.synthetic.main.fragment_signin.*
import kotlinx.android.synthetic.main.fragment_signup.*
import org.json.JSONObject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SigninFragment : Fragment() {

    override fun onResume() {
        super.onResume()
        if (!getUserVisibleHint())
        {
            return;
        }
        link.setOnClickListener {
            jumpToSignUp()
        }
        signinBtn.setOnClickListener{
            signIn()
        }
        Toast.makeText(activity, this.javaClass.simpleName + " is displayed.", Toast.LENGTH_SHORT).show();
    }

    private fun jumpToSignUp() {
        var mFragment = SignupFragment()
        var mBundle = Bundle()
        mFragment.setArguments(mBundle)
        switchContent(R.layout.fragment_signin, mFragment)
    }

    fun switchContent(id: Int, fragment: Fragment) {
        if (context == null)
            return
        if (context is MainActivity) {
            val mainActivity = context as MainActivity
            mainActivity.switchContent(id, fragment)
        }
    }

    fun signIn(){
        //You need to change this URL to your own URL
        val url = "https://a1127ee0.ngrok.io/menu/signin.php"

        // Post parameters
        // Form fields and values
        val params = HashMap<String,String>()
        params["username"] = username.text.toString()
        params["password"] = password.text.toString()
        val jsonObject = JSONObject(params)

        // Volley post request with parameters
        val request = JsonObjectRequest(
            Request.Method.POST,url,jsonObject,
            Response.Listener { response ->
                // Process the json
                try {
                    if(response["success"] == 1) {
                        //switch to account details
                        Toast.makeText(activity, "Login successful", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(activity, response["error_message"] as String, Toast.LENGTH_SHORT).show();
                    }
                }catch (e:Exception){
                    Toast.makeText(activity, "Exception: $e", Toast.LENGTH_SHORT).show();
                }

            }, Response.ErrorListener{
                // Error in request
                Toast.makeText(activity, "Volley error: $it", Toast.LENGTH_SHORT).show();
            })


        // Volley request policy, only one time request to avoid duplicate transaction
        request.retryPolicy = DefaultRetryPolicy(
            DefaultRetryPolicy.DEFAULT_TIMEOUT_MS,
            // 0 means no retry
            0, // DefaultRetryPolicy.DEFAULT_MAX_RETRIES = 2
            1f // DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        )

        // Add the volley post request to the request queue
        VolleySingleton.getInstance(context!!).addToRequestQueue(request)
    }

}
