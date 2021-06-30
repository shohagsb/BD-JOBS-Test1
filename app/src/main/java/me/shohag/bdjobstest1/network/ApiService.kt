package me.shohag.bdjobstest1.network

import me.shohag.bdjobstest1.model.JobResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(Constants.BASE_URL)
    .build()

interface ApiServices {
    @GET("interviewtest/InterviewJson.json")
    suspend fun getJobs(): JobResponse
}

object RetrofitApiService {
    val retrofitService: ApiServices by lazy {
        retrofit.create(ApiServices::class.java)
    }
}