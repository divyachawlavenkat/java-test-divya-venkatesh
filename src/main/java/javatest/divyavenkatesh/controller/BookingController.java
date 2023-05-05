package javatest.divyavenkatesh.controller;

import javatest.divyavenkatesh.model.Booking;
import javatest.divyavenkatesh.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 *  booking controller
 *  @author divyavenkatesh
 */
@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;


    @PostMapping
    public List<Booking> processBookings(@RequestBody List<String> inputBookings) {
        return bookingService.processBookings(inputBookings);
    }
}
