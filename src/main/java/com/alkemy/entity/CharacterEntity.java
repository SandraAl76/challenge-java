package com.alkemy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "charakter")
@Getter //create getter methods
@Setter //create setter methods
public class CharacterEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String img;
	private String name;
	private int age;
	private double weight;
	private String history;
	
	@ManyToMany(mappedBy = "characters", cascade = CascadeType.ALL)
	private List<FilmEntity> films = new ArrayList<>(); 
	
	@Column(name = "film_id", nullable = false)
	private long filmId;
	
}
