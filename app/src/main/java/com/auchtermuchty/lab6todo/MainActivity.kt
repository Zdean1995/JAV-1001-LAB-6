package com.auchtermuchty.lab6todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.auchtermuchty.lab6todo.adapter.TodoAdapter
import com.auchtermuchty.lab6todo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recTodo.adapter = TodoAdapter(this)

        binding.btnAdd.setOnClickListener {
            (binding.recTodo.adapter as TodoAdapter).addTodoItem(binding.edtxtAdd.text.toString())
            (binding.recTodo.adapter as TodoAdapter).notifyItemInserted((binding.recTodo.adapter as TodoAdapter).itemCount -1)
            binding.edtxtAdd.text.clear()
        }
    }
}