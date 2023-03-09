package com.bagicode.movie

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data = intent.getParcelableExtra<FilmModel>("data")

        tv_title.setText(data.judul)
        tv_genre.setText(data.genre)
        tv_desc.setText(data.desc)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(vv_movie)
        vv_movie.setMediaController(mediaController)

        vv_movie.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + data.trailer))
        vv_movie.start()


    }
}
