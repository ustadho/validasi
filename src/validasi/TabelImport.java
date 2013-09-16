/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validasi;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author faheem
 */
public class TabelImport {

    public List<String> getTableList() {
        List<String> lst = new ArrayList<String>();
        lst.add("TMST_BADAN_HUKUM");
        lst.add("TMST_DOSEN");
        lst.add("TMST_FAKULTAS");
        lst.add("TMST_FAS_PENUNJANG_AKADEMIK");
        lst.add("TMST_JURUSAN");
        lst.add("TMST_KERJASAMA_PT_LN");
        lst.add("TMST_LABORATORIUM");
        lst.add("TMST_MAHASISWA");
        lst.add("TMST_MATA_KULIAH");
        lst.add("TMST_PEGAWAI");
        lst.add("TMST_PERGURUAN_TINGGI");
        lst.add("TMST_PROGRAM_STUDI");
        lst.add("TMST_PUSTAKA_PT");
        lst.add("TMST_SARANA_PT");
        lst.add("TMST_USERNAME");
        lst.add("TMST_SMS");
        lst.add("TMST_SMS_PRODI");

        return lst;
    }
}

