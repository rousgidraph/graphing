package com.example.graphing.di

import android.content.Context
import androidx.room.Room
import com.example.graphing.database.AppDatabase
import com.example.graphing.database.SalesPersonDao
import com.example.graphing.database.sales_dao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {
    @Provides
    fun provideSalesDao(database: AppDatabase): sales_dao {
        return  database.sales_dao()
    }

    @Provides
    fun provideSalesPersonDao(database: AppDatabase): SalesPersonDao {
        return database.SalesPersonDao()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "bussiness.db"
        ).build()
    }

}