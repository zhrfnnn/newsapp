package app.zhrfnnn.newsapp.util

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Created by Zharfan on 7/16/2023.
 */

fun Context.toast(text: String?) {
    Toast.makeText(this, "$text", Toast.LENGTH_SHORT).show()
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun Any?.isNotNull() : Boolean {
    return this != null
}

fun Activity.goToActivity(activity: Activity) {
    startActivity(Intent(this, activity.javaClass))
}

@SuppressLint("SimpleDateFormat")
fun String.toReadableDate() : String? {
    val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    val toFormat = SimpleDateFormat("dd MMMM yyyy - HH:mm", Locale("id", "ID"))
    return format.parse(this)?.let { toFormat.format(it) }
}

fun log(content: String?) {
    Log.v("devvv", "$content")
}