package com.packag.sports

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.sport_item.view.*
import java.util.zip.Inflater

class SportAdapter: BaseAdapter {


    override fun getView(index: Int, converView: View?, parent: ViewGroup?): View {

        var sport: Sport = sportDatabase?.sports?.get(index) ?: Sport("No Name", "No Detail", R.drawable.placeholder)
        var inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        var sportItem = inflater.inflate(R.layout.sport_item,null)
        sportItem.sportImage.setImageResource(sport.sportImage ?: R.drawable.placeholder)
        sportItem.sportName.setText(sport.sportName)

        sportItem.setOnClickListener {

            val detailIntent = Intent(context, SportDetailActivity::class.java)
            detailIntent.putExtra("image",sport.sportImage)
            detailIntent.putExtra("detail",sport.sportDetail)
            ContextCompat.startActivity(context!!, detailIntent,null)
        }


        return sportItem
    }

    override fun getItem(index: Int): Any {

        return sportDatabase?.sports?.get(index) ?: Sport("No Name", "No Detail", R.drawable.placeholder)
    }

    override fun getItemId(index: Int): Long {

        return index.toLong()
    }

    override fun getCount(): Int {

        return sportDatabase?.sports?.size ?: 0
    }


    private var context: Context? = null
    private var sportDatabase: SportDatabase? = null

    constructor(context: Context) {

        this.context = context
        sportDatabase = SportDatabase()
    }
}