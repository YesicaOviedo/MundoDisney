package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.model.Character;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
	@Query(value="SELECT distinct c.* FROM  "
			+ "	character_ c "
			+ "	LEFT JOIN movie_characters mp ON mp.characters_id=c.id "
			+ "	LEFT JOIN movie m ON mp.movie_id = m.id "
			+ "WHERE  "
			+ " (c.name=?1 OR ?1 is null)"
			+ " AND (c.age=?2 OR ?2 is null) "
			+ "	AND (m.id=?3 OR ?3 is null)",
			nativeQuery=true)
	public List<Character> obtenerPersonajePorParametros(String name,Integer age,Long movieId);
}