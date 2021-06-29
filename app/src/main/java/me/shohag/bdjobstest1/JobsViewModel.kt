package me.shohag.bdjobstest1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import me.shohag.bdjobstest1.repository.JobsRepository

class JobsViewModel : ViewModel() {
    private val repository = JobsRepository
    private val _jobs = MutableLiveData<String>()
    val jobs: LiveData<String>
        get() = _jobs

    init {
        getJobs()
    }

    private fun getJobs() {
        viewModelScope.launch {
            repository.getJobs
                .catch { }
                .collect { jobs ->
                    _jobs.value = jobs
                }
        }
    }
}
