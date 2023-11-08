package com.example.gmail_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val items: ArrayList<GmailModel> = arrayListOf()
    private val mAdapter: Adapter = Adapter(items)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setLogo(R.drawable.menu)
        supportActionBar?.setDisplayUseLogoEnabled(true)
        repeat(10) {
            items.add(
                GmailModel(
                    sender = "dangkhoadz.com.vn",
                    title = "This is your change is your change is your change is your change is your change!!!",
                    content = "Today very important very important very important very important very important very important very important ",
                    time = "12:30 AM",
                    logoPath = "https://assets3.thrillist.com/v1/image/3069256/1200x600/crop;;webp=auto;jpeg_quality=85.jpg",
                    isMark = false
                )
            )
        }
        findViewById<RecyclerView>(R.id.recycler_view).apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu,menu)
        return true
    }
}