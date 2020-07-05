package com.packag.sports

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sport_detail.*

class SportDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sport_detail)

        val receivedData = intent.extras

        val sportImage = receivedData!!.getInt("image")
        val sportDetail = receivedData?.getString("detail")

        detailImage.setImageResource(sportImage)
        detailText.text = sportDetail
    }
}
