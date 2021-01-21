package id.zoomdsaq.covinfo.activities

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import id.zoomdsaq.covinfo.R
import kotlinx.android.synthetic.main.activity_intro.*

class introActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        btn_sign_in_intro.setOnClickListener{
            startActivity(Intent(this, SignInActivity::class.java))
        }

        btn_sign_up_intro.setOnClickListener{
            startActivity(Intent(this, SignupActivity::class.java))
        }
    }
}