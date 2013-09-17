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
public class CekTmstPegawai {

    private Function fn = new Function();

    public String cekKolom(int baris, String sKolom, Object value) {
        String message = "";
        if (sKolom.equalsIgnoreCase("Kode_pegawai") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("NIP_lama") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("NIP_baru") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Nama_pegawai") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Jenis_kelamin") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Tempat_lahir") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Tanggal_lahir")) {
            message = fn.cekKolomTanggal(baris, sKolom, value);
            if (message.length() > 0) {
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("Alamat") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Kode_kota") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Kode_provinsi") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Kode_pos") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        //Kode_jabatan_fungsional NUMBER NULL ,
        if (sKolom.equalsIgnoreCase("Kode_direktorat_jendral") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Kode_direktorat") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Kode_bagian") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Kode_seksi") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Pangkat") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Golongan") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Telepon_rumah") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        //Email CHAR(20 ) NULL ,
        if (sKolom.equalsIgnoreCase("Handphone") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("No_SK_pengangkatan") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Tanggal_masuk")) {
            message = fn.cekKolomTanggal(baris, sKolom, value);
            if (message.length() > 0) {
                return message;
            }
        }
        //Tanggal_berhenti DATE NULL,
        if (sKolom.equalsIgnoreCase("Status") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Kode_jenjang_pendidikan") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        return message;
    }

//            TEXT_TMT TEXT ,
//            Text_Tgl_Masuk TEXT ,
//            Text_Tgl_Berhenti TEXT ,
//            Gelar_Depan TEXT ,
//            Gelar_Belakang TEXT
}
