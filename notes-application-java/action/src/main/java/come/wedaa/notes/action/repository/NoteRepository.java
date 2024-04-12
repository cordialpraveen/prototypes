package come.wedaa.notes.action.repository;

import come.wedaa.notes.action.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface NoteRepository extends JpaRepository<Note, Long> {}
