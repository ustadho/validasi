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
public class CekTmstDosen {
    private Function fn = new Function();

    public String cekKolom(int baris, String sKolom, Object value) {
        String message = "";
        if (sKolom.equalsIgnoreCase("NIDN_NUP") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = " Kolom '" + sKolom + "' Wajib diisi! ";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Jabatan_fungsional ") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = " Kolom '" + sKolom + "' Wajib diisi! ";
            return message;
        }
        //Untuk dosen yang instansi induknya bukan dari perguruan tinggi mengisi "888888"
        if (sKolom.equalsIgnoreCase("Kode_perguruan_tinggi ") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = " Kolom '" + sKolom + "' Wajib diisi! ";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Kode_fakultas ") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = " Kolom '" + sKolom + "' Wajib diisi! ";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Kode_jurusan ") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = " Kolom '" + sKolom + "' Wajib diisi! ";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Nama_dosen ") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = " Kolom '" + sKolom + "' Wajib diisi! ";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Nomor_KTP ") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = " Kolom '" + sKolom + "' Wajib diisi! ";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Gelar_akademik_depan ") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = " Kolom '" + sKolom + "' Wajib diisi! ";
            return message;
        }
        //Gelar_akademik_belakang
        //Gelar_akademik_belakang
        if (sKolom.equalsIgnoreCase("Jenis_kelamin ") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = " Kolom '" + sKolom + "' Wajib diisi! ";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Tempat_lahir ") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = " Kolom '" + sKolom + "' Wajib diisi! ";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Tanggal_lahir")) {
            message = fn.cekKolomTanggal(baris, sKolom, value);
            if (message.length() > 0) {
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("Status_aktif ") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = " Kolom '" + sKolom + "' Wajib diisi! ";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Mulai_masuk_dosen")) {
            message = fn.cekKolomTanggal(baris, sKolom, value);
            if (message.length() > 0) {
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("Mulai_semester")){
            if(value == null || value.toString().equalsIgnoreCase("")){
                message = " Kolom '" + sKolom + "' Wajib diisi! ";
                return message;
            }else if(value.toString().trim().length()<5){
                message = " Kolom '" + sKolom + "' Diisi dengan 5 Karakter YYYYS (Tahun-Semester)";
                return message;
            }else if(!(value.toString().substring(4, 5).equalsIgnoreCase("1") || value.toString().substring(4, 5).equalsIgnoreCase("2"))){
                message = " Kolom '" + sKolom + "' karaker ke-5 harus diisi dengan angka 1 atau 2";
                return message;
            }
            
        }
        if (sKolom.equalsIgnoreCase("Kode_jenjang_pendidikan") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = " Kolom '" + sKolom + "' Wajib diisi! ";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Ikatan_kerja")){
            if(value ==null ||value.toString().length()==0){
                message = " Kolom '" + sKolom + "' Wajib diisi! ";
                return message;
            }
            else if(!(value.toString().equalsIgnoreCase("A") || value.toString().equalsIgnoreCase("B") ||
                    value.toString().equalsIgnoreCase("C") || value.toString().equalsIgnoreCase("D") ||
                    value.toString().equalsIgnoreCase("E") || value.toString().equalsIgnoreCase("F") )){
                message = " Kolom '" + sKolom + "' Harus diisi dengan huruf 'A', 'B', 'C', 'D', 'E', 'F' saja";
                return message;
            }
            
        }
        if (sKolom.equalsIgnoreCase("Akta_dan_ijin_mengajar")){
            if(value ==null ||value.toString().length()==0){
                message = " Kolom '" + sKolom + "' Wajib diisi! ";
                return message;
            }
            else if(!(value.toString().equalsIgnoreCase("Y") || value.toString().equalsIgnoreCase("T")
                    )){
                message = " Kolom '" + sKolom + "' Harus diisi dengan huruf 'Y' atau 'T' saja";
                return message;
            }
            
        }
//	Alamat CHAR(100 ) NULL ,
//	Kode_kota NUMBER NULL ,
//	Kode_provinsi CHAR(3 ) NULL ,
//	Kode_pos NUMBER(5) NULL ,
//	Kode_negara CHAR(3 ) NULL,
        if (sKolom.equalsIgnoreCase("No_sertifikasi_dosen") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = " Kolom '" + sKolom + "' Wajib diisi! ";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Tgl_keluar_sertifikasi_dosen")) {
            message = fn.cekKolomTanggal(baris, sKolom, value);
            if (message.length() > 0) {
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("NIRA") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = " Kolom '" + sKolom + "' Wajib diisi! ";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Status_validasi")){
            if(value ==null ||value.toString().length()==0){
                message = " Kolom '" + sKolom + "' Wajib diisi! ";
                return message;
            }
            else if(!(value.toString().equalsIgnoreCase("1") || value.toString().equalsIgnoreCase("2") || value.toString().equalsIgnoreCase("3")
                    )){
                message = " Kolom '" + sKolom + "' Harus diisi dengan angka 1, 2 atau 3 saja";
                return message;
            }
            
        }
//	Telepon CHAR(20 ) NULL ,
//	HP CHAR(20 ) NULL ,
//	ID_log_audit
        return message;
    }
	
}
