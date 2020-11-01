package com.gtxtreme.mvvmnews.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gtxtreme.mvvmnews.adapters.NewsAdapter
import com.gtxtreme.mvvmnews.R
import com.gtxtreme.mvvmnews.model.Article
import com.gtxtreme.mvvmnews.repository.NewsRepository
import com.gtxtreme.mvvmnews.viewmodel.NewsViewModel
import javax.inject.Inject

/**
 * A fragment representing a list of Items.
 */
class NewsFragment : Fragment() {

    private var columnCount = 1
    private lateinit var viewModel: NewsViewModel

    @Inject private var newsRepository: NewsRepository? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view:View
        view = inflater.inflate(R.layout.fragment_news_list, container, false)

        viewModel = ViewModelProvider(this,object :ViewModelProvider.Factory{
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return newsRepository?.let { NewsViewModel(it) } as T
            }
        }).get(NewsViewModel::class.java)
        val listOfArticles: List<Article>? = viewModel.getAllPostsFromRepository().value

        if(listOfArticles.isNullOrEmpty()){
            view = inflater.inflate(R.layout.empty_news_list_view,container, false)
            var textView = view.findViewById<TextView>(R.id.textView)
            textView.text = "Something went wrong..The list is empty"
        }else{
            // Set the adapter
            if (view is RecyclerView) {
                with(view) {
                    layoutManager = when {
                        columnCount <= 1 -> LinearLayoutManager(context)
                        else -> GridLayoutManager(context, columnCount)
                    }


                    adapter = NewsAdapter(listOfArticles)

                }
            }
        }



        return view
    }





}