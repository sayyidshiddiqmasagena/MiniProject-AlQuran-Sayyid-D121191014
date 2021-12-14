package id.ac.unhas.mvvm.ui.alquran

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class AlquranViewModelFactory (
    private val repository: AlquranRepository
):ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(AlquranRepository::class.java).newInstance(repository)
    }
}