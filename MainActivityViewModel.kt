package com.example.database_tongrui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class MainActivityViewModel(app: Application):AndroidViewModel(app) {
    lateinit var allLessons: MutableLiveData<List<Lesson>>

    init {
        allLessons = MutableLiveData()

    }

    fun getAllUsersObservers():MutableLiveData<List<Lesson>>{
        return allLessons
    }

    fun getAllLesssons() {
        val LessonDao = LessonDatabase.getAppDatabase((getApplication()))?.lessonDao()
        val list = LessonDao?.getAllLessons()

        allLessons.postValue(list)
    }

    fun insertLessonInfo(entity: Lesson){
        val lessonDao = LessonDatabase.getAppDatabase(getApplication())?.lessonDao()
        lessonDao?.insertNewLesson(entity)
        getAllLesssons()
    }

    fun updateLessonInfo(entity: Lesson) {
        val lessonDao = LessonDatabase.getAppDatabase(getApplication())?.lessonDao()
        lessonDao?.updateLesson(entity)
        getAllLesssons()
    }

    fun deleteLessonInfo(entity: Lesson) {
        val lessonDao = LessonDatabase.getAppDatabase(getApplication())?.lessonDao()
        lessonDao?.deletLesson(entity)
        getAllLesssons()
    }
}