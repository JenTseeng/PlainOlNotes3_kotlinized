package com.example.plainolnotes3.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.plainolnotes3.databinding.NoteListItemBinding
import com.example.plainolnotes3.model.NoteEntity

class NotesAdapter(
    private val mNotes: List<NoteEntity>
): RecyclerView.Adapter<NotesAdapter.ViewHolder>() {
    private lateinit var binding: NoteListItemBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        this.binding = NoteListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = mNotes[position]
        holder.bindNote(note)
    }

    override fun getItemCount(): Int = mNotes.size

    class ViewHolder(private val viewBinding: NoteListItemBinding) : RecyclerView.ViewHolder(viewBinding.root) {
        fun bindNote(note: NoteEntity) {
            viewBinding.noteText.text = note.text
        }
    }

}
