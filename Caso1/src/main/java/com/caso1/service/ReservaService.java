package com.caso1.service;

import com.caso1.domain.Reserva;
import com.caso1.repository.ReservaRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {
    
    private final ReservaRepository reservaRepository;
    
     public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
     }
     
     @Transactional(readOnly = true)
     public List <Reserva> getReserva(){
         return reservaRepository.findAll();
     }
     
     @Transactional
     public void save (Reserva reserva){
         reservaRepository.save(reserva);
         
     }
     
     @Transactional
     public void delete (Integer id){
         reservaRepository.deleteById(id);
     }
}
