package javatest.divyavenkatesh.integrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import javatest.divyavenkatesh.controller.BookingController;
import javatest.divyavenkatesh.model.Booking;
import javatest.divyavenkatesh.service.BookingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 *  booking controller integration test
 *  @author divya_venaktesh
 */
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(BookingController.class)
public class BookingControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private BookingService bookingService;

    @Test
    public void testProcessBookings() throws Exception {
        // Mock data
        List<String> inputBookings = Arrays.asList("booking1", "booking2");
        List<Booking> expectedBookings = Arrays.asList(
                new Booking("empId1", "2023-05-05 10:00", "12:00"),
                new Booking("empId2", "2023-05-05 14:00", "16:00")
        );

        // Mock the behavior of the bookingService
        when(bookingService.processBookings(anyList())).thenReturn(expectedBookings);

        // Perform the POST request
        mockMvc.perform(post("/bookings")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(inputBookings)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(expectedBookings.size()))
                .andExpect(jsonPath("$[0].empId").value(expectedBookings.get(0).getEmpId()))
                .andExpect(jsonPath("$[0].startTime").value(expectedBookings.get(0).getStartTime()))
                .andExpect(jsonPath("$[0].endTime").value(expectedBookings.get(0).getEndTime()))
                .andExpect(jsonPath("$[1].empId").value(expectedBookings.get(1).getEmpId()))
                .andExpect(jsonPath("$[1].startTime").value(expectedBookings.get(1).getStartTime()))
                .andExpect(jsonPath("$[1].endTime").value(expectedBookings.get(1).getEndTime()));
    }

}
