/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.Modelsiswa;

/**
 *
 * @author ACER
 */
public interface Servicesiswa {
    void tambahdata(Modelsiswa modsiswa);
    void perbaruidata (Modelsiswa modsiswa);
    void hapusdata (Modelsiswa modsiswa);

    List<Modelsiswa> getAll();
    List<Modelsiswa> getData(String NIS);
}
