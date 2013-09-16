/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validasi.utilisasi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author faheem
 */
public class ResultSetToDefaultTableModel {
    DefaultTableModel myModel;
    
    public ResultSetToDefaultTableModel(ResultSet rs) {
        try {
            myModel = new javax.swing.table.DefaultTableModel();
                
            for(int i=1;i <= rs.getMetaData().getColumnCount();i++) {
                myModel.addColumn(rs.getMetaData().getColumnName(i));
            }
            while (rs.next()) {
                Object arObj[] = new Object[rs.getMetaData().getColumnCount()];
                for(int i=1;i <= rs.getMetaData().getColumnCount();i++) {
//                    if(rs.getObject(i) != null){
                        arObj[i-1]=rs.getObject(i);
//                    } else {                        
//                        arObj[i-1]=new Object();
//                    }
                }
                myModel.addRow(arObj);
            }    
        } catch (SQLException ex) {
            Logger.getLogger(ResultSetToDefaultTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public DefaultTableModel getModel(){
        return myModel;
    }
}
