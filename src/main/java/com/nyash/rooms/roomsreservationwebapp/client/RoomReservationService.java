package com.nyash.rooms.roomsreservationwebapp.client;

import com.nyash.rooms.roomsreservationwebapp.domain.Room;
import com.nyash.rooms.roomsreservationwebapp.domain.RoomReservation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "RESERVATIONBUSINESSSERVICES")
public interface RoomReservationService {

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    public List<Room> getAllRooms(@RequestParam(name = "roomNumber", required = false)String roomNumber);

    @RequestMapping(value = "/roomReservations/{date}", method = RequestMethod.GET)
    public List<RoomReservation> getRoomReservationsForDate(@PathVariable("date") String date);
}
