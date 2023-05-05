package javatest.divyavenkatesh.unitTest;

import javatest.divyavenkatesh.model.Booking;
import javatest.divyavenkatesh.service.BookingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.*;

/**
 *   booking all possible unit test cases
 *   unit test case for processbookings() method
 *   @author divyavenkatesh
 */
class BookingServiceTest {
    private BookingService bookingService;

    @BeforeEach
    void setUp() {
        bookingService = new BookingService();
    }



    @Test
    void testProcessBookingsWithEmptyList() {
        //given
        // Prepare test data
        List<String> inputBookings = new ArrayList<>();

        //when
        // Call the method being tested
        List<Booking> result = bookingService.processBookings(inputBookings);

        //then
        // Perform assertions
        Assertions.assertTrue(result.isEmpty());
    }


    /**
     * Test an empty list of input bookings
     *
     */
    @Test
    public void testProcessBookings_EmptyInput() {
        //given
        BookingService bookingService = new BookingService();
        List<String> inputBookings = new ArrayList<>();

        //when
        List<Booking> result = bookingService.processBookings(inputBookings);

        //then
        Assertions.assertTrue(result.isEmpty());
    }

    /**
     * Test a single valid booking
     *
     */
    @Test
    public void testProcessBookings_SingleBooking() {
        //given
        BookingService bookingService = new BookingService();
        List<String> inputBookings = Arrays.asList("Booking1 EMP001 2023-05-05 10:00 2");

        //when
        List<Booking> result = bookingService.processBookings(inputBookings);

        //then
        Assertions.assertEquals(1, result.size());
        Booking booking = result.get(0);
        Assertions.assertEquals("EMP001", booking.getEmpId());
        Assertions.assertEquals("2023-05-05 10:00", booking.getStartTime());
        Assertions.assertEquals("12:00", booking.getEndTime());
    }

    /**
     * Test multiple valid bookings
     *
     */
    @Test
    public void testProcessBookings_MultipleBookings() {
        //given
        BookingService bookingService = new BookingService();
        List<String> inputBookings = Arrays.asList(
                "Booking1 EMP001 2023-05-05 10:00 2",
                "Booking2 EMP002 2023-05-05 14:30 1",
                "Booking3 EMP001 2023-05-06 09:00 3"
        );

        //when
        List<Booking> result = bookingService.processBookings(inputBookings);

        //then
        Assertions.assertEquals(3, result.size());

        Booking booking1 = result.get(0);
        Assertions.assertEquals("EMP001", booking1.getEmpId());
        Assertions.assertEquals("2023-05-05 10:00", booking1.getStartTime());
        Assertions.assertEquals("12:00", booking1.getEndTime());

        Booking booking2 = result.get(1);
        Assertions.assertEquals("EMP002", booking2.getEmpId());
        Assertions.assertEquals("2023-05-05 14:30", booking2.getStartTime());
        Assertions.assertEquals("15:30", booking2.getEndTime());

        Booking booking3 = result.get(2);
        Assertions.assertEquals("EMP001", booking3.getEmpId());
        Assertions.assertEquals("2023-05-06 09:00", booking3.getStartTime());
        Assertions.assertEquals("12:00", booking3.getEndTime());
    }


    /**
     * Test an invalid booking with missing fields
     *
     */
    @Test
    public void testProcessBookings_InvalidBookingMissingFields() {
        //given
        BookingService bookingService = new BookingService();
        List<String> inputBookings = Arrays.asList("Booking1 EMP001 2023-05-05");

        //when
        // Since the booking is invalid, it should be skipped and not added to the result list
        List<Booking> result = bookingService.processBookings(inputBookings);

        //then
        Assertions.assertTrue(result.isEmpty());
    }

    /**
     * Test an invalid booking with an invalid duration
     *
     */
    @Test
    public void testProcessBookings_InvalidBookingInvalidDuration() {
        //given
        BookingService bookingService = new BookingService();
        List<String> inputBookings = Arrays.asList("Booking1 EMP001 2023-05-05 10:00 abc");

        //when
        // Since the duration is invalid, it should be skipped and not added to the result list
        List<Booking> result = bookingService.processBookings(inputBookings);

        //then
        Assertions.assertTrue(result.isEmpty());
    }




}
