package com.basaran.howmanypeopleinspace.data.remote

import com.basaran.howmanypeopleinspace.data.remote.regres.SpaceListResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET("astros")
    suspend fun getSpaceList() : Response<SpaceListResponse>
}