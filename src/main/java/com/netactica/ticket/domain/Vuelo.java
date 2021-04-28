package com.netactica.ticket.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="VUELOS")
public class Vuelo  implements Serializable{

	private static final long serialVersionUID = 778068528987748761L;

	@Id
	@GeneratedValue
	@Type(type="uuid-char")
	private UUID id;
	@Column(name = "nro_vuelo")
	private String nroVuelo;
	@Column(name = "fecha_salida")
	private LocalDate fechaSalida;
	@Column(name = "fecha_llegada")
	private LocalDate fechaLlegada;
	@Column(name = "hora_salida")
	private LocalTime horaSalida;
	@Column(name = "hora_llegada")
	private LocalTime horaLlegada;
	@ManyToOne
	@JoinColumn(name = "ciudad_origen_id")
	private Ciudad ciudadOrigen;
	@ManyToOne
	@JoinColumn(name = "ciudad_destino_id")
	private Ciudad ciudadDestino;
	@Column(name = "tiene_bodega_equipaje")
	private boolean tieneBodegaEquipaje;
	
}
