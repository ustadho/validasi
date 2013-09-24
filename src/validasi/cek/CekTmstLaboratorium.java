/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validasi.cek;

import java.util.Calendar;
import validasi.utilisasi.Function;

/**
 *
 * @author faheem
 */
public class CekTmstLaboratorium {
    private Function fn = new Function();

    public String cekKolom(int baris, String sKolom, Object value) {
        String message = "";
        if (sKolom.equalsIgnoreCase("Kode_lab") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "Baris ke : " + baris + " Kolom <i>'" + sKolom + "'</i> Wajib diisi!";
            return message;
        }
        if (sKolom.equalsIgnoreCase("No_urut_lab") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "Baris ke : " + baris + " Kolom <i>'" + sKolom + "'</i> Wajib diisi!";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Nama_lab") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "Baris ke : " + baris + " Kolom <i>'" + sKolom + "'</i> Wajib diisi!";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Kode_perguruan_tinggi") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "Baris ke : " + baris + " Kolom <i>'" + sKolom + "'</i> Wajib diisi!";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Kode_jenjang_pendidikan") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "Baris ke : " + baris + " Kolom <i>'" + sKolom + "'</i> Wajib diisi!";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Kode_program_studi") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "Baris ke : " + baris + " Kolom <i>'" + sKolom + "'</i> Wajib diisi!";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Tahun_pelaporan") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "Baris ke : " + baris + " Kolom <i>'" + sKolom + "'</i> Wajib diisi!";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Tahun_pelaporan")) {
            int iTahunLapor = Integer.parseInt(value.toString());
            int iTahunIni = Calendar.getInstance().get(Calendar.YEAR);
            if (iTahunLapor > iTahunIni) {
                message = "Baris ke : " + baris + " Kolom <i>'" + sKolom + "'</i> Diisi dengan tahun sebelum tahun ini!";
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("Semester_pelaporan") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "Baris ke : " + baris + " Kolom <i>'" + sKolom + "'</i> Wajib diisi!";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Semester_pelaporan")) {
            int iSemesterLapor = Integer.parseInt(value.toString());
            if (iSemesterLapor!=1 || iSemesterLapor!=2) {
                message = "Baris ke : " + baris + " Kolom <i>'" + sKolom + "'</i> Diisi dengan 1 untuk ganjil dan 2 untuk genap!";
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("Kepemilikan_lab") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "Baris ke : " + baris + " Kolom <i>'" + sKolom + "'</i> Wajib diisi!";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Lokasi_lab") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "Baris ke : " + baris + " Kolom <i>'" + sKolom + "'</i> Wajib diisi!";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Luas_lab")) {
            int iLuas = Integer.parseInt(value.toString());
            if (iLuas<10) {
                message = "Baris ke : " + baris + " Kolom <i>'" + sKolom + "'</i> diisi dengan luasan yang benar!";
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("Kapasitas_praktikum_satu_shift")) {
            int iKapasitas = Integer.parseInt(value.toString());
            if (iKapasitas < 0) {
                message = "Baris ke : " + baris + " Kolom <i>'" + sKolom + "'</i> diisi dengan kapasitas yang benar!";
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("Lab_penggunaan_mhs")) {
            int iLabMhs = Integer.parseInt(value.toString());
            if (iLabMhs<0) { //rule bisa diubah jika sudah didapatkan kriteria rasio mhs dan lab yang benar
                message = "Baris ke : " + baris + " Kolom <i>'" + sKolom + "'</i> diisi dengan rasio mahasiswa dan luasan lab yang benar!";
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("Lab_penggunaan_jam")) {
            int iLabJam = Integer.parseInt(value.toString());
            if (iLabJam<0 || iLabJam>24) {
                message = "Baris ke : " + baris + " Kolom <i>'" + sKolom + "'</i> diisi dengan jam yang benar!";
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("Jumlah_PS_pengguna")) {
            int iJmlPS = Integer.parseInt(value.toString());
            if (iJmlPS<0) {
                message = "Baris ke : " + baris + " Kolom <i>'" + sKolom + "'</i> diisi dengan jumlah Program Studi yang benar!";
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("Jumlah_modul_praktikum_sendiri")) {
            int iJmlModul = Integer.parseInt(value.toString());
            if (iJmlModul<0) {
                message = "Baris ke : " + baris + " Kolom <i>'" + sKolom + "'</i> diisi dengan jumlah Modul yang benar!";
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("Jumlah_modul_praktikum_lain")) {
            int iJmlModul = Integer.parseInt(value.toString());
            if (iJmlModul<0) {
                message = "Baris ke : " + baris + " Kolom <i>'" + sKolom + "'</i> diisi dengan jumlah Modul Lain yang benar!";
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("Status_validasi")){
            if(value ==null ||value.toString().length()==0){
                message = "Baris ke : " + baris + " Kolom <i>'" + sKolom + "'</i> Wajib diisi!";
                return message;
            }
            else if(!(value.toString().equalsIgnoreCase("1") || value.toString().equalsIgnoreCase("2") ||
                    value.toString().equalsIgnoreCase("3") || value.toString().equalsIgnoreCase("4") )){
                message = "Baris ke : " + baris + " Kolom <i>'" + sKolom + "'</i> Harus diisi dengan angka 1, 2, 3, 4 saja";
                return message;
            }            
        }
        return message;
    }
	
}
