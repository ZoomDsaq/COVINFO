package id.zoomdsaq.covinfo.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import id.zoomdsaq.covinfo.R
import id.zoomdsaq.covinfo.firebase.FirestoreClass

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        Handler().postDelayed({

            var currentUserID = FirestoreClass().getCurrentUserId()

            if(currentUserID.isNotEmpty()){
                startActivity(Intent(this, MainActivity::class.java))
            }else{
                startActivity(Intent(this, introActivity::class.java))
            }

            finish()
        }, 2500)
    }
}