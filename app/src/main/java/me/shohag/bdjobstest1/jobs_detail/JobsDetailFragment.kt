package me.shohag.bdjobstest1.jobs_detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.shohag.bdjobstest1.R
import me.shohag.bdjobstest1.model.JobResponse

class JobsDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val jobArg = arguments?.let { JobsDetailFragmentArgs.fromBundle(it) }
        val job = jobArg?.selectedJobs
        Log.d("JobDetailTAG", "onCreateView: ${job?.jobTitle}")
        return inflater.inflate(R.layout.fragment_jobs_detail, container, false)
    }

}