package id.taufiq.myapplication.sharedprefs

import android.content.Context

/**
 * Created By Taufiq on 1/31/2021.
 *
 */
class MySharedPrefs(context: Context) {

    companion object {
        const val SP_NAME = "LOGIN_PREFS"
    }

    private val prefs = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)

    fun getPassword(key: String) = prefs.getString(key, "null")

    fun setPassword(key: String, value: String) {
        prefs.run { edit().putString(key, value).apply() }
    }

    fun getBool(key: String) = prefs.getBoolean(key, false)

    fun setBool(key: String, value: Boolean) {
        prefs.run {
            edit().putBoolean(key, value).apply()
        }
    }

    fun getEmail(key: String) = prefs.getString(key, "null")

    fun setEmail(key: String, value: String) {
        prefs.run { edit().putString(key, value).apply() }
    }


    fun clearPrefs() {
        prefs.edit().clear().apply()
    }

}