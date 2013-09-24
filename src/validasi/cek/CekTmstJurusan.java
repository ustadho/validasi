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
public class CekTmstJurusan {
    private Function fn = new Function();

    public String cekKolom(int baris, String sKolom, Object value) {
        String message = "";
        if (sKolom.equalsIgnoreCase("Kode_jurusan") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "Baris ke : " + baris + " Kolom <i>'" + sKolom + "'</i> Wajib diisi!";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Nama_jurusan") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "Baris ke : " + baris + " Kolom <i>'" + sKolom + "'</i> Wajib diisi!";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Kode_fakultas") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "Baris ke : " + baris + " Kolom <i>'" + sKolom + "'</i> Wajib diisi!";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Kode_perguruan_tinggi") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "Baris ke : " + baris + " Kolom <i>'" + sKolom + "'</i> Wajib diisi!";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Program_studi_yg_diasuh") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "Baris ke : " + baris + " Kolom <i>'" + sKolom + "'</i> Wajib diisi!";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Tgl_awal_berdiri") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = fn.cekKolomTanggal(baris, sKolom, value);
            if (message.length() > 0) {
                return message;
            }
        }
        if (sKolom.equalsIgnoreCase("No_SK_penyelenggara") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "Baris ke : " + baris + " Kolom <i>'" + sKolom + "'</i> Wajib diisi!";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Tgl_SK_penyelenggara") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = fn.cekKolomTanggal(baris, sKolom, value);
            if (message.length() > 0) {
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
