package com.hycomist.todoapp.di

import com.hycomist.todoapp.data.datasource.ToDosDataSource
import com.hycomist.todoapp.data.repo.ToDosRepository
import com.hycomist.todoapp.retrofit.ApiUtils
import com.hycomist.todoapp.retrofit.ToDosDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideToDosRepository(toDosDataSource: ToDosDataSource): ToDosRepository {
        return ToDosRepository(toDosDataSource)
    }

    @Provides
    @Singleton
    fun provideToDosDataSource(toDosDao: ToDosDao): ToDosDataSource {
        return ToDosDataSource(toDosDao)
    }

    @Provides
    @Singleton
    fun provideToDosDao(): ToDosDao {
        return ApiUtils.getToDosDao()
    }
}