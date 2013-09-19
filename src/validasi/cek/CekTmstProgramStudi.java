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
public class CekTmstProgramStudi {

    private Function fn = new Function();

    public String cekKolom(int baris, String sKolom, Object value) {
        String message = "";
        if (sKolom.equalsIgnoreCase("Kode_program_studi") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Kode_perguruan_tinggi") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
//	Kode_fakultas CHAR(2 ) NULL ,
//	Kode_jurusan CHAR(5 ) NULL ,
        if (sKolom.equalsIgnoreCase("Nama_program_studi") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Kode_jenjang_pendidikan") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Alamat") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Kode_provinsi") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Kode_negara") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
//	kode_pos NUMBER(5) NULL ,
        if (sKolom.equalsIgnoreCase("Tanggal_berdiri")) {
            message = fn.cekKolomTanggal(baris, sKolom, value);
            if (message.length() > 0) {
                return message;
            }
        }
//	Email CHAR(40 ) NULL ,
        if (sKolom.equalsIgnoreCase("Bidang_ilmu") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("SKS_lulus") && fn.udfGetInt(value)==0) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Status_program_studi")){
            if(value == null || value.toString().equalsIgnoreCase("")){
                return " Kolom '" + sKolom + "' Wajib diisi! ";
            }else {
                String substr = value.toString();
                if (!(substr.equalsIgnoreCase("A") || substr.equalsIgnoreCase("H"))) {
                    return "Kode Status Program Studi yang diisi dengan status aktif (A) atau status hapus (H)";
                }
            }
        }
        if (sKolom.equalsIgnoreCase("No_SK_DIKTI") && fn.udfGetInt(value)==0) {
            return "Baris ke : " + baris + " Kolom '" + sKolom + "' Wajib diisi!";
        }
        if (sKolom.equalsIgnoreCase("Tgl_SK_DIKTI")) {
            message = fn.cekKolomTanggal(baris, sKolom, value);
            if (message.length() > 0) {
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("Tgl_akhir_SK_DIKTI")) {
            message = fn.cekKolomTanggal(baris, sKolom, value);
            if (message.length() > 0) {
                return message;
            }
        }
//        ,Mulai_semester CHAR(5 ) NULL ,
//	NIDN_NUP CHAR(40 ) NULL ,
//	NIK CHAR(20 ) NULL ,
//	HP CHAR(20 ) NULL ,
//	Telepon_kantor CHAR(20 ) NULL ,
//	Fax CHAR(20 ) NULL ,
//	Nama_operator CHAR(40 ) NULL,
//	Frekuensi_kurikulum CHAR(1 ) NULL,
//	Pelaksanaan_kurikulum CHAR(1 ) NULL,
//	Kode_akreditasi NUMBER NULL,
//	No_SK_BAN CHAR(50 ) NULL 
//        ,Tanggal_SK_BAN DATE NULL ,
//	Tanggil_akhir_SK_BAN DATE NULL ,
//	kapasitas_mahasiswa NUMBER NULL ,
//	Visi CLOB NULL ,
//	Misi CLOB NULL ,
//	Tujuan CLOB NULL ,
//	Sasaran CLOB NULL ,
//	Upaya_penyebaran CLOB NULL ,
//	Keberlanjutan CLOB NULL ,
//	Himpunan_alumni CLOB NULL ,
//	Tgl_mulai_efektif DATE NULL 
//        ,Tgl_akhir_efektif DATE NULL ,
//	Status_validasi NUMBER(1) NULL ,
//	ID_log_audit NUMBER NULL,
//	UUID INT,
//	Nama_Ketua TEXT
//        ,Nama_Sekertaris TEXT,
//	Rumpun_ilmu TEXT,
//	Gelar_Lulusan TEXT,
//	Deskripsi_Singkat TEXT,
//	Kompetensi_Prodi TEXT,
//	Capaian_Pembelajaran TEXT,
//	Website TEXT,
//        User TEXT,
//	Created_At TEXT,
//	Updated_at TEXT
        return message;
    }

}
