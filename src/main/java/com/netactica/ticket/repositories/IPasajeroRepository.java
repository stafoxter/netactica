package com.netactica.ticket.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netactica.ticket.domain.Pasajero;

@Repository
public interface IPasajeroRepository extends JpaRepository<Pasajero, UUID>{

	Optional<Pasajero> findByNro(String nro);

}
