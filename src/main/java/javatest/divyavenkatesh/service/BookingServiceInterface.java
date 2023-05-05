package javatest.divyavenkatesh.service;

import javatest.divyavenkatesh.model.Booking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingServiceInterface {

    List<Booking> processBookings(List<String> inputBookings);
}
