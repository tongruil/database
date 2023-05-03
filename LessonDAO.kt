package com.example.database_tongrui

import androidx.room.*

@Dao
interface LessonDao {
    @Query("SELECT * FROM lessons")
    fun getAllLessons(): List<Lesson>

    @Query("SELECT * FROM lessons WHERE name LIKE :lesson_name LIMIT 1")
    fun findByName(lesson_name: String): Lesson

    @Insert
    fun insertNewLesson(lesson: Lesson)

    @Query("DELETE FROM lessons")
    fun deleteAllLessons()

    @Delete
    fun deletLesson(lesson: Lesson?)

    @Update
    fun updateLesson(lesson: Lesson?)
}