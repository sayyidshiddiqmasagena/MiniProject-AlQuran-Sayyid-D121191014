package id.ac.unhas.mvvm.ui.alquran


import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.unhas.mvvm.R
import id.ac.unhas.mvvm.model.Quran
import id.ac.unhas.mvvm.utilities.StaticData

import kotlinx.android.synthetic.main.recyclerview_fragment.*

class AlquranListFragment : Fragment() {

    companion object {
        fun newInstance() = AlquranListFragment()
    }

    private lateinit var viewModel: AlquranViewModel
    //private lateinit var viewModelFactory: AlquranViewModelFactory
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        //viewModelFactory =AlquranViewModelFactory(AlquranRepository())
        viewModel = ViewModelProvider(this).get(AlquranViewModel::class.java)
        return inflater.inflate(R.layout.recyclerview_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("MainFragment","createView")

        linearLayoutManager= LinearLayoutManager(context)
        recylerview_id.layoutManager = linearLayoutManager


        if(viewModel._alquran.size==0) {
            viewModel.getDataFromApi(recylerview_id, object : AlquranViewModel.onClickListener{
                override fun onClick(quran: Quran) {
                    StaticData.fill(quran)
                    val fragment: Fragment = detailFragment.newInstance()
                    val fragmentManager: FragmentManager = activity!!.supportFragmentManager
                    val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.container, fragment)
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
                }
            } )
        } else {
            recylerview_id.adapter= shareAdapter(viewModel._alquran, object : shareAdapter.OnItemClickListener{
                override fun onClick(quran: Quran) {
                    StaticData.fill(quran)
                    val fragment: Fragment = detailFragment.newInstance()
                    val fragmentManager: FragmentManager = activity!!.supportFragmentManager
                    val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.container, fragment)
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
                }
            })
        }


    }
    private fun generateDummyList(size: Int): List<Quran> {
        val list = ArrayList<Quran>()
        for (i in 0 until size) {

            val item = Quran("$i ", i,i,i,"Name test $i ","Name test $i ")
            list += item
        }
        return list
    }

}

