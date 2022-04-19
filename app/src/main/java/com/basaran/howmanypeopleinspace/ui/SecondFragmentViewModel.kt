package com.basaran.howmanypeopleinspace.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.basaran.howmanypeopleinspace.model.PeopleModel
import com.basaran.howmanypeopleinspace.repo.SpaceDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SecondFragmentViewModel @Inject constructor(private val srepo: SpaceDaoRepository) : ViewModel() {
    private var _spaceList = MutableLiveData<List<PeopleModel>>()
    val spaceList: LiveData<List<PeopleModel>> get() = _spaceList


    init{
        getSpaceList()
        _spaceList = srepo.getSpacePeople()
    }

    fun getSpaceList()=viewModelScope.launch{
        srepo.allSpacePeople()
    }
}