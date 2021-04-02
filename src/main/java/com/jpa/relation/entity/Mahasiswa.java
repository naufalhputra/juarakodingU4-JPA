package com.jpa.relation.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table (name= "mahasiswa")

public class Mahasiswa {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long nim;

    private String password;
    private String jeniskelamin;
    private String nama_mahasiswa;
    
    


	  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	    @JoinTable(name = "plot_matakuliah",
	    joinColumns = {
	            @JoinColumn(name = "id_plotMatakuliah", referencedColumnName = "id_plotMatakuliah", nullable = false, updatable = false)},
	    inverseJoinColumns = {
	    		@JoinColumn(name = "nim", referencedColumnName = "nim", nullable = false, updatable = false),
	            @JoinColumn(name = "id_matakuliah", referencedColumnName = "id_matakuliah", nullable = false, updatable = false),
	    		@JoinColumn(name = "id_dosen", referencedColumnName = "id_dosen", nullable = false, updatable = false)})
	  
	    private List<PlotMataKuliah> listplot= new ArrayList<PlotMataKuliah>();
	  	private List<Dosen> listDosen= new ArrayList<Dosen>();
	    private List<MataKuliah> listMatakuliah = new ArrayList<MataKuliah>();

	   
}
