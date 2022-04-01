package com.example.jetnoteapp.data

import com.example.jetnoteapp.model.Note

class Dummydata {
    fun dataSource(): List<Note> {
    return listOf(
        Note(title = "Day 1", description = "Feeling well"),
        Note(title = "Day 2", description = "Getting better at it"),
        Note(title = "Day 3", description = "Getting things done"),
        Note(title = "Day 4", description = "Running away from things"),
        Note(title = "Day 5", description = "Feeling overwhelmed"),
        Note(title = "Day 6", description = "Took a break"),
        Note(title = "Day 7", description = "Got back up again"),
        Note(title = "Day 8", description = "Getting overwhelmed again"),
        Note(title = "Day 9", description = "Not giving up"),
        Note(title = "Day 10", description = "Getting better at it"),
        Note(title = "Day 11", description = "Finally mastered it!"),
        )
    }
}