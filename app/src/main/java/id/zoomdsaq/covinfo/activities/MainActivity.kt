package id.zoomdsaq.covinfo.activities


import android.os.Bundle
import androidx.fragment.app.Fragment
import id.zoomdsaq.covinfo.R
import id.zoomdsaq.covinfo.fragments.AboutFragment
import id.zoomdsaq.covinfo.fragments.HomeFragment
import id.zoomdsaq.covinfo.fragments.TrackerFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val trackerFragment = TrackerFragment()
        val aboutFragment = AboutFragment()

        bottom_navigation_main.setItemSelected(R.id.home_navigation)
        makeCurrentFragment(homeFragment)

        bottom_navigation_main.setOnItemSelectedListener{id ->
            when(id){
                R.id.home_navigation -> makeCurrentFragment(homeFragment)
                R.id.tracker_navigation -> makeCurrentFragment(trackerFragment)
                R.id.about_navigation -> makeCurrentFragment(aboutFragment)
            }
        }
    }
    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.f1_wrapper, fragment)
            commit()
        }

}