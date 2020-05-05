package com.springrest.hotelbooking.controller;

import com.springrest.hotelbooking.model.Reservation;
import com.springrest.hotelbooking.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(ReservationResouce.ROOM_V_1_RESERVATION)
@CrossOrigin
public class ReservationResouce {
    public static final String ROOM_V_1_RESERVATION = "/room/v1/reservation/";

    @Autowired
    private final ReservationService reservationService;

    @Autowired
    public ReservationResouce(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Mono<Reservation> getReservationById(@PathVariable String id) {
        //return Mono.just("{}");
        return reservationService.getReservation(id);
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Mono<Reservation> createReservation(@RequestBody Mono<Reservation> reservation) {
        //return Mono.just("{}");
        //System.out.println("thisssssssssssssssssssssss");
        //System.out.println(reservation);
        return reservationService.createReservation(reservation);
    }

    @PutMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Mono<Reservation> updatePrice(@PathVariable String id, @RequestBody Mono<Reservation> reservation) {
        System.out.println("thisssssssssssssssssssssss1111111111111111111111");
        return reservationService.updateReservation(id, reservation);
    }

    @DeleteMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Mono<Boolean> deleteReservation(@PathVariable String id) {
        System.out.println("thisssssssssssssssssssssss2222222222222");
        return reservationService.deleteReservation(id);
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Flux<Reservation> getAllReservations() {
        //return Mono.just("{}");
        return reservationService.listAllReservations();
    }

}

