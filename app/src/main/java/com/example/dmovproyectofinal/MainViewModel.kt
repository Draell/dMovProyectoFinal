package com.example.dmovproyectofinal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dmovproyectofinal.database.DatabaseManager
import com.example.dmovproyectofinal.database.MyCoroutines
import com.example.dmovproyectofinal.database.Producto
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    fun saveProducto(producto: Producto){
        viewModelScope.launch{
            val productosDao = DatabaseManager.instance.database.productosDao()
            MyCoroutines(productosDao).save(producto)
        }
    }

    fun deleteProducto(producto: Producto){
        viewModelScope.launch{
            val productosDao = DatabaseManager.instance.database.productosDao()
            MyCoroutines(productosDao).delete(producto)
        }
    }

    val savedProductos =MutableLiveData<List<Producto>>()
    fun getProductos(){
        viewModelScope.launch {
            val productosDao = DatabaseManager.instance.database.productosDao()
            savedProductos.value = MyCoroutines(productosDao).getProductos().value
        }
    }
}