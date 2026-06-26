
package com.caso1.service;

import com.caso1.domain.Categoria;
import com.caso1.repository.CategoriaRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    
    private final CategoriaRepository categoriaRepository;
    
     public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
     }
     
     @Transactional(readOnly = true)
     public List <Categoria> getCategoria(){
         return categoriaRepository.findAll();
     }
     
     @Transactional
     public void save (Categoria categoria){
         categoriaRepository.save(categoria);
         
     }
     
     @Transactional
     public void delete (Integer id){
         categoriaRepository.deleteById(id);
     }
}
