package com.bagicode.movie

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

import kotlinx.android.synthetic.main.activity_movie_list.*
import kotlinx.android.synthetic.main.content_movie_list.*
import kotlinx.android.synthetic.main.content_movie_list.rv_movie

class MovieListActivity : AppCompatActivity() {

    private var dataList = ArrayList<FilmModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)
        setSupportActionBar(toolbar)

        dataList = intent.getParcelableArrayListExtra("data");

        rv_movie.layoutManager = LinearLayoutManager(applicationContext)

        rv_movie.adapter = AllMovieAdapter(dataList) {
            val intent = Intent(
                this,
                DetailActivity::class.java
            ).putExtra("data", it)

            startActivity(intent)
        }
    }

}
