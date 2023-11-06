/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.Modelmapel;
/**
 *
 * @author ACER
 */
public interface Servicemapel {
    void tambahdata (Modelmapel modmapel);
    void perbaruidata (Modelmapel modmapel);
    void hapusdata (Modelmapel modmapel);
    
    Modelmapel getByid (String id);
    
    List<Modelmapel> ambildata();
    List<Modelmapel>cari(String id);
    
    String nomor();
}
