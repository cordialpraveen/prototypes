package com.wedaa.notes.notification.service;

import com.wedaa.notes.notification.domain.Note;
import java.util.List;

public interface NoteService {
    public Note addnote(Note note);

    public List<Note> getNotes();

    public Note updateNote(Long id, Note note);

    public void deleteNote(Long id);
}
