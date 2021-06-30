package me.shohag.bdjobstest1.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import me.shohag.bdjobstest1.main.JobsAdapter
import me.shohag.bdjobstest1.model.JobResponse

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<JobResponse.Data>?) {
    data?.let {
        val adapter = recyclerView.adapter as JobsAdapter
        adapter.submitList(data)
    }
}