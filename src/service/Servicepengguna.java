/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;
import java.util.List;
import model.Modelpengguna;
/**
 *
 * @author ACER
 */
public interface Servicepengguna {
    void tambahdata (Modelpengguna modpengguna);
    void perbaruidata(Modelpengguna modpengguna);
    void hapusdata(Modelpengguna modpengguna);
    
    Modelpengguna getByid (String id);
    
    List<Modelpengguna> getData();
    List<Modelpengguna> pencarian(String id);
    
    String nomor();
}
