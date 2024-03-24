package com.hycomist.todoapp.di

import com.hycomist.todoapp.data.datasource.ToDosDataSource
import com.hycomist.todoapp.data.repo.ToDosRepository
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
    fun provideToDosDataSource(): ToDosDataSource {
        return ToDosDataSource()
    }
}