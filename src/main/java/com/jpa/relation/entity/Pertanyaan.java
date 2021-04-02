package com.jpa.relation.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table (name= "pertanyaaan")
public class Pertanyaan {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_pertanyaan;
	
	private String pertanyaan;
	private String jawaban1;
	private String jawaban2;
	private String jawaban3;
	private String jawaban4;
	private int jawaban_benar;
	private String gambar;
	private int Status_gambar;
	
	
	@OneToOne(cascade =  CascadeType.ALL)
	@JoinColumn(name="id_soal")
	private Nilai nilai;

}
