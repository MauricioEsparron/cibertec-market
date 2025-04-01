package com.cibertec.cibertec_market.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.cibertec_market.domain.ProductoDTO;
import com.cibertec.cibertec_market.domain.service.ProductoService;

@RestController
@RequestMapping("/products")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping("/findAllProducts")
    public List<ProductoDTO> findAllProducts() {
        return productoService.findAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<ProductoDTO> findProductById(@PathVariable("id") int productId) {
        return productoService.findProductById(productId);
    }

    @GetMapping("/category/{categoryId}")
    public List<ProductoDTO> findByCategory(@PathVariable("categoryId") int categoryId) {
        return productoService.findByCategory(categoryId);
    }

    @PostMapping("/createProduct")
    public ProductoDTO createProduct(@RequestBody ProductoDTO product) {
        return productoService.createProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int productId) {
        try {
            productoService.deleteProduct(productId);
        } catch (Exception e) {
        }
        return "redirect:/productos/";
    }

}
