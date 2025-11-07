package com.example.HotelBooking.services;


import com.example.HotelBooking.dtos.Response;
import com.example.HotelBooking.dtos.RoomDTO;
import com.example.HotelBooking.enums.RoomType;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public interface RoomService {

    Response addRoom(RoomDTO roomDTO, MultipartFile imagefile);

    Response updateRoom(RoomDTO roomDTO, MultipartFile imagefile);

    Response getAllRooms();

    Response getRoomById(Long id);

    Response deleteRoom(Long id);

    Response getAvailableRooms(LocalDate checkinDate, LocalDate checkoutDate, RoomType roomType);

    List<RoomType> getAllRoomTypes();

    Response searchRooms(String input);


    //Response searchRoom(String input);
}


