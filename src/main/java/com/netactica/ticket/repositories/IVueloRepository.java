package com.netactica.ticket.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netactica.ticket.domain.Vuelo;

@Repository
public interface IVueloRepository extends JpaRepository<Vuelo, UUID>{

	Optional<Vuelo> findByNroVuelo(String nroVuelo);

}
