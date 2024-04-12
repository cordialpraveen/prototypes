package come.wedaa.notes.action.service;

import come.wedaa.notes.action.domain.Note;
import java.util.List;

public interface NoteService {
    public Note addnote(Note note);

    public List<Note> getNotes();

    public Note updateNote(Long id, Note note);

    public void deleteNote(Long id);
}
