package com.example.HotelBooking.entities;

import com.example.HotelBooking.enums.RoomType;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@Entity
@Table(name="rooms")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Room {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Min(value = 1,message = "Room Number must be valid")
    @Column(unique=true)
    private Integer roomNumber;

    @Enumerated(EnumType.STRING)
    private RoomType type;

    @DecimalMin(value = "0.1",message = "Price per night is required")
    private BigDecimal pricePerNight;

    @Min(value = 1,message = "capacity must be at least 1")
    private Integer capacity;

    private String description; //description of  the room

    private String imageUrl;  //this will refrence the room picture
}
