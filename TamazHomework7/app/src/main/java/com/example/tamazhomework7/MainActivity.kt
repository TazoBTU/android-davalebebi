package com.example.tamazhomework7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tamazhomework7.adapters.MockAdapter
import com.example.tamazhomework7.api.MockModel
import com.example.tamazhomework7.api.RetrofitClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var mockAdapter: MockAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this)
        apiRecyclerView.layoutManager = layoutManager
        mockAdapter = MockAdapter(ArrayList())
        apiRecyclerView.adapter = mockAdapter
        
        getMockData()
    }

    private fun getMockData() {
        RetrofitClient.mockApi.getInfo()
            .enqueue(object : Callback<List<MockModel>> {
                override fun onFailure(call: Call<List<MockModel>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Failed to fetch!", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<List<MockModel>>,
                    response: Response<List<MockModel>>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        mockAdapter.updateRecycler(response.body()!!)
                    }
                }

            })
    }
}
