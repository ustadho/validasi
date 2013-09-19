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
public class CekTmstPustakaPT {
    private Function fn = new Function();

    public String cekKolom(int baris, String sKolom, Object value) {
        String message = "";
        if (sKolom.equalsIgnoreCase("Kode_pustaka_pt") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Tahun_pelaporan") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Semester_pelapporan") && (value == null || value.toString().equalsIgnoreCase(""))) {
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
        if (sKolom.equalsIgnoreCase("Jml_judul_pustaka") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Jml_judul_pustaka_digunakan") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Jenis_pustaka") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Nama_pustaka") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Tahun_terbit_pustaka") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Fungsi_pustaka") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        return message;
    }
//	ID_log_audit NUMBER NULL
}
