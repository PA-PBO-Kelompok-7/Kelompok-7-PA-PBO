/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class Modelsiswa {

    public String getNIS() {
        return NIS;
    }

    public void setNIS(String NIS) {
        this.NIS = NIS;
    }

    public String getNama_Siswa() {
        return Nama_Siswa;
    }

    public void setNama_Siswa(String Nama_Siswa) {
        this.Nama_Siswa = Nama_Siswa;
    }

    public Modelguru getNIP_Guru() {
        return NIP_Guru;
    }

    public void setNIP_Guru(Modelguru NIP_Guru) {
        this.NIP_Guru = NIP_Guru;
    }

    public String getTempat() {
        return Tempat;
    }

    public void setTempat(String Tempat) {
        this.Tempat = Tempat;
    }

    public String getTanggal_Lahir() {
        return Tanggal_Lahir;
    }

    public void setTanggal_Lahir(String Tanggal_Lahir) {
        this.Tanggal_Lahir = Tanggal_Lahir;
    }

    public String getPendidikan_Terakhir() {
        return Pendidikan_Terakhir;
    }

    public void setPendidikan_Terakhir(String Pendidikan_Terakhir) {
        this.Pendidikan_Terakhir = Pendidikan_Terakhir;
    }

    public Modelpengguna getMod_pengguna() {
        return mod_pengguna;
    }

    public void setMod_pengguna(Modelpengguna mod_pengguna) {
        this.mod_pengguna = mod_pengguna;
    }
    private String NIS;
    private String Nama_Siswa;
    private Modelguru NIP_Guru;
    private String Tempat;
    private String Tanggal_Lahir;
    private String Pendidikan_Terakhir;
    private Modelpengguna mod_pengguna;
}
