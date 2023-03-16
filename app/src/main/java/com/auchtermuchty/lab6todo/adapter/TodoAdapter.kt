package com.auchtermuchty.lab6todo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckedTextView
import androidx.recyclerview.widget.RecyclerView
import com.auchtermuchty.lab6todo.R

class TodoAdapter(private val context: Context)
    : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    private var todoStrings: MutableList<String> = mutableListOf()

    class TodoViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val checkedTextView = view.findViewById(R.id.txt_todo) as CheckedTextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.todo_item, parent, false)
        return TodoViewHolder(adapterLayout)
    }

    override fun getItemCount() = todoStrings.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.checkedTextView.text = todoStrings[0]
    }

    fun addTodoItem(todoString: String) {
        todoStrings.add(todoString)
    }
}