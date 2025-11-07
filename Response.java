package com.example.HotelBooking.dtos;

import com.example.HotelBooking.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Response {

    private Object rooms;

    //generic
    private int status;
    private String message;

    //for Login
    private String token;
    private UserRole role;
    private  Boolean active;
    private String expirationTime;

    //userData
    private UserDTO user;
    private List<UserDTO> users;

    //Booking data
    private BookingDTO booking;
    private List<BookingDTO> bookings;

    //room Payments
    private String transactionId;
    private PaymentDTO payment;
    private List<PaymentDTO> payments;

    //room Noitification
    private NotificationDTO notification;
    private List<NotificationDTO> notifications;

    private final LocalDateTime timestamp = LocalDateTime.now();


}
