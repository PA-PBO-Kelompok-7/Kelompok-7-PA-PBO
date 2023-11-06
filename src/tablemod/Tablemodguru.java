/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemod;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.Modelguru;

/**
 *
 * @author ACER
 */
public class Tablemodguru extends AbstractTableModel {

    private List<Modelguru> list = new ArrayList<>();
    
    public void tambahdata(Modelguru modguru){
        list.add(modguru);
        fireTableRowsInserted(list.size() -1,list.size() -1);
        JOptionPane.showMessageDialog(null, "data berhasil ditambah");
    }
    public void perbaruidata(int row, Modelguru modguru){
        list.add(row,modguru);
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
    public void setData(List<Modelguru>list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    public void setData(int index, Modelguru modguru){
        list.set(index, modguru);
        fireTableRowsUpdated(index, index);
    }
    public Modelguru getData(int index){
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
            case 0 -> list.get(rowIndex).getNIP();
            case 1 -> list.get(rowIndex).getNama_Guru();
            case 3 -> list.get(rowIndex).getTempat();
            case 4 -> list.get(rowIndex).getTanggal_lahir();
            case 5 -> list.get(rowIndex).getPendidikan_terakhir();
        case 6 -> list.get(rowIndex).getMOD_pengguna().getId_pengguna();
            default -> null;
        };
    }
    
    public String getColumnName(int column){
        return switch (column) {
            case 0 -> "NIP";
            case 1 -> "Nama_Guru";
            case 2 -> "Nip_Guru";
            case 3 -> "Tempat";
            case 4 -> "Tanggal_lahir";
            case 5 -> "Pendidikan_terakhir";
            case 6 -> "Id_Pengguna";
            default -> null;
        };
    }
}
