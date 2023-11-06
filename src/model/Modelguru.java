/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class Modelguru {

    public Integer getNIP() {
        return NIP;
    }

    public void setNIP(Integer NIP) {
        this.NIP = NIP;
    }

    public String getNama_Guru() {
        return Nama_Guru;
    }

    public void setNama_Guru(String Nama_Guru) {
        this.Nama_Guru = Nama_Guru;
    }


    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public String getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(String tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getPendidikan_terakhir() {
        return pendidikan_terakhir;
    }

    public void setPendidikan_terakhir(String pendidikan_terakhir) {
        this.pendidikan_terakhir = pendidikan_terakhir;
    }

    public Modelpengguna getMOD_pengguna() {
        return MOD_pengguna;
    }

    public void setMOD_pengguna(Modelpengguna MOD_pengguna) {
        this.MOD_pengguna = MOD_pengguna;
    }
    public void setMOD_pengguna(Integer NIP, String Nama_Guru,String tempat, String tanggal_lahir, String pendidikan_terakhir) {
        this.NIP = NIP;        
        this.Nama_Guru = Nama_Guru;
        this.tempat = tempat;
        this.tanggal_lahir = tanggal_lahir;
        this.pendidikan_terakhir = pendidikan_terakhir;

    }
    private Integer NIP;
    private String Nama_Guru;
    private String tempat;
    private String tanggal_lahir;
    private String pendidikan_terakhir;
    private Modelpengguna MOD_pengguna;
}
