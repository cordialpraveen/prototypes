package com.wedaa.notes.notification.service.impl;

import com.wedaa.notes.notification.domain.Note;
import com.wedaa.notes.notification.repository.NoteRepository;
import com.wedaa.notes.notification.service.NoteService;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public Note addnote(Note note) {
        return noteRepository.save(note);
    }

    public List<Note> getNotes() {
        return noteRepository.findAll();
    }

    public Note updateNote(Long id, Note note) {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent()) {
            Note oldNote = optionalNote.get();
            if (Objects.nonNull(note.getSubject())) {
                oldNote.setSubject(note.getSubject());
            }
            if (Objects.nonNull(note.getDescription())) {
                oldNote.setDescription(note.getDescription());
            }
            return noteRepository.save(oldNote);
        }
        return null;
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}
