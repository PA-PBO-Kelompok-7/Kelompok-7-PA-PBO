/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.Connect;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import model.Modelraport;
import service.Serviceraport;

/**
 *
 * @author ACER
 */
public class Daoraport implements Serviceraport {
    
    private Connection conn;

    @Override
    public void tambahdata(Modelraport modraport) {
        PreparedStatement st = null;
        String sql = "INSERT INTO guru (ID_Raport, Kode_Mapel, Nilai_Rata_Rata, Nis_Siswa, Nip_Guru) VALUES (?,?,?,?,?)";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString   (1, modraport.getID_Raport());
            st.setInt      (2,     modraport.getKode_mapel().getKode_Mapel());
            st.setInt      (3,     modraport.getNilai_Rata_Rata());
            st.setString   (4, modraport.getNis_siswa().getNIS());
            st.setInt      (5,     modraport.getNIP_guru().getNIP());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(Daoraport.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Daoraport.class.getName()).log(Level.SEVERE, null, ex);
                }       
            }
        }
    }

    @Override
    public void perbaruidata(Modelraport modraport) {
        PreparedStatement st = null;
        String sql = "UPDATE barang SET Nama_Mapel=?, nip_guru=?, Nama_guru=? WHERE Kode_Mapel='"+modraport.getID_Raport()+"'";
        try{
            st = conn.prepareStatement(sql);
            
            st.setInt    (1, modraport.getKode_mapel().getKode_Mapel());
            st.setInt    (2,     modraport.getNilai_Rata_Rata());
            st.setString (3, modraport.getNis_siswa().getNIS());
            st.setInt    (4, modraport.getNIP_guru().getNIP());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Perbarui Data Gagal");
            Logger.getLogger(Daoraport.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Daoraport.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public void hapusdata(Modelraport modraport) {
        PreparedStatement st = null;
        String sql = "DELETE FROM barang WHERE Kode_Mapel=?";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, modraport.getID_Raport());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Daomapel.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(Daomapel.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public Modelraport getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Modelraport> ambilData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Modelraport> ambilCari1(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String nomor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
