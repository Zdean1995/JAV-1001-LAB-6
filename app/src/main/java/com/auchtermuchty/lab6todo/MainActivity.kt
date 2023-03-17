package com.auchtermuchty.lab6todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.auchtermuchty.lab6todo.adapter.TodoAdapter
import com.auchtermuchty.lab6todo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recTodo.adapter = TodoAdapter()

        //sets the on click listener to add the edit view text to the recycler view
        //references: https://stackoverflow.com/questions/27845069/add-a-new-item-to-recyclerview-programmatically
        binding.btnAdd.setOnClickListener {
            (binding.recTodo.adapter as TodoAdapter).addTodoItem(binding.edtxtAdd.text.toString())
            (binding.recTodo.adapter as TodoAdapter).notifyItemInserted((binding.recTodo.adapter as TodoAdapter).itemCount -1)
            binding.edtxtAdd.text.clear()
        }
    }
}