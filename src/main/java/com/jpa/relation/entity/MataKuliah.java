package com.jpa.relation.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table (name= "matakuliah")
public class MataKuliah {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id_matakuliah;
	
	private String nama_matakuliah;
	
	
	@ManyToMany(mappedBy = "listMatakuliah",  fetch = FetchType.LAZY)
    private List<Mahasiswa> listMahasiswa = new ArrayList<Mahasiswa>();
    

}
