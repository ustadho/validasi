/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validasi.utilisasi;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author faheem
 */
public class Function {
    public static NumberFormat dFmt=new DecimalFormat("#,##0.00");
    public static NumberFormat intFmt=new DecimalFormat("#,##0");
    public static NumberFormat fFmt=new DecimalFormat("#,##0.00");
    
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
    
    public static double udfGetDouble(String sNum){
        double hsl=0;
        if(!sNum.trim().equalsIgnoreCase("")){
            try{
                hsl=dFmt.parse(sNum).doubleValue();
                //hsl=Double.parseDouble(sNum);
            } catch (java.text.ParseException ex) {
                hsl=0;
                //Logger.getLogger(FrmTrxPinjam.class.getName()).log(Level.SEVERE, null, ex);
            }catch(NumberFormatException ne){
                hsl=0;
            }catch(IllegalArgumentException i){
                hsl=0;
            }
        }
        return hsl;
  }
    public static double udfGetDouble(Object sNum){
        double hsl=0;
        if(sNum!=null && !sNum.toString().trim().equalsIgnoreCase("")){
            try{
                hsl=dFmt.parse(dFmt.format(sNum)).doubleValue();
            } catch (java.text.ParseException ex) {
                hsl=0;
            }catch(NumberFormatException ne){
                hsl=0;
            }catch(IllegalArgumentException i){
                hsl=0;
            }
        }
        return hsl;
  }


    public static float udfGetFloat(String sNum){
        float hsl=0;
        if(!sNum.trim().equalsIgnoreCase("")){
            try{
                hsl=fFmt.parse(sNum).floatValue();
            } catch (java.text.ParseException ex) {
                hsl=0;
            }catch(NumberFormatException ne){
                hsl=0;
            }catch(IllegalArgumentException i){
                hsl=0;
            }
        }
        return hsl;
  }

    public static float udfGetFloat(Object sNum){
        float hsl=0;
        if(sNum!=null && !sNum.toString().trim().equalsIgnoreCase("")){
            try{
                hsl=fFmt.parse(fFmt.format(sNum)).floatValue();
            } catch (java.text.ParseException ex) {
                hsl=0;
            }catch(NumberFormatException ne){
                hsl=0;
            }catch(IllegalArgumentException i){
                hsl=0;
            }
        }
        return hsl;
  }

    public static int udfGetInt(String sNum){
        int hsl=0;
        if(!sNum.trim().equalsIgnoreCase("")){
            try{
                //hsl=Integer.valueOf(sNum);
                hsl=intFmt.parse(sNum).intValue();

            } catch (java.text.ParseException ex) {
                hsl=0;
                //Logger.getLogger(FrmTrxPinjam.class.getName()).log(Level.SEVERE, null, ex);
            }catch(NumberFormatException ne){
                hsl=0;
            }catch(IllegalArgumentException i){
                hsl=0;
            }
        }
        return hsl;
  }

    public static int udfGetInt(Object sNum){
        int hsl=0;
        if(sNum!=null && !sNum.toString().trim().equalsIgnoreCase("")){
            try{
                if(sNum instanceof String)
                    hsl=Integer.parseInt(sNum.toString());
                else
                    hsl=intFmt.parse(intFmt.format(sNum)).intValue();
            } catch (java.text.ParseException ex) {
                hsl=0;
            }catch(NumberFormatException ne){
                hsl=0;
            }catch(IllegalArgumentException i){
                hsl=0;
            }
        }
        return hsl;
  }
}
