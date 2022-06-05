package com.example.dmovproyectofinal.database

import androidx.room.Database
import androidx.room.RoomDatabase

const val DATABASE_VERSION = 1
const val TABLE_PRODUCTOS = "productos"
const val DATABASE_NAME = "appdatabase.sqlite"

@Database(entities = [ProductosEntity::class],
    version = DATABASE_VERSION
    )

abstract class AppDatabase : RoomDatabase() {
    abstract fun productosDao(): ProductosDao
}