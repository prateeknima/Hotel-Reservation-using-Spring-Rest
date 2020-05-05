package com.springrest.hotelbooking.service;

import com.mongodb.MongoClient;
import com.springrest.hotelbooking.model.Reservation;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReservationService {

    public Mono<Reservation> createReservation(Mono<Reservation> reservationMono);

    public Mono<Reservation> getReservation(String id);

    public Mono<Reservation> updateReservation(String id, Mono<Reservation> reservationMono);

    public Mono<Boolean> deleteReservation(String id);

    Flux<Reservation> listAllReservations();

}
