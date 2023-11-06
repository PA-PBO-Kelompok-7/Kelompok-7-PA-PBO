/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.Modelguru;

/**
 *
 * @author ACER
 */
public interface Serviceguru {
    void tambahdata(Modelguru modguru);
    void perbaruidata (Modelguru modguru);
    void hapusdata (Modelguru modguru);

    Modelguru getByid (String id);
    
    List<Modelguru> getDataByID();
    List<Modelguru> getData();
    
    List<Modelguru> pencarian(String id);
    
    String nomor();
    
}
