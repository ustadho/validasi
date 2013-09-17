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
        return message;
    }
}
