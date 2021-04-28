package com.netactica.ticket.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netactica.ticket.domain.Pais;

@Repository
public interface IPaisRepository extends JpaRepository<Pais, UUID>{

}
