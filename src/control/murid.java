/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class murid extends koneksi {
    public murid(){
        super.setKoneksi();
    }
    
    public DefaultTableModel model = new DefaultTableModel();
    public void simpan(String NIS,String Nama_Siswa,String Tempat,String Tanggal_Lahir,String Pendidikan_Terakhir) throws SQLException{
        String sql = "INSERT INTO siswa VALUES('"+NIS+"','"+Nama_Siswa+"','"+Tempat+"','"+Tanggal_Lahir+"','"+Pendidikan_Terakhir+"')";
        st.executeUpdate(sql);
    }
    public void edit(String NIS,String Nama_Siswa,String Tempat,String Tanggal_Lahir,String Pendidikan_Terakhir) throws SQLException{
        String sql = "UPDATE siswa set Nama_Siswa = '"+Nama_Siswa+"', Tempat = '"+Tempat+"', Tanggal_Lahir = '"+Pendidikan_Terakhir+"', Pendidikan_Terakhir = '"+Tanggal_Lahir+"' WHERE NIS = '"+NIS+"'";
        st.executeUpdate(sql);
    }
    public void hapus(String NIS) throws SQLException{
        String sql = "DELETE FROM siswa WHERE NIS = '"+NIS+"'";
        st.executeUpdate(sql);
    }
    public void tampil(){
        try {
            String sql = "SELECT * FROM siswa";
            rs = st.executeQuery(sql);
            String[] kolom = {"NIS","NAMA SISWA","TEMPAT","TANGGAL LAHIR","PENDIDIKAN TERAKHIR"};
            model.setColumnIdentifiers(kolom);
            while(rs.next()){
                System.out.println("fdsa");
                Object[] data = new Object[5];
                data[0] = rs.getString("NIS");
                data[1] = rs.getString("Nama_Siswa");
                data[2] = rs.getString("Tempat");
                data[3] = rs.getString("Tanggal_Lahir");
                data[4] = rs.getString("Pendidikan_Terakhir");
                
                model.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(murid.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
