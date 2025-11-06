package com.example.HotelBooking.entities;

import com.example.HotelBooking.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Email is required")
    @Column(unique = true)
    private String email;
    private String firstName;
    private String lastName;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "phoneNumber is required")
    @Column(name="phone_number")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private UserRole role;
    private boolean active;
    private final LocalDateTime created = LocalDateTime.now();
}
