package com.netactica.ticket.domain;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PASAJEROS")
public class Pasajero  implements Serializable{

	private static final long serialVersionUID = -9122997835842242191L;

	@Id
	@GeneratedValue
	@Type(type="uuid-char")
	private UUID id;
	private String nro;
	private String nombre;
	private int edad;
}
