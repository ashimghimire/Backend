package com.cotiviti.demo.controller;

import com.cotiviti.demo.Repository.BookingsRepository;
import com.cotiviti.demo.Repository.UserRepository;
import com.cotiviti.demo.entity.Bookings;
import com.cotiviti.demo.entity.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingsController {

    @Autowired
    private BookingsRepository bookingsRepository;

    @GetMapping(path="/api/bookings")
    public @ResponseBody
    Iterable<Bookings> getBookings(){
        return bookingsRepository.findAll();
    }

    @GetMapping(path="/api/bookings/{id}")
    public @ResponseBody
    Bookings getBooking(@PathVariable String id){
        return bookingsRepository.findById(id).get();
    }

    @PostMapping(path="/api/bookings")
    public @ResponseBody
    Bookings addBooking(@RequestBody Bookings booking){

        return bookingsRepository.save(booking);
    }

}
