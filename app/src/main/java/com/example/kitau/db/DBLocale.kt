package com.example.kitau.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dbtester.db.RicettaEntity


@Database(entities = [RicettaEntity::class], version = 1)
abstract class DBLocale : RoomDatabase() {
    abstract fun DaoRicette(): DaoRicette

    companion object {
        @Volatile
        private var instance: DBLocale? = null
        private val LOCK =Any()

        operator fun invoke(context: Context)=instance?: synchronized(LOCK){
            instance ?: buildDatabase(context).also{instance =it}
        }

        private fun buildDatabase(context: Context)= Room.databaseBuilder(context,DBLocale::class.java,"persons").build()
    }
}

