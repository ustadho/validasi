/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validasi.utilisasi;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author faheem
 */
public class Function {

    public boolean validateDate(String dateStr, boolean allowPast, String formatStr) {
        if (formatStr == null) {
            return false; // or throw some kinda exception, possibly a InvalidArgumentException
        }
        SimpleDateFormat df = new SimpleDateFormat(formatStr);
        Date testDate = null;
        try {
            testDate = df.parse(dateStr);
        } catch (java.text.ParseException e) {
            // invalid date format
            return false;
        }
        if (!allowPast) {
            // initialise the calendar to midnight to prevent
            // the current day from being rejected
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            if (cal.getTime().after(testDate)) {
                return false;
            }
        }
        // now test for legal values of parameters
        if (!df.format(testDate).equals(dateStr)) {
            return false;
        }
        return true;
    }

    public String cekKolomTanggal(int baris, String sKolom, Object value) {
        String message="";
        if (value == null) {
            message = "Baris ke : " + baris + " Kolom " + sKolom + " Wajib diisi!";
            return message;
        }
        if (validateDate(value.toString(), false, "yyyy-MM-dd")) {
            message = "Baris ke : " + baris + " Kolom " + sKolom + " ('" + value.toString() + "') Format data tidak valid!";
            return message;
        }
        return message;
    }
}
