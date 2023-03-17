package com.auchtermuchty.lab6todo.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.auchtermuchty.lab6todo.R

//The adapter for the recycler view in the main activity
//references: https://developer.android.com/codelabs/basic-android-kotlin-training-recyclerview-scrollable-list
class TodoAdapter
    : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    //the list of to do Items
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

        //the on click listeners for the text views in the recycler views
        //this sets the done text view visible when the user clicks on the to do items
        holder.txtTodo.setOnClickListener {
            holder.txtDone.visibility = View.VISIBLE
            holder.txtTodo.setTextColor(Color.GRAY)
        }

        //clicking the done text will get rid of it again, just in case the user clicked it by accident
        holder.txtDone.setOnClickListener {
            holder.txtDone.visibility = View.GONE
            holder.txtTodo.setTextColor(Color.BLACK)
        }
    }

    //The method for adding new to do items to the list of to do items
    fun addTodoItem(todoString: String) {
        todoStrings.add(todoString)
    }
}