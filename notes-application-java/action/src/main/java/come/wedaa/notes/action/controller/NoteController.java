package come.wedaa.notes.action.controller;

import come.wedaa.notes.action.domain.Note;
import come.wedaa.notes.action.service.NoteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody Note note) {
        return ResponseEntity.ok(noteService.addnote(note));
    }

    @GetMapping
    public ResponseEntity<List<Note>> getNotes() {
        return ResponseEntity.ok(noteService.getNotes());
    }

    @PatchMapping
    public ResponseEntity<Note> updateNote(@RequestParam Long id, @RequestBody Note note) {
        return ResponseEntity.ok(noteService.updateNote(id, note));
    }

    @DeleteMapping
    public void deleteNote(@RequestParam Long id) {
        noteService.deleteNote(id);
    }
}
