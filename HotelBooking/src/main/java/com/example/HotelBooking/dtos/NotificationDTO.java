package com.example.HotelBooking.dtos;

import com.example.HotelBooking.enums.NotificationType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class NotificationDTO {

    private Long id;
    @NotBlank(message = "Subject is required")
    private String subject;

    @NotBlank(message = "recipient is required")
    private String recipient;

    private String body;


    private NotificationType type;

    private String bookingReference;

    private LocalDateTime CreatedAt;
}
