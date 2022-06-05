package com.example.dmovproyectofinal.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyCoroutines(private val productosDao: ProductosDao) {
    suspend fun save(producto: Producto) = withContext(Dispatchers.IO){
        productosDao.save(producto.toEntity())
    }

    suspend fun delete(producto: Producto)= withContext(Dispatchers.IO){
        productosDao.delete(producto.toEntity())
    }

    suspend fun getProductos(): LiveData<List<Producto>> = withContext(Dispatchers.IO){
        return@withContext MutableLiveData(productosDao.getProductosFromDatabase().map{ eachProductosEntity ->
        eachProductosEntity.toProducto()})
    }

}