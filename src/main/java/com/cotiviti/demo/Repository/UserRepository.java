package com.cotiviti.demo.Repository;

import com.cotiviti.demo.entity.Users;

import org.springframework.data.repository.CrudRepository;



public interface UserRepository extends CrudRepository<Users, Integer> {

}
