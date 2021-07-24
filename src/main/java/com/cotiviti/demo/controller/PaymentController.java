package com.cotiviti.demo.controller;

import com.cotiviti.demo.Repository.PaymentRepository;
import com.cotiviti.demo.entity.Bookings;
import com.cotiviti.demo.entity.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentRepository payemtRepository;

    @GetMapping(path="/api/payments")
    public @ResponseBody
    Iterable<Payment> getPayments(){
        return payemtRepository.findAll();
    }

    @GetMapping(path="/api/payments/{id}")
    public @ResponseBody
    Payment getPayment(@PathVariable String id){
        return payemtRepository.findById(id).get();
    }

    @PostMapping(path="/api/payments")
    public @ResponseBody
    Payment addPayment(@RequestBody Payment payment){
        return payemtRepository.save(payment);
    }


    @PostMapping(path="/api/payments/amount")
    public @ResponseBody
    Amount getAmount(@RequestBody Bookings booking){
        Amount amount=calculateAmount(booking);
    return amount;
    }


    //This function will include full amount calculation matrix for future enchancements.
    private Amount calculateAmount(Bookings booking) {
        double unitEconomyTravelPrice = 400;
        if (booking.getTrip().equalsIgnoreCase("ONE_WAY")) {
            Amount amount = new Amount();
            amount.setBookingId(booking.getId());
            amount.setAmount(unitEconomyTravelPrice * Double.parseDouble(booking.getPassenger()));
            return amount;

        }

        if (booking.getTrip().equalsIgnoreCase("TWO_WAY")) {
            Amount amount = new Amount();
            amount.setBookingId(booking.getId());
            amount.setAmount(unitEconomyTravelPrice * Double.parseDouble(booking.getPassenger()) * 2.00);
            return amount;
        }

        return null;
    }



}
 class Amount {
    String bookingId;
    Double amount;

     public String getBookingId() {
         return bookingId;
     }

     public void setBookingId(String bookingId) {
         this.bookingId = bookingId;
     }

     public Double getAmount() {
         return amount;
     }

     public void setAmount(Double amount) {
         this.amount = amount;
     }
 }


