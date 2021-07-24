package com.cotiviti.demo.Repository;

import com.cotiviti.demo.entity.Payment;
import com.cotiviti.demo.entity.Users;

import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, String> {
}
