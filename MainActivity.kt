package com.example.database_tongrui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import java.util.*

class MainActivity : AppCompatActivity() {

    val REQUEST_INPUT = 10
    lateinit var  lessonRecyclerView: RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val et = findViewById<RecyclerView>(R.id.recyclerView)
        lessonRecyclerView = findViewById(R.id.recyclerView)

        val btnShow = findViewById<Button>(R.id.btnShowAll)
        val btnAdd = findViewById<Button>(R.id.btnAddNewLesson)
        val btnDelete = findViewById<Button>(R.id.btnDeleteAll)

        val db = Room.databaseBuilder(
            applicationContext,
            LessonDatabase::class.java, "lessons_db"
        )
            .allowMainThreadQueries()
            .build()

        val dao = db.lessonDao()
        btnShow.setOnClickListener {
            val lessons = dao.getAllLessons()
            lessonRecyclerView.adapter = LessonAdapter(lessons)
            lessonRecyclerView.layoutManager = LinearLayoutManager(this)
        }

        btnAdd.setOnClickListener {
//            val inIntent = Intent(this, input_new::class.java)
//            startActivityForResult(inIntent, REQUEST_INPUT)
            val newLesson = Lesson(
                "IoT",
                "16:00",
                "17:20",
                "Andrew",
                "120"
            )
            dao.insertNewLesson(newLesson)
        }
        btnDelete.setOnClickListener {
            dao.deleteAllLessons()
        }
    }
}