/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;
import java.util.List;
import model.Modelraport;
/**
 *
 * @author ACER
 */
public interface Serviceraport {
    void tambahdata (Modelraport modraport);
    void perbaruidata (Modelraport modraport);
    void hapusdata (Modelraport modraport);
    
    Modelraport getByid(String id);
    
    List<Modelraport> ambilData();
    List<Modelraport> ambilCari1(String id);
    
    String nomor();
}
