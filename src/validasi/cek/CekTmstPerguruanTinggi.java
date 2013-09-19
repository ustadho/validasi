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
        if (sKolom.equalsIgnoreCase("KODE_PERGURUAN_TINGGI") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return " Kolom '" + sKolom + "' Wajib diisi! ";

        } else {
            if (value.toString().length() > 6) {
                return " Kolom '" + sKolom + "' Maksimal diisi dengan 6 karakter! ";
            } else {
                String substr = value.toString().substring(0, 2);

                if (!(substr.equalsIgnoreCase("00") || substr.equalsIgnoreCase("01")
                        || substr.equalsIgnoreCase("02") || substr.equalsIgnoreCase("03")
                        || substr.equalsIgnoreCase("04") || substr.equalsIgnoreCase("05")
                        || substr.equalsIgnoreCase("06") || substr.equalsIgnoreCase("06")
                        || substr.equalsIgnoreCase("08") || substr.equalsIgnoreCase("09")
                        || substr.equalsIgnoreCase("10") || substr.equalsIgnoreCase("11")
                        || substr.equalsIgnoreCase("12"))) {
                    return "Dua digit pertama menyatakan kode wilayah Kopertis, 01, 02 ... 12, untuk PTN dipakai “00” ";
                }
                substr = value.toString().substring(2, 3);
                if (!(substr.equalsIgnoreCase("1") || substr.equalsIgnoreCase("2") || substr.equalsIgnoreCase("3")
                        || substr.equalsIgnoreCase("4") || substr.equalsIgnoreCase("5"))) {
                    return "Digit ketiga menyatakan jenis perguruan tinggi (1-universitas, 2-institut, "
                            + "3-sekolah tinggi, 4-akademi, 5-politeknik);";
                }
            }
        }
        if (sKolom.equalsIgnoreCase("KODE_PERGURUAN_TINGGI") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return " Kolom '" + sKolom + "' Wajib diisi! ";

        }
        if (sKolom.equalsIgnoreCase("NAMA_PT") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = " Kolom '" + sKolom + "' Wajib diisi! ";
            return message;
        }
//	Singkatan CHAR(50 ) NULL ,
        if (sKolom.equalsIgnoreCase("Jenis_PT") ){
            if(value == null || value.toString().equalsIgnoreCase("")){
                return " Kolom '" + sKolom + "' Wajib diisi! ";
            }else {
                String substr = value.toString();
                if (!(substr.equalsIgnoreCase("Universitas") || substr.equalsIgnoreCase("Institut")
                        || substr.equalsIgnoreCase("Sekolah Tinggi") || substr.equalsIgnoreCase("Akademi")
                        || substr.equalsIgnoreCase("Politeknik"))) {
                    return "Jenis PT yang dapat dikelompokkan menjadi: \n" +
                            "Universitas, Institut, Sekolah Tinggi, Akademi " +
                            "dan Politeknik ";
                }
            }
        } 
        if (sKolom.equalsIgnoreCase("Kategori_PT") ){
            if(value == null || value.toString().equalsIgnoreCase("")){
                return " Kolom '" + sKolom + "' Wajib diisi! ";
            }else {
                String substr = value.toString();
                if (!(substr.equalsIgnoreCase("1")|| substr.equalsIgnoreCase("2"))) {
                    return " Kolom '" + sKolom + "' diisi dengan: \n"
                            + "Kategori perguruan tinggi yaitu negeri (1) dan swasta (2)";
                }
            }
        }
        if (sKolom.equalsIgnoreCase("Status_PT")){
            if(value == null || value.toString().equalsIgnoreCase("")){
                return " Kolom '" + sKolom + "' Wajib diisi! ";
            } else {
                String substr = value.toString();
                if (!(substr.equalsIgnoreCase("aktif")|| substr.equalsIgnoreCase("tutup"))) {
                    return " Kolom '" + sKolom + "' Wajib diisi!\n"
                            + "Status aktif/tutup perguruan tinggi ";
                }

            }
        }
        if (sKolom.equalsIgnoreCase("Tgl_awal_berdiri")) {
            message = fn.cekKolomTanggal(baris, sKolom, value);
            if (message.length() > 0) {
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("Alamat") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return " Kolom '" + sKolom + "' Wajib diisi! ";

        }
        if (sKolom.equalsIgnoreCase("Kode_kota") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return " Kolom '" + sKolom + "' Wajib diisi! ";

        }
        if (sKolom.equalsIgnoreCase("Kode_provinsi") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return " Kolom '" + sKolom + "' Wajib diisi! ";

        }
        if (sKolom.equalsIgnoreCase("Kode_negara") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return " Kolom '" + sKolom + "' Wajib diisi! ";

        }
//	Kode_pos NUMBER NULL ,
//	Telepone CHAR(20 ) NULL ,
//	Fax CHAR(20 ) NULL ,
//	Email CHAR(40 ) NULL,
//	Website CHAR(40 ) NULL,
        if (sKolom.equalsIgnoreCase("No_akta_sk_pendirian") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return " Kolom '" + sKolom + "' Wajib diisi! ";

        }
        if (sKolom.equalsIgnoreCase("Tanggal_akta")) {
            message = fn.cekKolomTanggal(baris, sKolom, value);
            if (message.length() > 0) {
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("Kode_akreditasi") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return " Kolom '" + sKolom + "' Wajib diisi! ";

        }
        if (sKolom.equalsIgnoreCase("No_SK_BAN") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return " Kolom '" + sKolom + "' Wajib diisi! ";

        }
        if (sKolom.equalsIgnoreCase("TGL_SK_BAN")) {
            message = fn.cekKolomTanggal(baris, sKolom, value);
            if (message.length() > 0) {
                return message;
            }
        }
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
        if (sKolom.equalsIgnoreCase("Kode_kementrian") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return " Kolom '" + sKolom + "' Wajib diisi! ";
        }
        if (sKolom.equalsIgnoreCase("TGL_mulai_efektif")) {
            message = fn.cekKolomTanggal(baris, sKolom, value);
            if (message.length() > 0) {
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("Tgl_Akhir_Efektif")) {
            message = fn.cekKolomTanggal(baris, sKolom, value);
            if (message.length() > 0) {
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("Status_validasi") && (value == null || value.toString().equalsIgnoreCase(""))) {
            return " Kolom '" + sKolom + "' Wajib diisi! ";
        }
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
