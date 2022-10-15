package com.ciclo3.reto3.services;

import com.ciclo3.reto3.entities.Admin;
import com.ciclo3.reto3.entities.Reservation;
import com.ciclo3.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int idReservation){
        return reservationRepository.getReservation(idReservation);
    }

    public Reservation save(Reservation r){
        if(r.getIdReservation()==null){
            return reservationRepository.save(r);
        }else{
            Optional<Reservation> resaux= reservationRepository.getReservation(r.getIdReservation());
            if (resaux.isPresent()){
                return reservationRepository.save(r);
            }else {
                return r;
            }
        }
    }
    public Reservation update(Reservation r) {
        if (r.getIdReservation() != null) {
            Optional<Reservation> res = reservationRepository.getReservation(r.getIdReservation());
            if (res.isPresent()) {
                Reservation oldRes = res.get();
                if (r.getStartDate() != null) {
                    oldRes.setStartDate(r.getStartDate());
                }
                if (r.getDevolutionDate() != null) {
                    oldRes.setDevolutionDate(r.getDevolutionDate());
                }
                if (r.getStatus() != null) {
                    oldRes.setStatus(r.getStatus());
                }
                if (r.getScore() != null) {
                    oldRes.setScore(r.getScore());
                }
                return reservationRepository.save(oldRes);
            }
        }
        return r;
    }

    public boolean delete(int id) {
        Optional<Reservation> Rese = reservationRepository.getReservation(id);
        if (Rese.isPresent()) {
            reservationRepository.delete(Rese.get());
            return true;
        } else {
            return false;
        }
    }
}
