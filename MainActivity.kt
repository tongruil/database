package com.example.database_tongrui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import androidx.room.Room
import java.util.*

class MainActivity : AppCompatActivity(), LessonAdapter.RowClickListener{

    val REQUEST_INPUT = 10
    lateinit var lessonRecyclerView: RecyclerView
    lateinit var lessonAdapter: LessonAdapter
    lateinit var viewModel: MainActivityViewModel
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lessonRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            lessonAdapter = LessonAdapter(this@MainActivity)
            adapter = lessonAdapter
            val divider = DividerItemDecoration(applicationContext, VERTICAL)
            addItemDecoration(divider)
        }

        viewModel =


//        //val et = findViewById<RecyclerView>(R.id.recyclerView)
//        lessonRecyclerView = findViewById(R.id.recyclerView)
//
//        val btnShow = findViewById<Button>(R.id.btnShowAll)
//        val btnAdd = findViewById<Button>(R.id.btnAddNewLesson)
//        val btnDelete = findViewById<Button>(R.id.btnDeleteAll)
//
//        val db = Room.databaseBuilder(
//            applicationContext,
//            LessonDatabase::class.java, "lessons_db"
//        )
//            .allowMainThreadQueries()
//            .build()
//
//        val dao = db.lessonDao()
//        btnShow.setOnClickListener {
//            val lessons = dao?.getAllLessons()
//            lessonRecyclerView.adapter = lessons?.let { it1 -> LessonAdapter(it1) }
//            lessonRecyclerView.layoutManager = LinearLayoutManager(this)
//        }
//
//        btnAdd.setOnClickListener {
////            val inIntent = Intent(this, input_new::class.java)
////            startActivityForResult(inIntent, REQUEST_INPUT)
//            val newLesson = Lesson(
//                "IoT",
//                "16:00",
//                "17:20",
//                "Andrew",
//                "120"
//            )
//            dao?.insertNewLesson(newLesson)
//        }
//        btnDelete.setOnClickListener {
//            dao?.deleteAllLessons()
//        }
    }

    override fun onDeleteLessonClickListener(lesson: Lesson) {
        TODO("Not yet implemented")
    }

    override fun onItemClickListener(lesson: Lesson) {
        TODO("Not yet implemented")
    }
}