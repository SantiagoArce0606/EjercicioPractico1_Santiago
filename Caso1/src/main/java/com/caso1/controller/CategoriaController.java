
package com.caso1.controller;

import com.caso1.domain.Categoria;
import com.caso1.service.CategoriaService;
import jakarta.validation.Valid;
import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
    
    private final CategoriaService categoriaService;
    private final MessageSource messageSource;
    
    public CategoriaController(CategoriaService categoriaService, MessageSource messageSource) {
        this.categoriaService = categoriaService;
        this.messageSource = messageSource;
        
    }
    
    @GetMapping("/listado")
public String listado(Model model) {
    var categorias = categoriaService.getCategoria();
    model.addAttribute("categorias", categorias);
    model.addAttribute("totalCategorias", categorias.size());
    model.addAttribute("categoria", new Categoria());
    return "categoria/listado";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Categoria categoria, RedirectAttributes redirectAttributes) {
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }
    
     @PostMapping("/eliminar")
    public String eliminar(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        categoriaService.delete(id);
        return "redirect:/categoria/listado";
    }
    @GetMapping("/modificar/{id}")
public String modificar(@RequestParam Integer id, Model model) {
    model.addAttribute("categoria", categoriaService.getCategoria());
    return "/categoria/modificar";
}
}
