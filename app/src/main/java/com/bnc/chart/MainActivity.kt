package com.bnc.chart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import com.google.gson.JsonObject

class MainActivity : AppCompatActivity() {

    private lateinit var myWebView : WebView
    private lateinit var  json : Any

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //webview
        myWebView = findViewById(R.id.webview)

        //you can populate the chart dynamically by altering this json object
        json = JsonObject().apply {
            addProperty("Mushroom",5)
            addProperty("Cheese",2)
            addProperty("Pepperoni",3)
            addProperty("Tuna",4)
            addProperty("Chicken",3)
        }
        myWebView.settings.javaScriptEnabled = true
        myWebView.loadUrl("file:///android_asset/piechart.html?$json");
    }


    fun showPieChart(view: View) {
        myWebView.settings.javaScriptEnabled = true
        myWebView.loadUrl("file:///android_asset/piechart.html?$json");
    }
    fun showBarChart(view: View) {
        myWebView.settings.javaScriptEnabled = true
        myWebView.loadUrl("file:///android_asset/barchart.html?$json");
    }
    fun showColumnChart(view: View) {
        myWebView.settings.javaScriptEnabled = true
        myWebView.loadUrl("file:///android_asset/columnchart.html?$json");
    }
}