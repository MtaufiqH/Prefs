package id.taufiq.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import id.taufiq.myapplication.sharedprefs.Constant
import id.taufiq.myapplication.sharedprefs.MySharedPrefs

class MainActivity : AppCompatActivity() {

    private val sharedPrefs: MySharedPrefs by lazy {
        MySharedPrefs(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = findViewById<EditText>(R.id.id_text_email)
        val password = findViewById<EditText>(R.id.id_text_password)
        val btnLogin = findViewById<Button>(R.id.btn_login)

        btnLogin.setOnClickListener {
            if (email.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()) {
                saveSession(email.text.toString(), password.text.toString())
                showMessage("Login Succes")
                Intent(this, HomeActivity::class.java).also {
                    startActivity(it)
                }
                finishAffinity()
            }

        }

    }

    override fun onStart() {
        super.onStart()
        if (sharedPrefs.getBool(Constant.PREF_IS_LOGIN)){
            Intent(this,HomeActivity::class.java).also {
                startActivity(it)
            }
        } else {
            showMessage("Login first")
        }
    }

    private fun saveSession(email: String, password: String) {
        sharedPrefs.setEmail(Constant.PREF_EMAIL, email)
        sharedPrefs.setPassword(Constant.PREF_PASSWORD, password)
        sharedPrefs.setBool(Constant.PREF_IS_LOGIN, true)
    }

    private fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}