package com.example.HotelBooking.services.impl;

import com.example.HotelBooking.dtos.*;
import com.example.HotelBooking.entities.Booking;
import com.example.HotelBooking.entities.User;
import com.example.HotelBooking.enums.UserRole;
import com.example.HotelBooking.exceptions.InvalidCredentialException;
import com.example.HotelBooking.exceptions.NotFoundException;
import com.example.HotelBooking.repositories.BookingRepository;
import com.example.HotelBooking.repositories.UserRepository;
//import com.example.HotelBooking.security.JwtUtils;
import com.example.HotelBooking.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    //private final JwtUtils jwtUtils;
    private final ModelMapper modelMapper;
    private final BookingRepository bookingRepository;

    @Override
    public Response registerUser(RegistrationRequest registrationRequest) {

        log.info("INSIDE registerUser()");

        UserRole role=UserRole.valueOf(registrationRequest.getRole());

        if(registrationRequest.getRole() != null){
            role = UserRole.valueOf(registrationRequest.getRole());

        }
        User userToSave=User.builder()
                .firstName(registrationRequest.getFirstName())
                .lastName(registrationRequest.getLastName())
                .email(registrationRequest.getEmail())
                .password(passwordEncoder.encode(registrationRequest.getPassword()))
                .phoneNumber(registrationRequest.getPhoneNumber())
                .role(role)
                .active(true)
                .build();

        userRepository.save(userToSave);

        return Response.builder()
                .status(200)
                .message("User registered successfully!")
                .build();
    }

    @Override
    public Response loginUser(LoginRequest loginRequest) {

        log.info("INSIDE loginUser()");

        User user=userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new NotFoundException("Email not found!"));
        if(!passwordEncoder.matches(loginRequest.getPassword(),user.getPassword())){
            throw new InvalidCredentialException("Password does not match!");
        }

        //String token =jwtUtils.generateToken(user.getEmail());

        return Response.builder()
                .status(200)
                .message("User Loggedin successfully!")
                .role(user.getRole())
                //.token(token)
                .active(user.isActive())
                .expirationTime("6 month")
                .build();
    }

    @Override
    public Response getAllUsers() {

        log.info("INSIDE getAllUsers()");

        List<User> users=userRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));

        List<UserDTO> userDTOList = modelMapper.map(users,new TypeToken<List<UserDTO>>(){}.getType());

        return Response.builder()
                .status(200)
                .message("sucess")
                .users(userDTOList)
                .build();
    }

    @Override
    public Response getOwnAccountDetails() {

        log.info("INSIDE getOwnAccountDetails()");

        String email= SecurityContextHolder.getContext().getAuthentication().getName();
        User user=userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("User not found!"));

        UserDTO userDTO=modelMapper.map(user,UserDTO.class);

        return Response.builder()
                .status(200)
                .message("success")
                .user(userDTO)
                .build();
    }

    @Override
    public User getCurrentLoggedInUser() {

        log.info("INSIDE getCurrentLoggedInUser()");

        String email= SecurityContextHolder.getContext().getAuthentication().getName();

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("User not found!"));
    }

    @Override
    public Response updateOwnAccount(UserDTO userDTO) {
        log.info("INSIDE updateOwnAccount()");
        User currentUser =getCurrentLoggedInUser();

        if(userDTO.getEmail() !=null) currentUser.setEmail(userDTO.getEmail());
        if(userDTO.getFirstName() !=null) currentUser.setFirstName(userDTO.getFirstName());
        if(userDTO.getLastName() !=null) currentUser.setLastName(userDTO.getLastName());
        if(userDTO.getPhoneNumber() !=null) currentUser.setPhoneNumber(userDTO.getPhoneNumber());

        if(userDTO.getPassword() !=null && !userDTO.getPassword().isEmpty()){
            currentUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        }
        userRepository.save(currentUser);

        return Response.builder()
                .status(200)
                .message("User updated successfully")
                .build();
    }

    @Override
    public Response deleteOwnAccount() {
        log.info("INSIDE deleteOwnAccount()");

        User currentUser =getCurrentLoggedInUser();

        userRepository.delete(currentUser);

        return Response.builder()
                .status(200)
                .message("User deleted successfully")
                .build();
    }

    @Override
    public Response getMyBookingHistory() {
        log.info("INSIDE getMyBookingHistory()");

        User currentUser =getCurrentLoggedInUser();

        List<Booking> bookingList=bookingRepository.findByUserId(currentUser.getId());

        List<BookingDTO> bookingDTOList = modelMapper
                .map(bookingList,new TypeToken<List<BookingDTO>>(){}.getType());

        return Response.builder()
                .status(200)
                .message("User deleted successfully")
                .bookings(bookingDTOList)
                .build();

    }
}
