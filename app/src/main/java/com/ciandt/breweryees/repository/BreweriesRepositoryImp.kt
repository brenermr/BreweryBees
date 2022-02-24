package com.ciandt.breweryees.repository

import com.ciandt.breweryees.Model.BreweriesModel
import com.ciandt.breweryees.Model.BreweriesRatingModel
import com.ciandt.breweryees.api.BreweriesService
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.onSuccess


class BreweriesRepositoryImp(private val service: BreweriesService): BreweriesRespository {
    override suspend fun getBreweriesTopTen(): List<BreweriesModel> {

        val response = service.breweriesTopTen()
        var data: List<BreweriesModel> = listOf(BreweriesModel())

        response.onSuccess{
            data = this.data
        }.onError {
            data = listOf(BreweriesModel())
        }.onException {
            data = listOf(BreweriesModel())
        }
        return data!!
    }

    override suspend fun getBreweriesCity(search: String): List<BreweriesModel> {
        val responseSearchCity = service.getBreweriesCity(search)
        var data : List<BreweriesModel>? = null

        responseSearchCity.onSuccess {
            data = this.data
        }.onError {
            data = listOf<BreweriesModel>()
        }.onException {
            data = listOf<BreweriesModel>()
        }
        return data!!
    }

    override suspend fun setBreweriesRating(breweriesRating : BreweriesRatingModel): BreweriesRatingModel {

        val response = service.setBreweriesRating(breweriesRating)
        var data :BreweriesRatingModel? = BreweriesRatingModel()

        response.onSuccess {
            data = this.data
        }.onError {
            data = BreweriesRatingModel()
        }.onException {
            data = BreweriesRatingModel()
        }
        return data!!
    }
}
