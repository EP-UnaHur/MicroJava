package ar.edu.unahur.ep.micro.repository;

import ar.edu.unahur.ep.micro.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> { }
