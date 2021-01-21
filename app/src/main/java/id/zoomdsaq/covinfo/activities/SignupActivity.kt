package id.zoomdsaq.covinfo.activities


import android.os.Bundle
import android.text.TextUtils
import android.view.WindowManager
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import id.zoomdsaq.covinfo.R
import id.zoomdsaq.covinfo.firebase.FirestoreClass
import id.zoomdsaq.covinfo.models.User
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setupActiobBar()
    }

    fun userRegisteredSuccess(){
        Toast.makeText(this,"Telah berhasil registrasi", Toast.LENGTH_SHORT).show()
        hideProgressDialog()

        FirebaseAuth.getInstance().signOut()
        finish()
    }

    private fun setupActiobBar(){
        setSupportActionBar(toolbar_sign_up_activity)

        val actionBar = supportActionBar
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator((R.drawable.ic_black_color_back_24dp))
        }

        toolbar_sign_up_activity.setNavigationOnClickListener{onBackPressed()}

        btn_sign_up.setOnClickListener{
            registerUser()
        }
    }

    private fun registerUser(){
        val name: String = et_name.text.toString().trim{it <= ' '}
        val email: String = et_email.text.toString().trim{it <= ' '}
        val password: String = et_password.text.toString().trim{it <= ' '}

        if(validateForm(name, email, password)){
            showProgressDialog(resources.getString(R.string.please_wait))
            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->

                    if(task.isSuccessful){
                        val firebaseUser : FirebaseUser = task.result!!.user!!
                        val registeredEmail = firebaseUser.email!!
                        val user = User(firebaseUser.uid, name, registeredEmail)

                        FirestoreClass().registerUser(this, user)
                    }else{
                        Toast.makeText(this, "Registrasi gagal", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
        }
    }

    private fun validateForm(name: String, email: String, password: String) : Boolean{
        return when{
            TextUtils.isEmpty(name)->{
                showErrorSnackBar("Silahkan masukkan nama")
                false
            }
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