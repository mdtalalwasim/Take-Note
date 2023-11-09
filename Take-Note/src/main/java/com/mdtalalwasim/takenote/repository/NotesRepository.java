package com.mdtalalwasim.takenote.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mdtalalwasim.takenote.entity.Notes;
import com.mdtalalwasim.takenote.entity.User;

public interface NotesRepository extends JpaRepository<Notes, Integer> {
	
	
	List<Notes> findByUser(User user);

}
