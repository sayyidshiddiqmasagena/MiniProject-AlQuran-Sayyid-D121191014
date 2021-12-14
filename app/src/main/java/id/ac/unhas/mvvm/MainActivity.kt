package id.ac.unhas.mvvm


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

import id.ac.unhas.mvvm.ui.alquran.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: AlquranViewModel
    private lateinit var viewModelFactory: AlquranViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        Log.d("MainActivity","Test2")
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, AlquranListFragment.newInstance())
                .commitNow()
        }

       /*viewModelFactory =AlquranViewModelFactory(AlquranRepository())
        viewModel = ViewModelProvider(this,viewModelFactory).get(AlquranViewModel::class.java)

        viewModel.getQuranFromRepo()
        recylerview_id.layoutManager = LinearLayoutManager(this)
        recylerview_id.adapter = AlquranAdapter(viewModel.alquran)*/
    }

    /*fun ShowApi(quran:List<Quran>){
        recylerview_id.layoutManager = linearLayoutManager
        val adapter = AlquranAdapter(viewModel.alquran)
    }*/
}