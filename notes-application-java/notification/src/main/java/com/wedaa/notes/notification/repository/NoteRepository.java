package com.wedaa.notes.notification.repository;

import com.wedaa.notes.notification.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface NoteRepository extends JpaRepository<Note, Long> {}
