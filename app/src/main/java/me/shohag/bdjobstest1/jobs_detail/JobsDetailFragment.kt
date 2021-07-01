package me.shohag.bdjobstest1.jobs_detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.shohag.bdjobstest1.R
import me.shohag.bdjobstest1.databinding.FragmentJobsBinding
import me.shohag.bdjobstest1.databinding.FragmentJobsDetailBinding
import me.shohag.bdjobstest1.model.JobResponse

class JobsDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentJobsDetailBinding.inflate(inflater)
        val jobArg = arguments?.let { JobsDetailFragmentArgs.fromBundle(it) }
        val job = jobArg?.selectedJobs
        if (job != null){
            binding.job = job
        }
        Log.d("JobDetailTAG", "onCreateView: ${job?.jobTitle}")
        return binding.root
    }

}