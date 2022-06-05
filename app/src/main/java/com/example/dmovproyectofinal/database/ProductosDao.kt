package com.example.dmovproyectofinal.database

import androidx.room.*

@Dao
interface ProductosDao {

    @Query("SELECT * FROM $TABLE_PRODUCTOS")
            fun getProductosFromDatabase(): List<ProductosEntity>

    @Query("SELECT * FROM $TABLE_PRODUCTOS WHERE idProd = :idProd")
    fun getProductoByIdProd(idProd: Int):ProductosEntity

    @Delete
    fun delete(producto: ProductosEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(producto: ProductosEntity)

}