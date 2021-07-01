package me.shohag.bdjobstest1.utils

import android.text.Html
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import me.shohag.bdjobstest1.R
import me.shohag.bdjobstest1.main.JobsAdapter
import me.shohag.bdjobstest1.model.JobResponse
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<JobResponse.Data>?) {
    data?.let {
        val adapter = recyclerView.adapter as JobsAdapter
        adapter.submitList(data)
    }
}

@BindingAdapter("isFeatured")
fun bindIsFeatured(cardView: CardView, isFeatured: Boolean) {
    val context = cardView.context
    if (isFeatured) {
        cardView.setCardBackgroundColor(
            ContextCompat.getColor(
                context,
                R.color.gold
            )
        )
    } else {
        cardView.setCardBackgroundColor(
            ContextCompat.getColor(
                context,
                R.color.white
            )
        )
    }
}


@BindingAdapter("loadImg")
fun bindUrlImage(imageView: ImageView, url: String?) {
    if (url != null) {
        Picasso.get()
            .load(url)
            .into(imageView)
    }
}

@BindingAdapter("setExperience")
fun bindSetExperience(textView: TextView, job: JobResponse.Data?) {
    job?.let {
        val min: Int = it.minExperience
        val max: Int = it.maxExperience
        val context = textView.context
        if (min > 0 && max > 0) {
            textView.text = String.format(context.getString(R.string.experience_range), min, max)
        } else if (max > 0) {
            textView.text = String.format(context.getString(R.string.experience_range), 0, max)
        } else {
            textView.text = context.getString(R.string.na)
        }
    }
}

@BindingAdapter("salaryRange")
fun bindSalaryRange(textView: TextView, job: JobResponse.Data?) {
    job?.let {
        val min: String = it.minSalary
        val max: String = it.maxSalary
        val context = textView.context
        if (min.isNotEmpty() && max.isNotEmpty()) {
            textView.text = String.format(context.getString(R.string.salary_range), min, max)
        } else if (max.isNotEmpty()) {
            textView.text = String.format(context.getString(R.string.salary_range), "0", max)
        } else {
            textView.text = context.getString(R.string.negotiable)
        }
    }
}

@BindingAdapter("loadHtmlTxt")
fun bindConvertTextToHtml(textView: TextView, text: String?) {
    if (text != null) {
        textView.text =  Html.fromHtml(text, Html.FROM_HTML_MODE_COMPACT)
    }
}