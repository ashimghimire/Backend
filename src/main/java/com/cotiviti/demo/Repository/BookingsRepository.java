package com.cotiviti.demo.Repository;

import com.cotiviti.demo.entity.Bookings;
import com.cotiviti.demo.entity.Users;

import org.springframework.data.repository.CrudRepository;

public interface BookingsRepository extends CrudRepository<Bookings, String> {
}
