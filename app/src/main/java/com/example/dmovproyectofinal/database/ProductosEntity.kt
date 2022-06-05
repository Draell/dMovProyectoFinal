package com.example.dmovproyectofinal.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = TABLE_PRODUCTOS)
data class ProductosEntity(
    @PrimaryKey val idProd: String,
    val product_name: String,
    val product_description: String,
    val product_price: String,
    val product_score: String


)

fun ProductosEntity.toProducto() = Producto(
    idProd,
    product_name,
    product_description,
    product_price,
    product_score
)