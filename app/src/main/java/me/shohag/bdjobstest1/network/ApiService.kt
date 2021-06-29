package me.shohag.bdjobstest1.network

import me.shohag.bdjobstest1.Constants
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(Constants.BASE_URL)
    .build()

interface ApiServices {
    @GET("interviewtest/InterviewJson.json")
    suspend fun getJobs(): String
}

object RetrofitApiService {
    val retrofitService: ApiServices by lazy {
        retrofit.create(ApiServices::class.java)
    }
}