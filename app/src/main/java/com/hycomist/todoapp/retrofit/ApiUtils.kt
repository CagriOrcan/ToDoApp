package com.hycomist.todoapp.retrofit

class ApiUtils {

    companion object {
        val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getToDosDao(): ToDosDao {
            return RetrofitClient.getClient(baseUrl = BASE_URL).create(ToDosDao::class.java)
        }
    }
}