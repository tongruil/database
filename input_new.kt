package com.example.database_tongrui

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.room.Room

class input_new : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_layout)

        val etName = findViewById<EditText>(R.id.etName)
        val etStartTime = findViewById<EditText>(R.id.etSTime)
        val etEndTime = findViewById<EditText>(R.id.etETime)
        val etTeacher = findViewById<EditText>(R.id.etTeacher)
        val etRoomName = findViewById<EditText>(R.id.etRoomNumber)
        val btnOK = findViewById<Button>(R.id.btnOK)
        val db = Room.databaseBuilder(
            applicationContext,
            LessonDatabase::class.java, "lessons_db"
        )
            .allowMainThreadQueries()
            .build()

        val dao = db.lessonDao()
        btnOK.setOnClickListener {
            val newLesson = Lesson(etName.text.toString(),etStartTime.text.toString(),
                etEndTime.text.toString(), etTeacher.text.toString(),etRoomName.text.toString())
            dao?.insertNewLesson(newLesson)
            finish()
        }

    }

}