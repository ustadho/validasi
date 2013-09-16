/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validasi.cek;

import validasi.utilisasi.Function;

/**
 *
 * @author faheem
 */
public class CekTmstMataKuliah {
    private Function fn = new Function();

    public String cekKolom(int baris, String sKolom, Object value) {
        String message = "";
        if (sKolom.equalsIgnoreCase("Kode_mata_kuliah") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Tahun_pelaporan") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Semester_pelaporan") && (value == null || value.toString().equalsIgnoreCase(""))) {
            if(value ==null ||value.toString().length()==0){
                message = " Kolom '" + sKolom + "' Wajib diisi! ";
                return message;
            }
            else if(!(value.toString().equalsIgnoreCase("1") || value.toString().equalsIgnoreCase("2"))){
                message = " Kolom '" + sKolom + "' Harus diisi dengan angka 1 atau 2 saja";
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("Kode_perguruan_tinggi") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Kode_program_studi") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Kode_jenjang_pendidikan") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
            return message;
        }
        
//	Nama_mata_kuliah CHAR(40 ) NULL
//        ,Jenis_mata_kuliah CHAR(1 ) NULL ,
//	Semester NUMBER(1) NULL ,
//	Kelompok_mata_kuliah CHAR(1 ) NULL ,
//	SKS_mata_kuliah NUMBER(1) NULL ,
//	SKS_tatap_muka NUMBER(1) NULL ,
//	SKS_praktikum NUMBER(1) NULL ,
//	SKS_praktek_lapangan NUMBER(1) NULL ,
//	SKS_simulasi NUMBER(1) NULL 
//        ,Metode_pelaksanaan_kuliah CHAR(50 ) NULL ,
//	Status_mata_kuliah CHAR(50 ) NULL ,
//	Kode_kurikulum CHAR(1 ) NULL ,
//	Kode_kelas CHAR(2 ) NULL ,
        if (sKolom.equalsIgnoreCase("SAP") && !(value == null || value.toString().equalsIgnoreCase(""))) {
            if(!(value.toString().equalsIgnoreCase("1") || value.toString().equalsIgnoreCase("0"))){
                message = " Kolom '" + sKolom + "' Harus diisi dengan angka 1 atau 2 saja";
                return message;
            }
        }
//	Silabus CHAR(1 ) NULL ,
//	Bahan_ajar CHAR(1 ) NULL,
//	Acara_praktek NUMBER(1) NULL,
//	Diktat CHAR(1 ) NULL
        if (sKolom.equalsIgnoreCase("NIDN") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
            return message;
        }
        if (sKolom.equalsIgnoreCase("TGL_mulai_efektif")) {
            message = fn.cekKolomTanggal(baris, sKolom, value);
            if (message.length() > 0) {
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("Tgl_akhir_efektif")) {
            message = fn.cekKolomTanggal(baris, sKolom, value);
            if (message.length() > 0) {
                return message;
            }
        }
        return message;
    }
	
}
