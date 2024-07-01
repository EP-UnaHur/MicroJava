package ar.edu.unahur.ep.micro.controllers;

import ar.edu.unahur.ep.micro.domain.Producto;
import ar.edu.unahur.ep.micro.exceptions.NotFoundException;
import ar.edu.unahur.ep.micro.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping
    public List<Producto> getProductos() {
        return productoService.getAllProductos();
    }
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoService.saveProducto(producto);
    }

    @DeleteMapping("/{id}")
    public Producto deleteProducto(@PathVariable Long id) {
        var producto = productoService.getProductoById(id).orElseThrow(()-> new NotFoundException("Producto no encontrado: " + id ));
        productoService.deleteProducto(id);
        return producto;
    }

    @GetMapping("/{id}")
    public Producto getProducto(@PathVariable Long id) {
        return productoService.getProductoById(id).orElseThrow(()-> new NotFoundException("Producto no encontrado: " + id ));
    }

}
