package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

class shopAdapter(private val context: Context,
                  private val dataSource: ArrayList<Shop>) : BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater



    //1
    override fun getCount(): Int {
        return dataSource.size
    }

    //2
    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    //3
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //4
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = inflater.inflate(R.layout.list_shop, parent, false)

        // Get thumbnail element
        val thumbnailImageView = rowView.findViewById(R.id.imageView) as ImageView

        val shop = getItem(position) as Shop

        Picasso.get().load(shop.image).placeholder(R.mipmap.ic_launcher).into(thumbnailImageView)


        return rowView
    }



}