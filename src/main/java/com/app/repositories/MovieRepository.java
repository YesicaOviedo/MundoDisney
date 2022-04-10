package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.model.Movie;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
	@Query(value="SELECT distinct m.* FROM  "
			+ "	movie m "
			+ "WHERE  "
			+ " (m.title=?1 OR ?1 is null)",
			nativeQuery=true)
	public List<Movie> findMovieByParams(String title);
}
