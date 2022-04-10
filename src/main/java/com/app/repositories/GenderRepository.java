package com.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Gender;

@Repository
public interface GenderRepository extends CrudRepository<Gender, Long>{

}
