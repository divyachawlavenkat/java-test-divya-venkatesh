package javatest.divyavenkatesh.service;

import javatest.divyavenkatesh.model.Booking;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *  booking service
 *  @author divyavenkatesh
 */
@Service
public class BookingService implements BookingServiceInterface{

    @Override
    public List<Booking> processBookings(List<String> inputBookings) {
        List<Booking> bookings = new ArrayList<>();

        // Process each booking request
        for (String booking : inputBookings) {
            String[] bookingDetails = booking.split(" ");
            String empId = bookingDetails[1];
            String startTime = bookingDetails[2];
            int duration = Integer.parseInt(bookingDetails[3]);

            // Calculate end time
            LocalDateTime startDateTime = LocalDateTime.parse(startTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            LocalDateTime endDateTime = startDateTime.plusHours(duration);

            Booking newBooking = new Booking(empId, startTime, endDateTime.format(DateTimeFormatter.ofPattern("HH:mm")));
            bookings.add(newBooking);
        }

        return bookings;
    }
}
