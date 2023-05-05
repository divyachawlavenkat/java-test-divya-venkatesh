# java-test-divya-venkatesh
Booking Application for employees to submit booking requests for meetings in the boardroom. The system keeps the requests in a text file (format below). Your employer has now asked you to implement a system for processing batches of booking requests. And you need to expose a REST api that will accept the text input and process them based on the boo
Classification: Limited

Your company has an existing legacy system for employees to submit booking requests for meetings
in the boardroom. The system keeps the requests in a text file (format below). Your employer has now asked you to implement a system for processing batches of booking requests. And you need to expose a REST api that will accept the text input and process them based on the booking rules and returns a structured json response as below.
1. Input
Your processing system must process input as text. The first line of the input paylod represents the company office hours, in 24 hour clock format (ignore timezones), and the remainder of the input represents individual booking requests. Each booking request is in the following format:
[Request submission time, in YYYY-MM-DD HH:MM:SS format] [Employee id]
[Meeting start time, in YYYY-MM-DD HH:MM format] [Meeting duration in hours]
A sample text input follows, to be used in your solution:
0900 1730
2020-01-18 10:17:06 EMP001 2020-01-21 09:00 2 2020-01-18 12:34:56 EMP002 2020-01-21 09:00 2 2020-01-18 09:28:23 EMP003 2020-01-22 14:00 2 2020-01-18 11:23:45 EMP004 2020-01-22 16:00 1 2020-01-15 17:29:12 EMP005 2020-01-21 16:00 3 2020-01-18 11:00:45 EMP006 2020-01-23 16:00 1 2020-01-15 11:00:45 EMP007 2020-01-23 15:00 2
 
Classification: Limited
2. Output
Your system must output a list of bookings in a specific format; with booking grouped chronologically by day. For the sample input displayed above, your system must provide the following output
 [
{
"data": "2020-01-21",
"bookings": [
    {
        "emp_id": "EMP001",
        "start_time": "09:00",
        "end_time": "11:00"
"data": "2020-01-22",
"bookings": [
    {
        "emp_id": "EMP003",
        "start_time": "14:00",
        "end_time": "16:00"
}, {
"emp_id": "EMP004",
"start_time": "16:00",
"end_time": "17:00"
"date": "2020-01-23",
"bookings": [
    {
        "emp_id": "EMP007",
        "start_time": "15:00",
        "end_time": "17:00"
3. Booking rules
- No part of a meeting may fall outside of office hours (9:00 to 18:00).
- Meetings may not overlap.
- The booking submission system only allows one submission at a time, so submission
times are guaranteed to be unique.

Classification: Limited
- Booking must be processed in the chronological order in which they were submitted.
- The ordering of booking submissions in the supplied input is not guaranteed.
The expected time to complete this test is 3 hours, but you can use more time if you need it to complete the task. Please make sure all code is checked at the end of the session and submit any extra documentation you would like to share
