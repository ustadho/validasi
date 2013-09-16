/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validasi.form;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import validasi.SQLiteConnection;
import validasi.TabelImport;
import validasi.cek.CekTmstBadanHukum;
import validasi.cek.CekTmstDosen;
import validasi.cek.CekTmstFakultas;
import validasi.cek.CekTmstFasPenunjangAkademik;
import validasi.komponen.PanelTabel;
import validasi.utilisasi.ColumnResizer;
import validasi.utilisasi.ResultSetToDefaultTableModel;

/**
 *
 * @author faheem
 */
public class TestValidasi extends javax.swing.JFrame {

    private Connection conn;
    private CekTmstBadanHukum cekTmstBadanHukum = new CekTmstBadanHukum();
    private CekTmstDosen cekTmstDosen = new CekTmstDosen();
    private CekTmstFakultas cekTmstFakultas = new CekTmstFakultas();
    private CekTmstFasPenunjangAkademik cekTmstFasPenunjangAkademik = new CekTmstFasPenunjangAkademik();
    private String tab;

    /**
     * Creates new form TestValidasi
     */
    public TestValidasi() {
        initComponents();
        conn = new SQLiteConnection().getConn();
        jEditorPane1.setEditable(false);
        jEditorPane1.addHyperlinkListener(createHyperLinkListener());
        jEditorPane1.getDocument().putProperty("Ignore-Charset", "true");  // this line makes no difference either way
        jEditorPane1.setContentType("text/html");

        jTable1.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getColumn() == jTable1.getColumnModel().getColumnIndex("Pilih") && e.getType() == TableModelEvent.UPDATE) {
                    int iRow = jTable1.getSelectedRow();
                    if (iRow < 0) {
                        return;
                    }

                    if ((Boolean) jTable1.getValueAt(iRow, jTable1.getColumnModel().getColumnIndex("Pilih")) == true) {
                        String namaTabel = jTable1.getValueAt(iRow, jTable1.getColumnModel().getColumnIndex("Tabel")).toString();
                        if (cekIndexTab(namaTabel) < 0) {
                            tambahTabPanel(namaTabel);
                        }
                    } else {
                        removePanel();
                    }
                }
            }
        });
    }

    private int cekIndexTab(String namaTab) {
        int k = -1;
        for (int i = 0; i < jTabbedPane1.getTabCount(); i++) {
            if (jTabbedPane1.getTitleAt(i).equalsIgnoreCase(namaTab)) {
                k = i;
                return k;
            }
        }
        return k;
    }

    private void removePanel() {
        for (int i = 0; i < jTabbedPane1.getTabCount(); i++) {
            String namaTabel = jTable1.getValueAt(jTable1.getSelectedRow(), jTable1.getColumnModel().getColumnIndex("Tabel")).toString();
            if (jTabbedPane1.getTitleAt(i).equalsIgnoreCase(namaTabel)) {
                jTabbedPane1.remove(i);
            }
        }
    }

    private void tambahTabPanel(String namaTabel) {
        try {
            PanelTabel panel = new PanelTabel();
            JTable tabel = new JTable();
            ResultSet rs = conn.createStatement().executeQuery("select * from " + namaTabel);
            panel.setTableModel(new ResultSetToDefaultTableModel(rs).getModel());

            jTabbedPane1.addTab(namaTabel, panel);
            jTabbedPane1.setSelectedIndex(jTabbedPane1.getTabCount() - 1);
            //repaint();

        } catch (SQLException ex) {
            Logger.getLogger(TestValidasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jalankan() {
        try {
            if(jTabbedPane1.getTabCount() ==0){
                JOptionPane.showMessageDialog(this, "Tidak ada data yang akan divalidasi!");
            }
            String message = "<html>";

//            message += cekTabel("TMST_BADAN_HUKUM");
//            message += cekTabel("TMST_DOSEN");
//            message += cekTabel("TMST_FAKULTAS");
//            message += cekTabel("TMST_FAS_PENUNJANG_AKADEMIK");
            for (int i = 0; i < jTabbedPane1.getTabCount(); i++) {
                message += cekTabel(jTabbedPane1.getTitleAt(i));
            }

            message += "</html>";
            System.out.println("Message : " + message);
            jEditorPane1.setText(message);
        } catch (SQLException ex) {
            Logger.getLogger(TestValidasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String cekTabel(String namaTabel) throws SQLException {
//        StatusValidasi statusValidasi=new StatusValidasi();
        String pesanAwal = "Tabel : <b>" + namaTabel + "</b> <br>";
        String [][] pesanError=new String[100000][100];
//        pesanError[0][1]="";
        String pesan = "";
        String cekPesan = "";
        int baris = 0;
        String namaKolom = "";
        String pesanPerBaris = "";
        ResultSet rs = conn.createStatement().executeQuery("select * from " + namaTabel);
        while (rs.next()) {
            baris++;
            pesanPerBaris = "";
            for (int col = 1; col <= rs.getMetaData().getColumnCount(); col++) {
                namaKolom = rs.getMetaData().getColumnName(col);
                System.out.println("Checking table : '" + namaTabel + "', baris " + baris + " column : '" + namaKolom + "'");
                if (namaTabel.equalsIgnoreCase("TMST_BADAN_HUKUM")) {
                    cekPesan = cekTmstBadanHukum.cekKolom(baris, namaKolom, rs.getObject(col));
                } else if (namaTabel.equalsIgnoreCase("TMST_DOSEN")) {
                    cekPesan = cekTmstDosen.cekKolom(baris, namaKolom, rs.getObject(col));
                } else if (namaTabel.equalsIgnoreCase("TMST_FAKULTAS")) {
                    cekPesan = cekTmstFakultas.cekKolom(baris, namaKolom, rs.getObject(col));
                } else if (namaTabel.equalsIgnoreCase("TMST_FAS_PENUNJANG_AKADEMIK")) {
                    cekPesan = cekTmstFasPenunjangAkademik.cekKolom(baris, namaKolom, rs.getObject(col));
                }
                System.out.println("Panjang pesanError :"+pesanError.length);
                pesanError[baris-1][col-1]=cekPesan.length()> 0? "error": "";
                cekPesan = cekPesan.length() > 0 ? " <br>"
                        + "<font color=\"red\">"
                        + "<a href=tunjukan-tabke:"+cekIndexTab(namaTabel)
                        + ";row:" + (baris-1) + ";col:" + namaKolom + ";endCol>" + cekPesan + "</a></font>" : "";
                //cekPesan += (cekPesan.length() > 0 ? "<br>" : "");
                System.out.println("Cek Pesan :" + cekPesan);

                pesanPerBaris += cekPesan;
            }
            pesanPerBaris = (pesanPerBaris.length() > 0 ? "<p><b>Baris ke :" + baris + "</b>" : "") + pesanPerBaris;
            pesan += pesanPerBaris;
        }
        int panjang = pesan.length();
        pesan = pesanAwal + pesan;

        if (baris == 0) {
            pesan += "<b>TIDAK ADA DATA di tabel '" + namaTabel + "'</b><br>";
        } else {
//            pesan += "<br>Jumlah data pada tabel <b>'"+namaTabel+"'</b> : <b>"+baris+ "</b>"+(panjang==0? "Tidak ada kesalahan data": "")+"<br>";
        }

        rs.close();
        ((PanelTabel)jTabbedPane1.getComponentAt(cekIndexTab(namaTabel))).setPesanError(pesanError);
        
//        statusValidasi.setJmlBaris(baris);
//        statusValidasi.setErrorMessage(pesan);
        return pesan + "<br>";
    }

    public HyperlinkListener createHyperLinkListener() {
        return new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    System.err.println(e.getDescription());
                    String desc=e.getDescription();
                    if(desc.indexOf("tunjukan-")>=0){
                        String tab=desc.substring(desc.indexOf("tabke:")+6, desc.indexOf(";row"));
                        String row=desc.substring(desc.indexOf("row:")+4, desc.indexOf(";col"));
                        String col=desc.substring(desc.indexOf("col:")+4, desc.indexOf(";endCol"));
                        int colIdx=((PanelTabel)jTabbedPane1.getComponentAt(Integer.valueOf(tab))).getColumnIndex(col);
                        
//                        JOptionPane.showMessageDialog(null, 
//                                "Tab: "+tab+"\n"+
//                                "Row: "+row+"\n"+
//                                "Col : "+col+"\n"+
//                                "ColIdx: "+colIdx);
//                        
                        jTabbedPane1.setSelectedIndex(Integer.valueOf(tab));
                        ((PanelTabel)jTabbedPane1.getComponentAt(Integer.valueOf(tab))).getTable()
                                .changeSelection(Integer.valueOf(row), colIdx, false, false);
                    }
                }
            }
        };
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        chkCheckAll = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jButton1.setText("Test Validasi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tabel", "Pilih"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane3.setViewportView(jTable1);

        chkCheckAll.setText("Pilih Semua");
        chkCheckAll.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkCheckAllItemStateChanged(evt);
            }
        });
        chkCheckAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCheckAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(chkCheckAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkCheckAll)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));
        jPanel2.add(jTabbedPane1);

        jLabel1.setText("Pesan Kesalahan :");

        jScrollPane2.setViewportView(jEditorPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        setBounds(0, 0, 764, 470);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jalankan();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        List<String> a = new TabelImport().getTableList();
//        DefaultListModel defModel = new DefaultListModel();
//        for(int i=0; i<a.size(); i++){
//            defModel.addElement(a.get(i));
//        }
//        jList1.setModel(defModel);
        for (int i = 0; i < a.size(); i++) {
            ((DefaultTableModel) jTable1.getModel()).addRow(new Object[]{
                a.get(i),
                false
            });
        }
        if (jTable1.getRowCount() > 0) {
            jTable1.setRowSelectionInterval(0, 0);
            ColumnResizer.adjustColumnPreferredWidths(jTable1);
        }
    }//GEN-LAST:event_formWindowOpened

    private void chkCheckAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCheckAllActionPerformed
    }//GEN-LAST:event_chkCheckAllActionPerformed

    private void chkCheckAllItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkCheckAllItemStateChanged
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            jTable1.setValueAt(chkCheckAll.isSelected(), i, 1);
        }
    }//GEN-LAST:event_chkCheckAllItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;


                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TestValidasi.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestValidasi.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestValidasi.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestValidasi.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestValidasi().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkCheckAll;
    private javax.swing.JButton jButton1;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
