package id.zoomdsaq.covinfo.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import id.zoomdsaq.covinfo.R
import id.zoomdsaq.covinfo.activities.introActivity


class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_about,container,false)
        val btnsignout = v.findViewById<View>(R.id.btn_sign_out) as Button
        btnsignout.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            val intent = Intent (activity, introActivity::class.java)
            startActivity(intent)
        }
        return v
    }
}