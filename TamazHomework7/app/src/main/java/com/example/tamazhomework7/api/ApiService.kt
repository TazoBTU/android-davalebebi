package com.example.tamazhomework7.api

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("5edb4d643200002a005d26f0?fbclid=IwAR1HbWx0sc25FOmrSJBPZOyf4Gt4OqrEJ3GyiCqTK0ceS2pveH5_NtrysVY")
    fun getInfo() : Call<List<MockModel>>
}



