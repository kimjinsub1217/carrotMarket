package com.example.toyproject013_carrotmarket.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toyproject013_carrotmarket.R
import com.example.toyproject013_carrotmarket.databinding.FragmentHomeBinding

class HomeFragment: Fragment(R.layout.fragment_home) {
    private var binding: FragmentHomeBinding? = null
    private lateinit var articleAdapter: ArticleAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentHomeBinding = FragmentHomeBinding.bind(view)
        binding =fragmentHomeBinding

        articleAdapter = ArticleAdapter()
        articleAdapter.submitList(mutableListOf<ArticleModel>().apply{
            add(ArticleModel("0","자두",100000,"3000원",""))
            add(ArticleModel("0","아이스크림",200000,"7000원",""))
        })

        fragmentHomeBinding.articleRecyclerView.layoutManager = LinearLayoutManager(context)
        fragmentHomeBinding.articleRecyclerView.adapter = articleAdapter

    }
}