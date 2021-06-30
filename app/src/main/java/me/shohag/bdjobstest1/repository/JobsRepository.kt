package me.shohag.bdjobstest1.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import me.shohag.bdjobstest1.model.JobResponse
import me.shohag.bdjobstest1.network.RetrofitApiService

object JobsRepository {

    //Fetched jobs from Network
    val getJobs: Flow<JobResponse> = flow {
        val jobs = RetrofitApiService.retrofitService.getJobs()
        emit(jobs)
    }.flowOn(Dispatchers.IO)
}
