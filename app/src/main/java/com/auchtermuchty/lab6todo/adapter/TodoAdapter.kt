package com.auchtermuchty.lab6todo.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.auchtermuchty.lab6todo.R

class TodoAdapter(private val context: Context)
    : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    private var todoStrings: MutableList<String> = mutableListOf()

    class TodoViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val txtTodo = view.findViewById(R.id.txt_todo) as TextView
        val txtDone = view.findViewById(R.id.txt_done) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.todo_item, parent, false)

        return TodoViewHolder(adapterLayout)
    }

    override fun getItemCount() = todoStrings.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.txtTodo.text = todoStrings[position]
        holder.txtTodo.setOnClickListener {
            holder.txtDone.visibility = View.VISIBLE
            holder.txtTodo.setTextColor(Color.GRAY)
        }

        holder.txtDone.setOnClickListener {
            holder.txtDone.visibility = View.GONE
            holder.txtTodo.setTextColor(Color.BLACK)
        }
    }

    fun addTodoItem(todoString: String) {
        todoStrings.add(todoString)
    }
}