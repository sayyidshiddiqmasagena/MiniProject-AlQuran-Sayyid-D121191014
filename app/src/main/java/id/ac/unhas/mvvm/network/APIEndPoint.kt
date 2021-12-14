package id.ac.unhas.mvvm.network

import id.ac.unhas.mvvm.model.DataAlquran
import retrofit2.Call
import retrofit2.http.GET
interface ApiEndPoint {
    @GET("data") //full url : https://api.npoint.io/99c279bb173a6e28359c/data
    fun getQuran(): Call<DataAlquran>
}