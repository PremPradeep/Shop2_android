package com.example.myapplication

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_item_info.*
import java.math.BigDecimal
import java.math.RoundingMode

class itemInfo : AppCompatActivity() {

    private lateinit var textView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_info)



        var item_name = findViewById<TextView>(R.id.pName)
        var item_price = findViewById<TextView>(R.id.pPrice)
        var item_stock = findViewById<TextView>(R.id.pStock)



        val pName = getIntent().getStringExtra("name")
        val pPrice = getIntent().getStringExtra("price")
        val pStock = getIntent().getStringExtra("stock")

        val pPrice_dec = BigDecimal(pPrice).setScale(2, RoundingMode.HALF_EVEN)


        item_name.text = pName
        item_price.text = "$" + pPrice_dec
        item_stock.text = pStock


        button_buy.setOnClickListener {

            val dialogBuilder = AlertDialog.Builder(this)

            dialogBuilder.setMessage("")
                .setCancelable(false)
                .setPositiveButton("Yes", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()

                        button_buy.text = "View Now"
                        true

                })
                .setNegativeButton("No", DialogInterface.OnClickListener{
                 dialog, id ->  dialog.cancel()
                })

            val alert = dialogBuilder.create()
            // set title for alert dialog box
            alert.setTitle("Buy Now ?")
            // show alert dialog
            alert.show()

        }


    }


    companion object {
        const val EXTRA_NAME = "name"
        const val EXTRA_PRICE = "price"
        const val EXTRA_STOCK = "stock"


        fun newIntent(context: Context, shop: Shop): Intent {
            val detailIntent = Intent(context, itemInfo::class.java)

            detailIntent.putExtra(EXTRA_NAME, shop.name)
            detailIntent.putExtra(EXTRA_PRICE, shop.price)
            detailIntent.putExtra(EXTRA_STOCK, shop.stock)


            return detailIntent
        }
    }


}
