package com.example.myapplication


import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


         listView = findViewById<ListView>(R.id.shop_list_view)

        val shopList = Shop.getProductsFromFile("products.json", this)

        val adapter = shopAdapter(this, shopList)
        listView.adapter = adapter


        val context = this
        listView.setOnItemClickListener { _, _, position, _ ->
            // 1
            val selectedShop = shopList[position]

            // 2
            val detailIntent = itemInfo.newIntent(context, selectedShop)

            // 3
            startActivity(detailIntent)
        }


    }

    }




