package com.ciandt.breweryees.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ciandt.breweryees.Model.BreweriesModel
import com.ciandt.breweryees.repository.BreweriesRepository

class TopTenViewModel(): ViewModel() {
    private val beerRepository = BreweriesRepository()
    private val _bearListLiveData = MutableLiveData<BreweriesModel>()
    val bearListLiveData :LiveData<BreweriesModel>
    get() = _bearListLiveData

    suspend fun getBeerList(){

       val response =  beerRepository.getBreweriesTopTen()
        //if sucesso
        //_bearListLiveData.postValue(response)//response.data
    }


}