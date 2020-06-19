package com.example.tamazhomework7.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tamazhomework7.R
import com.example.tamazhomework7.api.MockModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.api_mock.view.*


class MockAdapter(private var data: List<MockModel> )
    : RecyclerView.Adapter<MockAdapter.MockViewHolder>() {

    class MockViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SetTextI18n")
        fun bind(info: MockModel) {

            itemView.titleEN.text = "Title: ${info.titleEN}"
            itemView.descEN.text = "Description: ${info.descriptionEN}"

            Picasso.get().load(info.cover).into(itemView.apiImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MockViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.api_mock, parent, false)
        return MockViewHolder(v)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MockViewHolder, position: Int) {
        holder.bind(data[position])
    }

    fun updateRecycler(data: List<MockModel>) {
        this.data = data
        notifyDataSetChanged()
    }
}

