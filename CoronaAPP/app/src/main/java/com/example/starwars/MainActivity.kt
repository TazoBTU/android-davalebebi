package com.example.starwars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.annotation.SuppressLint
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.getSummaryInfo()

        goToDetails.setOnClickListener {
            startActivity(Intent(this, CountryDetailsActivity::class.java))
        }
    }

    private fun getSummaryInfo() {
        RetrofitClient.covid19Api.getGlobal("summary")
            .enqueue(object : Callback<Covid19GlobalSummary<Global>> {
                override fun onFailure(call: Call<Covid19GlobalSummary<Global>>, t: Throwable) {

                }

                @SuppressLint("SetTextI18n")
                override fun onResponse(
                    call: Call<Covid19GlobalSummary<Global>>,
                    response: Response<Covid19GlobalSummary<Global>>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        val responseBody = response.body()!!.summary
                        globalNewConfirmed.text = "New Confirmed: ${responseBody.newConfirmed}"
                        globalTotalConfirmed.text = "Total Confirmed: ${responseBody.totalConfirmed}"
                        globalNewDeaths.text = "New Deaths: ${responseBody.newDeaths}"
                        globalTotalDeaths.text = "Total Deaths: ${responseBody.totalDeaths}"
                        globalNewRecovered.text = "New Recovered: ${responseBody.newRecovered}"
                        globalTotalRecovered.text = "Total Recovered: ${responseBody.totalRecovered}"
                    }
                }

            })

    }
}
