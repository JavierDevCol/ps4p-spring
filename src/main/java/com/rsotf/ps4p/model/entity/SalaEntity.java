package com.rsotf.ps4p.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sala")
public class SalaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String nombre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private EdificioEntity edificio;
	
	@OneToMany(
			mappedBy = "sala",
			fetch = FetchType.LAZY,
			cascade = CascadeType.ALL
			)
	private List<EquipoEntity> equipos;
	
	@NotEmpty
	private String capacidadEst;
	
	@OneToMany(
			mappedBy = "sala",
			fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private List<AccesorioEntity> accesorios;

}
