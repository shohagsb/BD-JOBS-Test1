package me.shohag.bdjobstest1.jobs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import me.shohag.bdjobstest1.databinding.FragmentJobsBinding
import me.shohag.bdjobstest1.main.JobListener
import me.shohag.bdjobstest1.main.JobsAdapter

class JobsFragment : Fragment() {
    private val viewModel: JobsViewModel by lazy {
        ViewModelProvider(this).get(JobsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentJobsBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.jobsRecycler.adapter = JobsAdapter(JobListener { job ->
            viewModel.onJobClicked(job)
        })

        viewModel.navigateToDetailFragment.observe(viewLifecycleOwner, {
            it?.let { job ->
                this.findNavController().navigate(
                    JobsFragmentDirections
                        .actionJobsFragmentToJobsDetailFragment(job)
                )
                viewModel.onJobNavigated()
            }
        })

        return binding.root
    }


}