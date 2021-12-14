package id.ac.unhas.mvvm.ui.alquran

import android.util.Log
import androidx.lifecycle.MutableLiveData
import id.ac.unhas.mvvm.model.DataAlquran
import id.ac.unhas.mvvm.model.Quran
import id.ac.unhas.mvvm.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlquranRepository() {

    private val mutableLiveData: MutableLiveData<ArrayList<Quran>> =
        MutableLiveData<ArrayList<Quran>>()

    fun getQuranFromApi() : MutableLiveData<ArrayList<Quran>>{

        val api = NetworkConfig().api()

        api.getQuran().enqueue(object : Callback<DataAlquran> {
            override fun onFailure(call: Call<DataAlquran>, t: Throwable) {
                Log.d(this.javaClass.simpleName,"error : ${t.stackTrace}")
            }

            override fun onResponse(call: Call<DataAlquran>, response: Response<DataAlquran>) {
                val dataAlquran= response.body()
                mutableLiveData.value = dataAlquran!!

            }
        })

        return mutableLiveData
    }

}