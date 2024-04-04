package com.hycomist.todoapp.retrofit

import com.hycomist.todoapp.data.entity.CRUDResponse
import com.hycomist.todoapp.data.entity.ToDosResponse
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ToDosDao {
    // http://kasimadalan.pe.hu/toDos/getAllToDos.php
    // http://kasimadalan.pe.hu/ -> Base Url
    // toDos/getAllToDos.php -> Api Url

    @GET("toDos/getAllToDos.php")
    suspend fun loadToDos(): ToDosResponse

    @POST("toDos/insert.php")
    @FormUrlEncoded
    suspend fun save(
        @Field("name")
        name: String): CRUDResponse

    @POST("toDos/update.php")
    @FormUrlEncoded
    suspend fun update(@Field("id") id:Int,@Field("name") name: String): CRUDResponse


    @POST("toDos/delete.php")
    @FormUrlEncoded
    suspend fun delete(
        @Field("id") id: Int): CRUDResponse

    @POST("toDos/search.php")
    @FormUrlEncoded
    suspend fun search(@Field("name") searchText: String): ToDosResponse

}