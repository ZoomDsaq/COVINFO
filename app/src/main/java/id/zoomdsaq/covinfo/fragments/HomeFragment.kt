package id.zoomdsaq.covinfo.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import id.zoomdsaq.covinfo.R
import id.zoomdsaq.covinfo.activities.GejalaActivity
import id.zoomdsaq.covinfo.activities.PencegahanActivity
import id.zoomdsaq.covinfo.activities.PenyebaranActivity
import id.zoomdsaq.covinfo.activities.SejarahActivity



class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_home,container,false)
        val btnsejarah = v.findViewById<View>(R.id.btn_sejarah) as ImageButton
        val btngejala = v.findViewById<View>(R.id.btn_gejala) as ImageButton
        val btnpenyebaran = v.findViewById<View>(R.id.btn_penyebaran) as ImageButton
        val btnpencegahan = v.findViewById<View>(R.id.btn_pencegahan) as ImageButton
        btnsejarah.setOnClickListener{
            val intent = Intent (activity, SejarahActivity::class.java)
            startActivity(intent)
        }
        btngejala.setOnClickListener{
            val intent = Intent (activity, GejalaActivity::class.java)
            startActivity(intent)
        }
        btnpenyebaran.setOnClickListener{
            val intent = Intent (activity, PenyebaranActivity::class.java)
            startActivity(intent)
        }
        btnpencegahan.setOnClickListener{
            val intent = Intent (activity, PencegahanActivity::class.java)
            startActivity(intent)
        }
        return v
    }
}