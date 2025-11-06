package com.example.HotelBooking.entities;

import com.example.HotelBooking.enums.BookingStatus;
import com.example.HotelBooking.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="bookings")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Booking {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade=CascadeType.REMOVE)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(cascade=CascadeType.REMOVE)
    @JoinColumn(name="room_id")
    private Room room;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    private BigDecimal totalPrice;
    private String bookingReference;
    private LocalDate cratedAt;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;


}
