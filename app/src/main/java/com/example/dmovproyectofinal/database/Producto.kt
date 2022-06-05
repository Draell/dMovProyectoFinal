package com.example.dmovproyectofinal.database

class Producto(
    idProd: String,
    product_name: String,
    product_description: String,
    product_price: String,
    product_score: String
) {

    val idProd: String = idProd
    val product_name: String= product_name
    val product_description: String = product_description
    val product_price: String = product_price
    val product_score: String = product_score


}
fun Producto.toEntity() = ProductosEntity(
    idProd,
    product_name,
    product_description,
    product_price,
    product_score
)