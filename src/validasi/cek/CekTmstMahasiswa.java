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
public class CekTmstMahasiswa {
    private Function fn = new Function();

    public String cekKolom(int baris, String sKolom, Object value) {
        String message = "";
        if (sKolom.equalsIgnoreCase("Kode_perguruan_tinggi") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "<li> Kolom <i>'" + sKolom + "'</i> Wajib diisi! </li>";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Kode_program_studi ") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "<li> Kolom <i>'" + sKolom + "'</i> Wajib diisi! </li>";
            return message;
        }
        if (sKolom.equalsIgnoreCase("NIM ") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "<li> Kolom <i>'" + sKolom + "'</i> Wajib diisi! </li>";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Nama_mahasiswa ") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "<li> Kolom <i>'" + sKolom + "'</i> Wajib diisi! </li>";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Kelas ") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "<li> Kolom <i>'" + sKolom + "'</i> Wajib diisi! </li>";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Kelas ")) {
            if (!value.toString().equalsIgnoreCase("R") || !value.toString().equalsIgnoreCase("N")) {
                message = "<li> Kolom <i>'" + sKolom + "'</i> diisi dengan R untuk Regular atau N untuk Non-reguler! </li>";
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("Tempat_lahir ") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "<li> Kolom <i>'" + sKolom + "'</i> Wajib diisi! </li>";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Kode_jenjang_pendidikan ") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "<li> Kolom <i>'" + sKolom + "'</i> Wajib diisi! </li>";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Tanggal_lahir")) {
            message = fn.cekKolomTanggal(baris, sKolom, value);
            if (message.length() > 0) {
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("Jenis_kelamin")) {
            if (!value.toString().equalsIgnoreCase("L") || !value.toString().equalsIgnoreCase("P")) {
                message = "<li> Kolom <i>'" + sKolom + "'</i> diisi dengan L untuk Laki-laki atau P untuk Perempuan! </li>";
                return message;
            }
        }
        //utk kode kota, propinsi, pos, negara dapat dibaca dari TREF
        //utk status mahasiswa lihat di TREF_STATUS_MAHASISWA
        if (sKolom.equalsIgnoreCase("Status_mahasiswa ") && (value == null || value.toString().equalsIgnoreCase(""))) {
            if (!value.toString().equalsIgnoreCase("A") || !value.toString().equalsIgnoreCase("C") ||
                !value.toString().equalsIgnoreCase("D") || !value.toString().equalsIgnoreCase("G") ||
                !value.toString().equalsIgnoreCase("K") || !value.toString().equalsIgnoreCase("L") ||
                !value.toString().equalsIgnoreCase("N")) {
                message = "<li> Kolom <i>'" + sKolom + "'</i> diisi dengan Aktif (A), Cuti (C), Drop-out (D), doubledeGree (G), Keluar (K), Lulus (L), atau Nonaktif (N)! </li>";
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("Tahun_masuk")) {
            message = fn.cekKolomTanggal(baris, sKolom, value);
            if (message.length() > 0) {
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("Mulai_semester")){
            if(value == null || value.toString().equalsIgnoreCase("")){
                message = "<li> Kolom <i>'" + sKolom + "'</i> Wajib diisi! </li>";
                return message;
            }else if(value.toString().trim().length()<5){
                message = "<li> Kolom <i>'" + sKolom + "'</i> Diisi dengan 5 Karakter YYYYS (Tahun-Semester)</li>";
                return message;
            }else if(!(value.toString().substring(4, 5).equalsIgnoreCase("1") || value.toString().substring(4, 5).equalsIgnoreCase("2"))){
                message = "<li> Kolom <i>'" + sKolom + "'</i> karaker ke-5 harus diisi dengan angka 1 atau 2</li>";
                return message;
            }
            
        }
        if (sKolom.equalsIgnoreCase("Batas_studi")){
            if(value == null || value.toString().equalsIgnoreCase("")){
                message = "<li> Kolom <i>'" + sKolom + "'</i> Wajib diisi! </li>";
                return message;
            }else if(value.toString().trim().length()<5){
                message = "<li> Kolom <i>'" + sKolom + "'</i> Diisi dengan 5 Karakter YYYYS (Tahun-Semester)</li>";
                return message;
            }else if(!(value.toString().substring(4, 5).equalsIgnoreCase("1") || value.toString().substring(4, 5).equalsIgnoreCase("2"))){
                message = "<li> Kolom <i>'" + sKolom + "'</i> karaker ke-5 harus diisi dengan angka 1 atau 2</li>";
                return message;
            }
            
        }
        if (sKolom.equalsIgnoreCase("Tanggal_masuk")) {
            message = fn.cekKolomTanggal(baris, sKolom, value);
            if (message.length() > 0) {
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("Tanggal_lulus")) {
            message = fn.cekKolomTanggal(baris, sKolom, value);
            if (message.length() > 0) {
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("IPK_akhir") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "<li> Kolom <i>'" + sKolom + "'</i> Wajib diisi! </li>";
            return message;
        }
        if (sKolom.equalsIgnoreCase("IPK_akhir")) {
            double ipkAkhir = Double.parseDouble(value.toString());
            if (ipkAkhir<0 || ipkAkhir>4) {
                message = "<li> Kolom <i>'" + sKolom + "'</i> diisi antara 0 hingga 4.00! </li>";
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("Nomor_SK_yudisium") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "<li> Kolom <i>'" + sKolom + "'</i> Wajib diisi! </li>";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Tanggal_SK_yudisium")) {
            message = fn.cekKolomTanggal(baris, sKolom, value);
            if (message.length() > 0) {
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("Nomor_seri_ijazah") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "<li> Kolom <i>'" + sKolom + "'</i> Wajib diisi! </li>";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Status_awal_mahasiswa") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "<li> Kolom <i>'" + sKolom + "'</i> Wajib diisi! </li>";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Status_awal_mahasiswa ")) {
            if (!value.toString().equalsIgnoreCase("B") || !value.toString().equalsIgnoreCase("P")) {
                message = "<li> Kolom <i>'" + sKolom + "'</i> diisi dengan Baru (B), atau Pindahan (P)! </li>";
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("SKS_diakui") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "<li> Kolom <i>'" + sKolom + "'</i> Wajib diisi! </li>";
            return message;
        }
        if (sKolom.equalsIgnoreCase("SKS_diakui")) {
            int iSksDiakui = Integer.parseInt(value.toString());
            if (iSksDiakui<0) {
                message = "<li> Kolom <i>'" + sKolom + "'</i> diisi dengan nilai yang benar! </li>";
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("Kode_perguruan_tinggi_asal") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "<li> Kolom <i>'" + sKolom + "'</i> Wajib diisi! </li>";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Kode_program_studi_asal") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "<li> Kolom <i>'" + sKolom + "'</i> Wajib diisi! </li>";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Kode_biaya_studi") && (value == null || value.toString().equalsIgnoreCase(""))) {
            if (!value.toString().equalsIgnoreCase("A") || !value.toString().equalsIgnoreCase("B") ||
                !value.toString().equalsIgnoreCase("C") || !value.toString().equalsIgnoreCase("D") ||
                !value.toString().equalsIgnoreCase("E") || !value.toString().equalsIgnoreCase("F") ||
                !value.toString().equalsIgnoreCase("G") || !value.toString().equalsIgnoreCase("H")) {
                message = "<li> Kolom <i>'" + sKolom + "'</i> diisi dengan Biaya APBN (A), Biaya APBD (B), Biaya PTN/BHMN (C), Biaya PTS (D), Institusi Luar Negeri (E), Institusi Dalam Negeri (F), Biaya Tempat Bekerja (G), atau Biaya Sendiri (H)! </li>";
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("Bulan_awal_bimbingan")&& !(value == null || value.toString().equalsIgnoreCase(""))) {
            message = fn.cekKolomTanggal(baris, sKolom, value);
            if (message.length() > 0) {
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("Bulan_akhir_bimbingan")&& !(value == null || value.toString().equalsIgnoreCase(""))) {
            message = fn.cekKolomTanggal(baris, sKolom, value);
            if (message.length() > 0) {
                return message;
            }
        }
        return message;
    }
	
}
