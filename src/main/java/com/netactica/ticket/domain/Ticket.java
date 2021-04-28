package com.netactica.ticket.domain;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name="TICKETS")
public class Ticket implements Serializable{

	private static final long serialVersionUID = -932691453139409025L;

	@Id
	@GeneratedValue
	@Type(type="uuid-char")
	private UUID id;
	@Column(name = "itinerary_id")
	private String itineraryID;		
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "pasajero_id")
	private Pasajero pasajero;
	private double precio;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vuelo_id")	
	private Vuelo vuelo;

}
