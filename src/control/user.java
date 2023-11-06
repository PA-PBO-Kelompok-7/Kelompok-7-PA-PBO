/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class user extends koneksi {
    public user(){
        super.setKoneksi();
    }
    public DefaultTableModel model = new DefaultTableModel();
    
    public void simpan(String id,String user,String pass,String nama,String jabatan) throws SQLException{
        String sql = "INSERT INTO admin VALUES ('"+id+"','"+user+"','"+pass+"','"+nama+"','"+jabatan+"')";
        st.executeUpdate(sql);
    }
    public void edit(String id,String user,String pass,String nama,String jabatan) throws SQLException{
        String sql = "UPDATE admin set username = '"+user+"', password = '"+pass+"', nama = '"+nama+"' , jabatan = '"+jabatan+"' where id = '"+id+"'";
        st.executeUpdate(sql);
    }
    public void hapus(String id) throws SQLException{
        String sql = "DELETE FROM admin where id = '"+id+"'";
        st.executeUpdate(sql);
    }
    public void tampil(){
        String sql = "SELECT * FROM admin order by id";
        String[] kolom = {"ID","Username","Password","Nama","Jabatan"};
       
        try {
            rs = st.executeQuery(sql);
            model.setColumnIdentifiers(kolom);
           while(rs.next()){
                Object[] data = new Object[5];
                data[0] = rs.getString("id");
                data[1] = rs.getString("username");
                data[2] = rs.getString("password");
                data[3] = rs.getString("nama");
                data[4] = rs.getString("jabatan");
                
                model.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
