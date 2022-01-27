package com.basaran.howmanypeopleinspace.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class RetrofitClient {
    companion object{

        @Volatile
        private var INSTANCE: Retrofit? = null

        fun getRetrofitClient(): Retrofit {
            return INSTANCE?: synchronized(this){
                val instance = Retrofit.Builder()
                    .baseUrl("http://api.open-notify.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}