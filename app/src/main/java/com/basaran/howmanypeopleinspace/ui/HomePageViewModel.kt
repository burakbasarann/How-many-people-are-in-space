package com.basaran.howmanypeopleinspace.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.basaran.howmanypeopleinspace.repo.SpaceDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor(private val srepo: SpaceDaoRepository) : ViewModel() {
    private var _spaceNumber = MutableLiveData<Int>()
    val spaceNumber: LiveData<Int> get() = _spaceNumber

    init{
        getSpaceNumber()
        _spaceNumber = srepo.getSpaceNumber()
    }

    fun getSpaceNumber()=viewModelScope.launch{
        srepo.allSpacePeople()
    }
}