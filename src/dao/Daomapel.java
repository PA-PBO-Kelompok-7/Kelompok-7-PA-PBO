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
import model.Modelmapel;
import service.Servicemapel;

/**
 *
 * @author ACER
 */
public class Daomapel implements Servicemapel {
    
    private Connection conn;
    
    @Override
    public void tambahdata(Modelmapel modmapel) {
        PreparedStatement st = null;
        String sql = "INSERT INTO guru (Kode_Mapel, Nama_Mapel, nip_Guru, Guru_Mapel) VALUES (?,?,?,?)";
        try{
            st = conn.prepareStatement(sql);
            
            st.setInt   (1,     modmapel.getKode_Mapel());
            st.setString(2, modmapel.getNama_Mapel());
            st.setInt   (3,     modmapel.getMod_guru().getNIP());
            st.setString(4, modmapel.getMod_guruMapel().getNama_Guru());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(Daomapel.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Daomapel.class.getName()).log(Level.SEVERE, null, ex);
                }
                      
            }
        }
    }

    @Override
    public void perbaruidata(Modelmapel modmapel) {
        PreparedStatement st = null;
        String sql = "UPDATE barang SET Nama_Mapel=?, nip_guru=?, Nama_guru=? WHERE Kode_Mapel='"+modmapel.getKode_Mapel()+"'";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString (1, modmapel.getNama_Mapel());
            st.setInt    (2,     modmapel.getMod_guru().getNIP());
            st.setString (3, modmapel.getMod_guruMapel().getNama_Guru());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Perbarui Data Gagal");
            Logger.getLogger(Daomapel.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Daomapel.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public void hapusdata(Modelmapel modmapel) {
        PreparedStatement st = null;
        String sql = "DELETE FROM barang WHERE Kode_Mapel=?";
        try{
            st = conn.prepareStatement(sql);
            
            st.setInt(1, modmapel.getKode_Mapel());
            
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
    public Modelmapel getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Modelmapel> ambildata() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Modelmapel> cari(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String nomor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
