/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Main.MenuUtama;
import config.Connect;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Modellogin;
import service.Servicelogin;
import view.MenuLogin;


/**
 *
 * @author ACER
 */
public class Daologin implements Servicelogin{
    
    private Connection conn;
    
    public Daologin(){
        conn = (Connection) Connect.getConnection();
    }

    @Override
    public void proseslogin(Modellogin modlogin) {
        PreparedStatement st = null;
        ResultSet rs         = null;
        String Id            = null;
        String Username      = null;
        String Password      = null;
        String Level2        = null;
        String sql = "SELECT * FROM pengguna WHERE(ID_Pengguna='"+modlogin.getID_pengguna()+"'OR Username='"+modlogin.getUsername()+"') AND Password='"+modlogin.getPassword()+"'";
        try{
            st =conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                Id   = rs.getString("id_pengguna");
                Username = rs.getString("Username");
                Level2 = rs.getString("level");
//                Blob gambarBlob = rs.getBlob("gambar");
                
                Modellogin mod = new Modellogin();
                mod.setID_pengguna(Id);
                mod.setUsername(Username);
//                mod.setGambar(gambarBlob);
                
                MenuUtama menu = new MenuUtama(Id,Username,Level2);
                menu.setVisible(true);
                menu.revalidate();
                
                MenuLogin lg = new MenuLogin();
                lg.tutup = true;
            }else{
                JOptionPane.showMessageDialog(null, "Username dan Password salah", "Pesan", JOptionPane.INFORMATION_MESSAGE);
                MenuLogin lg = new MenuLogin();
                lg.tutup = false;
            }
        }catch(SQLException ex) {
            Logger.getLogger(Daologin.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException ex){
                    Logger.getLogger(Daologin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
    
