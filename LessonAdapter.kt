package com.example.database_tongrui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LessonAdapter(val listener: RowClickListener): RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {

    var items = ArrayList<Lesson>()

    fun setListData(data: ArrayList<Lesson>){
        this.items = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        // don't change
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.activity_item_layout, parent, false)
        val viewHolder = LessonViewHolder(itemView, listener)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return items.size
    }
    class LessonViewHolder(itemView: View, val listener: RowClickListener) : RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.findViewById<TextView>(R.id.textName)
        val tvSTime = itemView.findViewById<TextView>(R.id.textStartTime)
        val tvETime = itemView.findViewById<TextView>(R.id.textEndTime)
        val tvTeacher = itemView.findViewById<TextView>(R.id.etTeacher)
        val tvRoomNumber = itemView.findViewById<TextView>(R.id.etRoomNumber)
        fun bind(data: Lesson) {
            tvName.text = data.name
            tvSTime.text = data.startTimes
            tvETime.text = data.endTime
            tvTeacher.text = data.teacher
            tvRoomNumber.text = data.roomNumber
        }

    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {

        holder.bind(items[position])
        holder.itemView.setOnClickListener {
            listener.onItemClickListener(items[position])
        }
//        val currentLesson = lessonsList[position]
//        holder.tvName.text = currentLesson.name
//        holder.tvSTime.text = currentLesson.startTimes
//        holder.tvETime.text = currentLesson.endTime
//        holder.tvTeacher.text = currentLesson.teacher
//        holder.tvRoomNumber.text = currentLesson.roomNumber

    }

    interface RowClickListener {

        fun onDeleteLessonClickListener(lesson: Lesson)
        fun onItemClickListener(lesson: Lesson)
    }
}
