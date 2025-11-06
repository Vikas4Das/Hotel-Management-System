package com.example.HotelBooking.notification;

import com.example.HotelBooking.dtos.NotificationDTO;

public interface NotificationService {

    void sendEmail(NotificationDTO notificationDTO);

    void sendSms();
    void sendWhatsapp();

}
