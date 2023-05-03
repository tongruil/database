package com.example.database_tongrui

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Lesson::class], version = 1)
abstract class LessonDatabase : RoomDatabase() {
    abstract fun lessonDao(): LessonDao?

    companion object {
        private var INSTANCT: LessonDatabase?=null

        fun getAppDatabase(context: Context): LessonDatabase? {
            if(INSTANCT == null) {
                INSTANCT = Room.databaseBuilder<LessonDatabase>(
                    context.applicationContext, LessonDatabase::class.java,"APPDB"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCT
        }
    }
}