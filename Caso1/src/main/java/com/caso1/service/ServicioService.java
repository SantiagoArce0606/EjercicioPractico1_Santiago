package com.caso1.service;

import com.caso1.domain.Servicio;
import com.caso1.repository.ServicioRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ServicioService {
    
    private final ServicioRepository servicioRepository;
    
     public ServicioService(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
     }
     
     @Transactional(readOnly = true)
     public List <Servicio> getServicio(){
         return servicioRepository.findAll();
     }
     
     @Transactional
     public void save (Servicio servicio){
         servicioRepository.save(servicio);
         
     }
     
     @Transactional
     public void delete (Integer id){
         servicioRepository.deleteById(id);
     }
}
