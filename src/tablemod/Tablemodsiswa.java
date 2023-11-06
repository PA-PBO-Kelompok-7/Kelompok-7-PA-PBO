/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemod;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.Modelsiswa;


/**
 *
 * @author ACER
 */
public class Tablemodsiswa extends AbstractTableModel{

    private List<Modelsiswa> list = new ArrayList<>();
    
    public void tambahdata(Modelsiswa modsiswa){
        list.add(modsiswa);
        fireTableRowsInserted(list.size() -1,list.size() -1);
        JOptionPane.showMessageDialog(null, "data berhasil ditambah");
    }
    public void perbaruidata(int row, Modelsiswa modsiswa){
        list.add(row,modsiswa);
        fireTableDataChanged();
        JOptionPane.showMessageDialog(null, "data berhasil diperbarui");
    }
    public void hapusdata(int index){
        list.remove(index);
        fireTableRowsDeleted(index, index);
        JOptionPane.showMessageDialog(null, "data berhasil dihapus");
    }
    public void clear(){
        list.clear();
        fireTableDataChanged();
    }
    public void setData(List<Modelsiswa>list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    public void setData(int index, Modelsiswa modsiswa){
        list.set(index, modsiswa);
        fireTableRowsUpdated(index, index);
    }
    public Modelsiswa getData(int index){
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
       return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> list.get(rowIndex).getNIS();
            case 1 -> list.get(rowIndex).getNama_Siswa();
            case 2 -> list.get(rowIndex).getNIP_Guru().getNIP();
            case 3 -> list.get(rowIndex).getTempat();
            case 4 -> list.get(rowIndex).getTanggal_Lahir();
            case 5 -> list.get(rowIndex).getPendidikan_Terakhir();
            case 6 -> list.get(rowIndex).getMod_pengguna().getId_pengguna();
            default -> null;
        };
    }
    
    public String getColumnName(int column){
        return switch (column) {
            case 0 -> "NIS";
            case 1 -> "Nama_Siswa";
            case 2 -> "NIP_Guru";
            case 3 -> "Tempat";
            case 4 -> "Tanggal_Lahir";
            case 5 -> "Pendidikan_Terakhir";
            case 6 -> "Id_Pengguna";
            default -> null;
        };
    }
}
