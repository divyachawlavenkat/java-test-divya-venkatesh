package javatest.divyavenkatesh.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *  booking model
 *  attribute "empId" representing employee identification
 *  attribute "startTime" representing meeting bookings start time in duration
 *  attribute "endTime" representing meeting bookings end time in duration
 *  @author divyavenkatesh
 */
@Data
@AllArgsConstructor
public class Booking {
    private String empId;
    private String startTime;
    private String endTime;

}
