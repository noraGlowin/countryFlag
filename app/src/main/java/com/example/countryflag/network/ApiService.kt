package com.example.countryflag.network

import com.example.countryflag.CountryInfo
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL ="https://countriesnow.space"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()



private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface countryApiService {
    @GET("photos")
    suspend fun getPhotos() : List<CountryInfo>
}

object CountryApi {
    val retrofitService: countryApiService by lazy { retrofit.create(countryApiService::class.java) }
}


