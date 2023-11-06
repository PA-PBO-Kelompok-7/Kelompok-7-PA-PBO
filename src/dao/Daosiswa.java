/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Modelsiswa;
import service.Servicesiswa;

/**
 *
 * @author ACER
 */
public class Daosiswa implements Servicesiswa{
    final String select = "SELECT * FROM siswa;";
    final String Search = "SELECT * FROM siswa where NIS like ?";
    private Connection conn;

    @Override
    public void tambahdata(Modelsiswa modsiswa) {
        PreparedStatement st = null;
        String sql = "INSERT INTO guru (NIP, Nama_siswa, nip_Guru, tempat, tanggal_lahir, pendidikan_terakhir, MOD_pengguna) VALUES (?,?,?,?,?,?)";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString  (1, modsiswa.getNIS());
            st.setString  (2, modsiswa.getNama_Siswa());
            st.setInt     (3,     modsiswa.getNIP_Guru().getNIP());
            st.setString  (4, modsiswa.getTempat());
            st.setString  (5, modsiswa.getTanggal_Lahir());
            st.setString  (6, modsiswa.getMod_pengguna().getId_pengguna());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(Daosiswa.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Daosiswa.class.getName()).log(Level.SEVERE, null, ex);
                }
                      
            }
        }
    }

    @Override
    public void perbaruidata(Modelsiswa modsiswa) {
        PreparedStatement st = null;
        String sql = "UPDATE barang SET Nama_Siswa=?, nip_guru=?, tempat=?, tanggal_lahir=?, Pendidikan_terakhir=? WHERE NIS='"+modsiswa.getNIS()+"'";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString (1, modsiswa.getNama_Siswa());
            st.setInt    (2,     modsiswa.getNIP_Guru().getNIP());
            st.setString (3, modsiswa.getTempat());
            st.setString (4, modsiswa.getTanggal_Lahir());
            st.setString (5, modsiswa.getPendidikan_Terakhir());
            st.setString (6, modsiswa.getMod_pengguna().getId_pengguna());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Perbarui Data Gagal");
            Logger.getLogger(Daosiswa.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Daosiswa.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public void hapusdata(Modelsiswa modsiswa) {
        PreparedStatement st = null;
        String sql = "DELETE FROM barang WHERE kode_barang=?";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, modsiswa.getNIS());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Daosiswa.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(Daosiswa.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public List<Modelsiswa> getAll() {
        java.util.List<Modelsiswa> lb = null;
        try {
           lb = new ArrayList<Modelsiswa>();
           Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery(select);
           while (rs.next()){
               Modelsiswa modsiswa = new Modelsiswa();
               modsiswa.setNIS                  (rs.getString("NIP"));
               modsiswa.setNama_Siswa           (rs.getString("Nama_Guru"));
               modsiswa.setNIP_Guru             (NIP_Guru);.getNIP(rs.getString("kapasitas_maksimum"));
               modsiswa.setTempat               (rs.getString("Tempat"));
               modsiswa.setTanggal_Lahir        (rs.getString("Tanggal_Lahir"));
               modsiswa.setPendidikan_Terakhir  (rs.getString("Pendidikan_Terakhir"));
               modsiswa.setMod_pengguna         (rs.getString("kategori_wahana"));
               lb.add(modsiswa);
               
           }
       } catch (SQLException ex) {
           Logger.getLogger(Modelsiswa.class.getName()).log(Level.SEVERE, null, ex);
       }
       return lb;
    }

    @Override
    public List<Modelsiswa> getData(String NIS) {
        java.util.List<Modelsiswa> lb = null;
        try {
           lb = new ArrayList<Modelsiswa>();
           PreparedStatement st = conn.prepareStatement(Search);
           st.setString(1, "%"+ NIS + "%" );
           ResultSet rs = st.executeQuery();
           while (rs.next()){
               Modelsiswa modsiswa = new Modelsiswa();
               modsiswa.setNIS                  (rs.getString("id_wahana"));
               modsiswa.setNama_Siswa           (rs.getString("nama_wahana"));
               modsiswa.setNip_Guru()           (rs.getString("kapasitas_maksimum"));
               modsiswa.setTempat               (rs.getString("kategori_wahana"));
               modsiswa.setTanggal_Lahir        (rs.getString("kategori_wahana"));
               modsiswa.setPendidikan_Terakhir  (rs.getString("kategori_wahana"));
               modsiswa.setMod_pengguna         (rs.getString("kategori_wahana"));
               lb.add(modsiswa);
           }
       } catch (SQLException ex) {
           Logger.getLogger(Modelsiswa.class.getName()).log(Level.SEVERE,null,ex);
       }
       return lb;
    }
}

