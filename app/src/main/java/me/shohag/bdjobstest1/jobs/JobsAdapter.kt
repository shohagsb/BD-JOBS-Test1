package me.shohag.bdjobstest1.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import me.shohag.bdjobstest1.databinding.ItemJobBinding
import me.shohag.bdjobstest1.model.JobResponse

class JobsAdapter(private val clickListener: JobListener) :
    ListAdapter<JobResponse.Data, JobsAdapter.JobsViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobsViewHolder {
        return JobsViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: JobsViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)
    }

    class JobsViewHolder private constructor(private val binding: ItemJobBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(job: JobResponse.Data, clickListener: JobListener) {
            binding.job = job
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): JobsViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val view = ItemJobBinding.inflate(inflater, parent, false)
                return JobsViewHolder(view)
            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<JobResponse.Data>() {
        override fun areItemsTheSame(
            oldItem: JobResponse.Data,
            newItem: JobResponse.Data
        ): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: JobResponse.Data,
            newItem: JobResponse.Data
        ): Boolean {
            return oldItem.jobTitle == newItem.jobTitle
        }
    }

}

class JobListener(val clickListener: (job: JobResponse.Data) -> Unit) {
    fun onClick(job: JobResponse.Data) = clickListener(job)
}