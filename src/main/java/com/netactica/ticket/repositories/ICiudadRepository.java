package com.netactica.ticket.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netactica.ticket.domain.Ciudad;

@Repository
public interface ICiudadRepository extends JpaRepository<Ciudad, UUID>{

}
