package id.ac.unhas.mvvm.ui.alquran

import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import id.ac.unhas.mvvm.model.DataAlquran
import id.ac.unhas.mvvm.model.Quran
import id.ac.unhas.mvvm.network.retrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class  AlquranViewModel:ViewModel() {

    init {
        Log.d("HomeVIewModel","Created")
    }

    var _alquran : ArrayList<Quran> = arrayListOf()


    interface onClickListener{
        fun onClick(quran: Quran)
    }


    fun getDataFromApi(recyclerView: RecyclerView, listener : onClickListener){

        retrofitClient.instance.getQuran().enqueue(object :Callback<DataAlquran> {
            override fun onFailure(call: Call<DataAlquran>, t: Throwable) {
                Log.d("ViewModel", "onFailure")
            }

            override fun onResponse(call: Call<DataAlquran>, response: Response<DataAlquran>) {
                val data = response.body()
                _alquran.addAll (data as ArrayList<Quran>)
                recyclerView.adapter = shareAdapter(data as ArrayList<Quran>, object : shareAdapter.OnItemClickListener{
                    override fun onClick(quran: Quran) {
                        listener.onClick(quran)
                    }

                })
            }




        })
    }

}