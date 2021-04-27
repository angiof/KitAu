package com.example.kitau.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ricette")
data class RicettaEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "titolo") val titolo: String,
    @ColumnInfo(name = "descrizione") val descrizione: String,
    @ColumnInfo(name = "ingredienti") val ingredienti: String,
    @ColumnInfo(name = "tempo") val tempo:Int
)