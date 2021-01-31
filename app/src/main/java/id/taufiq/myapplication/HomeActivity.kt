package id.taufiq.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import id.taufiq.myapplication.sharedprefs.Constant
import id.taufiq.myapplication.sharedprefs.MySharedPrefs

class HomeActivity : AppCompatActivity() {

    private val sharedPrefs: MySharedPrefs by lazy {
        MySharedPrefs(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val txtEmail = findViewById<TextView>(R.id.tv_email_home)
        txtEmail.text = "Welcome ${sharedPrefs.getEmail(Constant.PREF_EMAIL)}"

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu.run {
            this?.add(0, LOGOUT, 0, "Log Out")
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == LOGOUT) {
            sharedPrefs.clearPrefs()
            showMessage("Logout Succes")
            Intent(this,MainActivity::class.java).also {
                startActivity(it)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val LOGOUT = 1
    }




}