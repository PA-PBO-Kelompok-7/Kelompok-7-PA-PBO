/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class Modelraport {

    public String getID_Raport() {
        return ID_Raport;
    }

    public void setID_Raport(String ID_Raport) {
        this.ID_Raport = ID_Raport;
    }

    public Modelmapel getKode_mapel() {
        return kode_mapel;
    }

    public void setKode_mapel(Modelmapel kode_mapel) {
        this.kode_mapel = kode_mapel;
    }

    public Integer getNilai_Rata_Rata() {
        return Nilai_Rata_Rata;
    }

    public void setNilai_Rata_Rata(Integer Nilai_Rata_Rata) {
        this.Nilai_Rata_Rata = Nilai_Rata_Rata;
    }

    public Modelsiswa getNis_siswa() {
        return nis_siswa;
    }

    public void setNis_siswa(Modelsiswa nis_siswa) {
        this.nis_siswa = nis_siswa;
    }

    public Modelguru getNIP_guru() {
        return NIP_guru;
    }

    public void setNIP_guru(Modelguru NIP_guru) {
        this.NIP_guru = NIP_guru;
    }
    private String ID_Raport;
    private Modelmapel kode_mapel;
    private Integer Nilai_Rata_Rata;
    private Modelsiswa nis_siswa;
    private  Modelguru NIP_guru;
}
