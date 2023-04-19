package com.example.database_tongrui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LessonAdapter(val lessonsList: List<Lesson>): RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {

    class LessonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.findViewById<TextView>(R.id.textName)
        val tvSTime = itemView.findViewById<TextView>(R.id.textStartTime)
        val tvETime = itemView.findViewById<TextView>(R.id.textEndTime)
        val tvTeacher = itemView.findViewById<TextView>(R.id.etTeacher)
        val tvRoomNumber = itemView.findViewById<TextView>(R.id.etRoomNumber)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.activity_item_layout, parent, false)
        val viewHolder = LessonViewHolder(itemView)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return lessonsList.size
    }


    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        val currentLesson = lessonsList[position]
        holder.tvName.text = currentLesson.name
        holder.tvSTime.text = currentLesson.startTimes
        holder.tvETime.text = currentLesson.endTime
        holder.tvTeacher.text = currentLesson.teacher
        holder.tvRoomNumber.text = currentLesson.roomNumber
    }
}
