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
import model.Modelguru;
import service.Serviceguru;

/**
 *
 * @author ACER
 */
public class Daoguru implements Serviceguru{
   final String select = "SELECT * FROM guru;";
   final String Search = "SELECT * FROM guru where NIP like ?";
    private Connection conn;

    @Override
    public void tambahdata(Modelguru modguru) {
        PreparedStatement st = null;
        String sql = "INSERT INTO guru (NIP, Nama_Guru, nip_Guru, tempat, tanggal_lahir, pendidikan_terakhir, MOD_pengguna) VALUES (?,?,?,?,?,?)";
        try{
            st = conn.prepareStatement(sql);
            
            st.setInt   (1,     modguru.getNIP());
            st.setString(2, modguru.getNama_Guru());
            st.setInt   (3,     modguru.getNip_Guru().getNIP());
            st.setString(4, modguru.getTempat());
            st.setString(5, modguru.getTanggal_lahir());
            st.setString(6, modguru.getMOD_pengguna().getId_pengguna());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(Daoguru.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Daoguru.class.getName()).log(Level.SEVERE, null, ex);
                }
                      
            }
        }
    }

    @Override
    public void perbaruidata(Modelguru modguru) {
        PreparedStatement st = null;
        String sql = "UPDATE barang SET Nama_Guru=?, nip_guru=?, tempat=?, tanggal_lahir=?, Pendidikan_terakhir=? WHERE NIP='"+modguru.getNIP()+"'";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString (1, modguru.getNama_Guru());
            st.setInt    (2,     modguru.getNip_Guru().getNIP());
            st.setString (3, modguru.getTempat());
            st.setString (4, modguru.getTanggal_lahir());
            st.setString (5, modguru.getPendidikan_terakhir());
            st.setString (6, modguru.getMOD_pengguna().getId_pengguna());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Perbarui Data Gagal");
            Logger.getLogger(Daoguru.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Daoguru.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public void hapusdata(Modelguru modguru) {
        PreparedStatement st = null;
        String sql = "DELETE FROM barang WHERE kode_barang=?";
        try{
            st = conn.prepareStatement(sql);
            
            st.setInt(1, modguru.getNIP());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Daoguru.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(Daoguru.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public Modelguru getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Modelguru> getDataByID() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT * FROM guru where guru like ?";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                Modelguru modguru = new Modelguru();

                modguru.setNIP                (Integer.parseInt(rs.getString ("NIP")));
                modguru.setNama_Guru          (rs.getString ("nama_barang"));
                modguru.setTempat             (rs.getString ("satuan"));
                modguru.setTanggal_lahir      (rs.getString   ("harga"));
                modguru.setPendidikan_terakhir(rs.getString    ("stok"));
                
                list.add(modguru);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Daoguru.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(Daoguru.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(Daoguru.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }

    @Override
    public List<Modelguru> getData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Modelguru> pencarian(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String nomor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
