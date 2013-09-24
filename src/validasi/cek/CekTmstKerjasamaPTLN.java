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
public class CekTmstKerjasamaPTLN {
    private Function fn = new Function();

    public String cekKolom(int baris, String sKolom, Object value) {
        String message = "";
        if (sKolom.equalsIgnoreCase("Kode_perguruan_tinggi") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "Baris ke : " + baris + " Kolom <i>'" + sKolom + "'</i> Wajib diisi!";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Kode_perguruan_tinggi_asing") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "Baris ke : " + baris + " Kolom <i>'" + sKolom + "'</i> Wajib diisi!";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Kode_kerjasama_PTLN") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "Baris ke : " + baris + " Kolom <i>'" + sKolom + "'</i> Wajib diisi!";
            return message;
        }
        if (sKolom.equalsIgnoreCase("Uraian_bentuk_kerjasama") && (value == null || value.toString().equalsIgnoreCase(""))) {
            message = "Baris ke : " + baris + " Kolom <i>'" + sKolom + "'</i> Wajib diisi!";
            return message;
        }
        return message;
    }
	
}
