package com.example.starwars

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starwars.Global.*
import kotlinx.android.synthetic.main.activity_country_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryDetailsActivity : AppCompatActivity() {

    private lateinit var countryDetailsAdapter: CountryDetailsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_details)

        val layoutManager = LinearLayoutManager(this)
        countryDetailsRecycler.layoutManager = layoutManager
        countryDetailsAdapter = CountryDetailsAdapter(ArrayList())
        countryDetailsRecycler.adapter = countryDetailsAdapter

        getCountryDetails()

    }

    private fun getCountryDetails() {
        RetrofitClient.covid19Api.getData("summary")
            .enqueue(object : Callback<Covid19CountrySummary<List<Country>>> {
                override fun onFailure(
                    call: Call<Covid19CountrySummary<List<Country>>>,
                    t: Throwable
                ) {

                }
                override fun onResponse(
                    call: Call<Covid19CountrySummary<List<Country>>>,
                    response: Response<Covid19CountrySummary<List<Country>>>
                ) {
                    if(response.isSuccessful && response.body() != null) {
                        val byCountryList = response.body()!!.countries.sortedByDescending { it.totalConfirmed }
                        countryDetailsAdapter.updateByCountries(byCountryList)
                    }
                }

            })
    }
}