package id.zoomdsaq.covinfo.activities

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import id.zoomdsaq.covinfo.R
import id.zoomdsaq.covinfo.models.User
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.activity_sign_in.et_email_sign_in
import kotlinx.android.synthetic.main.activity_sign_in.et_password_sign_in


class SignInActivity : BaseActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        auth = FirebaseAuth.getInstance()

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        btn_sign_in.setOnClickListener{
            signInRegisteredUser()
        }

        setupActiobBar()
    }

    private fun setupActiobBar(){
        setSupportActionBar(toolbar_sign_in_activity)

        val actionBar = supportActionBar
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator((R.drawable.ic_black_color_back_24dp))
        }

        toolbar_sign_in_activity.setNavigationOnClickListener{onBackPressed()}
    }

    private fun signInRegisteredUser(){
        val email: String = et_email_sign_in.text.toString().trim{it <= ' '}
        val password: String = et_password_sign_in.text.toString().trim{it <= ' '}

        if(validateForm(email,password)){
            showProgressDialog(resources.getString(R.string.please_wait))

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    hideProgressDialog()
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("Sign In", "signInWithEmail:success")
                        val user = auth.currentUser
                        startActivity(Intent(this, MainActivity::class.java))

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("Sign In", "signInWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Username atau Password salah.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

    private fun validateForm(email: String, password: String) : Boolean{
        return when{
            TextUtils.isEmpty(email)->{
                showErrorSnackBar("Silahkan masukkan email")
                false
            }
            TextUtils.isEmpty(password)->{
                showErrorSnackBar("Silahkan masukkan password")
                false
            }else -> {
                true
            }
        }
    }

}