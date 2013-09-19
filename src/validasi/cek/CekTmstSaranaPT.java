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
public class CekTmstSaranaPT {
    private Function fn = new Function();

    public String cekKolom(int baris, String sKolom, Object value) {
        String message = "";
        if (sKolom.equalsIgnoreCase("Kode_sarana_pt") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        
        if (sKolom.equalsIgnoreCase("Tahun_pelaporan") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Semester_pelaporan") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Kode_perguruan_tinggi") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Kode_program_studi") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Kode_jenjang_pendidikan") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Nama_sarana") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Fungsi_sarana") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Kepemilikan_sarana") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Jml_sarana") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Luas_sarana") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Flag_pengguna_sarana") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Kondisi") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Status_validasi") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        
//        Penggunaan_sarana_mhs NUMBER NULL ,
//	Penggunaan_jam_sarana NUMBER NULL ,
//	Sarana_dosen NUMBER(1) NULL ,
//	Kapasitas_ruang_dosen NUMBER(1) NULL ,
//	 NUMBER(1) NULL,
//	ID_log_audit
//        TMST_SARANA_PT
                
        return message;
    }
	
}
