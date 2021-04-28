package com.netactica.ticket.domain;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PAISES")
public class Pais implements Serializable{

	private static final long serialVersionUID = -2263016319300556285L;

	@Id
	@GeneratedValue
	@Type(type="uuid-char")
	private UUID id;
	private String nombre;
	@OneToMany(mappedBy = "pais",fetch = FetchType.LAZY)
	private List<Ciudad> ciudades;
}
