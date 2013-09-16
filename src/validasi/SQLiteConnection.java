/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validasi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import validasi.form.FormValidasi;

/**
 *
 * @author faheem
 */
public class SQLiteConnection {
    private static PropertyResourceBundle resources;
    private Connection conn = null;
    
    static {
        try {
            String sDir=System.getProperties().getProperty("user.dir");
            resources = new PropertyResourceBundle(new FileInputStream(new File(sDir+"/setting.properties")));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (MissingResourceException mre) {
            System.err.println("setting.properties not found");
            System.exit(1);
        }
    }

    public SQLiteConnection() {
        try {

            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:"+resources.getString("sqlite.database"));

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormValidasi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConn(){
        return conn;
    }
}
