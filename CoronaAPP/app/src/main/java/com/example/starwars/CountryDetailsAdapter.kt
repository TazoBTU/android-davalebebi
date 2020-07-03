package com.example.starwars

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.country_details.view.*

class CountryDetailsAdapter (private var countries: List<Country> )
    : RecyclerView.Adapter<CountryDetailsAdapter.CountryDetailsViewHolder>() {

    class CountryDetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var country: Country

        @SuppressLint("SetTextI18n")
        fun bind(country: Country) {
            this.country = country

            itemView.byCountryName.text = "Country: ${country.country}"
            itemView.byCountryNewConfirmed.text = "New Confirmed: ${country.newConfirmed}"
            itemView.byCountryTotalConfirmed.text = "Total Confirmed: ${country.totalConfirmed}"
            itemView.byCountryNewDeaths.text = "New Deaths: ${country.newDeaths}"
            itemView.byCountryTotalDeaths.text = "Total Deaths: ${country.totalDeaths}"
            itemView.byCountryNewRecovered.text = "New Recovered: ${country.newRecovered}"
            itemView.byCountryTotalRecovered.text = "Total Recovered: ${country.totalRecovered}"

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryDetailsViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.country_details, parent, false)
        return CountryDetailsViewHolder(v)
    }

    override fun getItemCount(): Int = countries.size

    override fun onBindViewHolder(holder: CountryDetailsViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    fun updateByCountries(countries: List<Country>) {
        this.countries = countries
        notifyDataSetChanged()
    }

}