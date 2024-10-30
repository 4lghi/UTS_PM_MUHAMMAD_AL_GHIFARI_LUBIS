package com.example.uts_lab

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var movieList: ArrayList<Movie>
    lateinit var posterList: Array<Int>
    lateinit var judulList: Array<String>
    lateinit var tahunList: Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        posterList = arrayOf(
            R.drawable.poster1,
            R.drawable.poster2,
            R.drawable.poster3,
            R.drawable.poster4,
            R.drawable.poster5
        )

        judulList =  arrayOf(
            "Jaws",
            "2",
            "3",
            "4",
            "5"
        )

        tahunList = arrayOf(
            "Jaws",
            "2",
            "3",
            "4",
            "5"
        )

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        movieList = arrayListOf<Movie>()
        getData()

    }


    private fun getData (){
        for (i in posterList.indices){
            val movie = Movie(judulList[i], tahunList[i], posterList[i])
            movieList.add(movie)
        }
        recyclerView.adapter = MovieAdapter(movieList)
    }
}