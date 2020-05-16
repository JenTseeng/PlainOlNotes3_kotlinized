package com.example.plainolnotes3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.plainolnotes3.databinding.ActivityMainBinding
import com.example.plainolnotes3.database.NoteEntity
import com.example.plainolnotes3.ui.NotesAdapter
import com.example.plainolnotes3.utilities.SampleData
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.content_main.view.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var notesAdapter: NotesAdapter

    private val notesData = ArrayList<NoteEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val toolbar = view.toolbar
        setSupportActionBar(toolbar)
        view.fab.setOnClickListener { onFabClick() }

        notesData.addAll(SampleData().getNotes())
        for (note in notesData) {
            Log.i("PlainOlNotes", note.toString())
        }

        recyclerView = view.recyclerView
        initRecyclerView()
    }

    private fun onFabClick() {
        intent = Intent(this, EditorActivity::class.java)
        startActivity(intent)
    }

    private fun initRecyclerView() {
        recyclerView.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        notesAdapter = NotesAdapter(notesData)
        recyclerView.adapter = notesAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }
}
