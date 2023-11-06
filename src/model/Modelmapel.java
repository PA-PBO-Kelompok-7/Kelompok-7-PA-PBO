/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class Modelmapel {

    public Integer getKode_Mapel() {
        return Kode_Mapel;
    }

    public void setKode_Mapel(Integer Kode_Mapel) {
        this.Kode_Mapel = Kode_Mapel;
    }

    public String getNama_Mapel() {
        return Nama_Mapel;
    }

    public void setNama_Mapel(String Nama_Mapel) {
        this.Nama_Mapel = Nama_Mapel;
    }

    public Modelguru getMod_guru() {
        return mod_guru;
    }

    public void setMod_guru(Modelguru mod_guru) {
        this.mod_guru = mod_guru;
    }

    public Modelguru getMod_guruMapel() {
        return mod_guruMapel;
    }

    public void setMod_guruMapel(Modelguru mod_guruMapel) {
        this.mod_guruMapel = mod_guruMapel;
    }
    private Integer Kode_Mapel;
    private String Nama_Mapel;
    private Modelguru mod_guru;
    private Modelguru mod_guruMapel;
}
