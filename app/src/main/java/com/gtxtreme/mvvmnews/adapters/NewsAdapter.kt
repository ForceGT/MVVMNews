package com.gtxtreme.mvvmnews.adapters

import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.gtxtreme.mvvmnews.R

import com.gtxtreme.mvvmnews.model.Article
import com.gtxtreme.mvvmnews.model.News

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class NewsAdapter(
    private val values: List<Article>
) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.headlineView.text = item.title
        holder.dateView.text = item.publishedAt
        Glide.with(holder.imageView.context).load(item.urlToImage).into(holder.imageView)

        holder.itemView.setOnClickListener {
            val bundle = Bundle().apply {
                putSerializable("article",item)
            }
            it.findNavController().navigate(R.id.action_newsFragment_to_newsDetailFragment,bundle)
        }
        //holder.contentView.text = item.content
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val headlineView: TextView = view.findViewById(R.id.headlineText)
        val dateView: TextView = view.findViewById(R.id.dateTextView)
        val imageView: ImageView = view.findViewById(R.id.img_news)


        //val contentView: TextView = view.findViewById(R.id.content)

//        override fun toString(): String {
//            return super.toString() + " '" + contentView.text + "'"
//        }
    }
}