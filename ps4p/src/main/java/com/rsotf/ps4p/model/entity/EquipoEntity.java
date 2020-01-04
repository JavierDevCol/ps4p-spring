package com.rsotf.ps4p.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "equipo")
public class EquipoEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String serial;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private SalaEntity sala;
	
	@Column (name = "numero_inventario", nullable = false)
	private  String numeroInventario;
	
	@OneToMany(
			mappedBy = "equipo",
			fetch = FetchType.LAZY,
			cascade = CascadeType.ALL
			)
	private List<ComponenteEntity> componentes;
	
	public void agregarComponente(ComponenteEntity comp) {
		
		componentes.add(comp);
	}

}
