package com.example.planmaster

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.planmaster.databinding.ActivityMainnewBinding



class MainActivitynew : AppCompatActivity() {

    private lateinit var binding: ActivityMainnewBinding
    private lateinit  var db:NotesDatabaseHelper
    private lateinit var notesAdapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainnewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NotesDatabaseHelper(this)
        notesAdapter = NotesAdapter(db.getAllNotes(),this)

        binding.noteRecyclerview.layoutManager = LinearLayoutManager(this)
        binding.noteRecyclerview.adapter=notesAdapter
        binding.addButton.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }
    }
    override  fun onResume(){
        super.onResume()
        notesAdapter.refreshData(db.getAllNotes())
    }
}
