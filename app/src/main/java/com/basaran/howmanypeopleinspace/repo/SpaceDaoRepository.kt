package com.basaran.howmanypeopleinspace.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.basaran.howmanypeopleinspace.data.remote.APIService
import com.basaran.howmanypeopleinspace.model.PeopleModel
import javax.inject.Inject

class SpaceDaoRepository @Inject constructor(private val sdao: APIService) {
    var spacePeopleNumber: MutableLiveData<Int>
    var spacePeopleList: MutableLiveData<List<PeopleModel>>

    init{
        spacePeopleList = MutableLiveData()
        spacePeopleNumber = MutableLiveData()
    }

    fun getSpacePeople(): MutableLiveData<List<PeopleModel>> {
        return spacePeopleList
    }

    fun getSpaceNumber(): MutableLiveData<Int> {
        return spacePeopleNumber
    }

    suspend fun allSpacePeople(){
        val response = sdao.getSpaceList()
        if(response.isSuccessful){
            response.body()?.let {
                Log.e("api1","girdi")
                val list = response.body()
                spacePeopleList.value = list?.people
                spacePeopleNumber.value = list?.number
            }

        }else{
            Log.e("api1","hata")
        }
    }
}