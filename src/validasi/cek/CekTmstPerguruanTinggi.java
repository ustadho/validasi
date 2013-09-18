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
public class CekTmstPerguruanTinggi {
    private Function fn = new Function();

    public String cekKolom(int baris, String sKolom, Object value) {
        String message = "";
        if (sKolom.equalsIgnoreCase("NIDN_NUP") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = " Kolom '" + sKolom + "' Wajib diisi! ";
            return message;
        }
        //Kurang validasi
        if (sKolom.equalsIgnoreCase("KODE_PERGURUAN_TINGGI") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return " Kolom '" + sKolom + "' Wajib diisi! ";
            
        }else{
            if(value.toString().length() >6){
                return " Kolom '" + sKolom + "' Maksimal diisi dengan 6 karakter! ";
            }else{
                
            }
        }
        if (sKolom.equalsIgnoreCase("NAMA_PT") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = " Kolom '" + sKolom + "' Wajib diisi! ";
            return message;
        }
//	Singkatan CHAR(50 ) NULL ,
//	Jenis_PT CHAR(1 ) NULL ,
//	Kategori_PT NUMBER(1) NULL ,
//	Status_PT CHAR(1 ) NULL
//        ,Tgl_awal_berdiri DATE NULL ,
//	Alamat CHAR(100 ) NULL ,
//	Kode_kota NUMBER NULL ,
//	Kode_provinsi NUMBER NULL ,
//	Kode_negara NUMBER NULL ,
//	Kode_pos NUMBER NULL ,
//	Telepone CHAR(20 ) NULL ,
//	Fax CHAR(20 ) NULL ,
//	Email CHAR(40 ) NULL,
//	Website CHAR(40 ) NULL,
//	No_akta_sk_pendirian CHAR(30 ) NULL
//        ,Tanggal_akta DATE NULL ,
//	Kode_akreditasi NUMBER NULL ,
//	No_SK_BAN CHAR(50 ) NULL ,
//	TGL_SK_BAN DATE NULL ,
//	visi CLOB NULL ,
//	misi CLOB NULL ,
//	Tujuan CLOB NULL ,
//	Sasaran CLOB NULL ,
//	Kode_kopertis NUMBER NULL ,
//	Kode_wilayah NUMBER NULL ,
//	Seleksi_penerimaan CLOB NULL 
//        ,Pola_kepemimpinan CLOB NULL ,
//	Sistem_pengelolaan CLOB NULL ,
//	Sistem_penjaminan_mutu CLOB NULL ,
//	Alasan_transfer_mahasiswa CLOB NULL ,
//	Peran_d_pembelajaran CLOB NULL ,
//	Peran_d_penyusunan_kurikulum CLOB NULL ,
//	Peran_d_suasana_akademik CLOB NULL ,
//	pemanfaatan_TIK CLOB NULL ,
//	Penyebaran_informasi CLOB NULL,
//	Rencana_pengembangan_SI CLOB NULL 
//        ,Evaluasi_lulusan CLOB NULL ,
//	Mekanisme_evaluasi_lulusan CLOB NULL ,
//	Kode_kementrian NUMBER NULL ,
//	TGL_mulai_efektif DATE NULL ,
//	Tgl_Akhir_Efektif DATE NULL ,
//	Status_validasi NUMBER(1) NULL ,
//	Id_log_audit NUMBER NULL
//        ,File_Logo TEXT,
//	Nama_Rektor TEXT,
//	Nip_Rektor TEXT,
//	Nama_Wakil_1 TEXT,
//	Nip_Wakil_1 TEXT,
//	Nama_Wakil_2 TEXT,
//	Nip_Wakil_2 TEXT,
//	Nama_Wakil_3 TEXT,
//	Nip_Wakil_3 TEXT,
//        Nama_Wakil_4 TEXT,
//	Nip_Wakil_4 TEXT,
//	Nama_Sekertaris TEXT,
//	Deskripsi_Singkat Text,
//	User Text,
//	Created_At Text,
//	Uploaded_At TEXT
        return message;
    }
}
