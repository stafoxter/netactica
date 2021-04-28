package com.netactica.ticket.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="CIUDADES")
public class Ciudad implements Serializable{

	private static final long serialVersionUID = 4520902635851685464L;

	@Id
	@GeneratedValue
	@Type(type="uuid-char")
	private UUID id;
	private String nombre;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pais_id")
	private Pais pais;

	public String getUbicacionCiudad() {
		return (Objects.nonNull(pais)? pais.getNombre() + ", ": "")+
				nombre;
	}
}
