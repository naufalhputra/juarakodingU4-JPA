package com.jpa.relation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.relation.entity.Admin;
import com.jpa.relation.entity.Dosen;
import com.jpa.relation.entity.Mahasiswa;
import com.jpa.relation.entity.MataKuliah;
import com.jpa.relation.entity.Nilai;
import com.jpa.relation.entity.Pertanyaan;
import com.jpa.relation.entity.PlotMataKuliah;
import com.jpa.relation.entity.Soal;
import com.jpa.relation.resepository.AdminRes;
import com.jpa.relation.resepository.MahasiswaRes;
import com.jpa.relation.resepository.PertanyaanRes;
import com.jpa.relation.resepository.SoalRes;

@SpringBootApplication
public class JpaApkNilaiUniversitasApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(JpaApkNilaiUniversitasApplication.class, args);
	}


	@Autowired
	AdminRes adminres;
	
	@Autowired
	MahasiswaRes mahasiswares;
	
	@Autowired
	SoalRes soalres;
	
	@Autowired
	PertanyaanRes pertanyaanres;
	
    public void run(String...  args) throws Exception {
    	
	    Admin admin = new Admin();
        admin.setUsername("naufalhputra");
        admin.setPassword("naufal123");


        this.adminres.save(admin);
    	
    	PlotMataKuliah plot1 = new PlotMataKuliah();
    	plot1.setId_plot_matakuliah(11);

		Mahasiswa student1 = new Mahasiswa();
		student1.setPassword("Dayat123");
		student1.setJeniskelamin("pria");
		student1.setNama_mahasiswa("Mamang Dayat");

		MataKuliah matkul1 = new MataKuliah();
		matkul1.setNama_matakuliah("matif1");
		
		Dosen dosen1 = new Dosen();
		dosen1.setUsername("banbang");
		dosen1.setPassword("banbang123");
		dosen1.setNama_dosen("Bambang darmawan");
		
		
		List<PlotMataKuliah>listplot1 = new ArrayList<PlotMataKuliah>();
		listplot1.add(plot1);
	
		List<MataKuliah> listmat1 = new ArrayList<MataKuliah>();
		listmat1.add(matkul1);
		
		List<Dosen> listdos1 = new ArrayList<Dosen>();
		listdos1.add(dosen1);
		
		student1.setListplot(listplot1);
		student1.setListDosen(listdos1);
		student1.setListMatakuliah(listmat1);
		
		this.mahasiswares.save(student1);
		
		Soal soal= new Soal();
    	soal.setNama_soal("Matif1");
    	soal.setStatus("PG");
    	
    	Pertanyaan pertanyaan1 = new Pertanyaan();
    	pertanyaan1.setPertanyaan("Apakah di bawah ini yang berjenis mamalia");
    	pertanyaan1.setJawaban1("Kucing");
    	pertanyaan1.setJawaban2("Ayam");
    	pertanyaan1.setJawaban3("Bebek");
    	pertanyaan1.setJawaban4("Ikan");
    	pertanyaan1.setJawaban_benar(1);
    	pertanyaan1.getGambar();
    	pertanyaan1.setStatus_gambar(1);

    	
    	Pertanyaan pertanyaan2 = new Pertanyaan();
    	pertanyaan2.setPertanyaan("Apakah di bawah ini yang berjenis hewan laut");
    	pertanyaan2.setJawaban1("Kucing");
    	pertanyaan2.setJawaban2("Ayam");
    	pertanyaan2.setJawaban3("Bebek");
    	pertanyaan2.setJawaban4("Ikan");
    	pertanyaan2.setJawaban_benar(4);
    	pertanyaan2.getGambar();
    	pertanyaan2.setStatus_gambar(1);

    	
    	List<Pertanyaan> lsttanya = new ArrayList<Pertanyaan>();
    	lsttanya.add(pertanyaan1);
    	lsttanya.add(pertanyaan2);
    	
    	soal.setLastpertanyaan(lsttanya);
    	this.soalres.save(soal);
    	
	  

        Nilai nilai = new Nilai();
        nilai.setNilai("A");

        pertanyaan1.setNilai(nilai);
        pertanyaan2.setNilai(nilai);

        this.pertanyaanres.saveAll(lsttanya);
		
		
		
	
		
    }
}
