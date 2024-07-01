package ar.edu.unahur.ep.micro.services;

import ar.edu.unahur.ep.micro.domain.Producto;
import ar.edu.unahur.ep.micro.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository productoRepository;

    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }


    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Optional<Producto> getProductoById(Long id) {
        return productoRepository.findById(id);
    }

    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }

}
