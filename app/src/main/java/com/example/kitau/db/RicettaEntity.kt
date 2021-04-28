package com.example.dbtester.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ricette")
data class RicettaEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,


    @ColumnInfo(name = "titolo") val titolo: String,
    @ColumnInfo(name = "descrizione") val descrizione: String,
    @ColumnInfo(name = "tempo") val tempo: Int
)
