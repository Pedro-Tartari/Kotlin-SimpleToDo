package com.example.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var todoList = mutableListOf(
            ToDo("Reaprendendo", false),
            ToDo("Kotlin + Android", true)
        )

        val adapter = ToDoAdapter(todoList)
        binding.rvList.adapter = adapter
        binding.rvList.layoutManager = LinearLayoutManager(this)

        binding.btnAdd.setOnClickListener {
            val title = binding.edItem.text.toString()
            val todo = ToDo(title, false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size - 1)
        }
    }
}