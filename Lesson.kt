package com.example.database_tongrui

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "lessons")
data class Lesson (
    @PrimaryKey
    val name: String,
    val startTimes:String,
    val endTime:String,
    val teacher:String,
    val roomNumber:String
)

