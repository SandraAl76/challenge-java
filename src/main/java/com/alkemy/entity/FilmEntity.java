package com.alkemy.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "movie_serie")
@Getter //create getter methods
@Setter //create setter methods
public class FilmEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE) //
	private Long id;
	
	private String img;
	private String title;
	
	@Column(name = "date_creation")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate dateCreation;
	
	private int calification;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, 
			CascadeType.MERGE})
	
	@JoinTable(name = "character_film",
			joinColumns = @JoinColumn(name = "film_id"),
			inverseJoinColumns = @JoinColumn(name = "character_id")) //how I joined with character entity table
	private List<CharacterEntity> characters = new ArrayList<>();

}
