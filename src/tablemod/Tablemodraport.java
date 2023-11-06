/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemod;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.Modelraport;

/**
 *
 * @author ACER
 */
public class Tablemodraport extends AbstractTableModel{

    private List<Modelraport> list = new ArrayList<>();
    
    public void tambahdata(Modelraport modraport){
        list.add(modraport);
        fireTableRowsInserted(list.size() -1,list.size() -1);
        JOptionPane.showMessageDialog(null, "data berhasil ditambah");
    }
    public void perbaruidata(int row, Modelraport modraport){
        list.add(row,modraport);
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
    public void setData(List<Modelraport>list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    public void setData(int index, Modelraport modraport){
        list.set(index, modraport);
        fireTableRowsUpdated(index, index);
    }
    public Modelraport getData(int index){
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
       return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> list.get(rowIndex).getID_Raport();
            case 1 -> list.get(rowIndex).getKode_mapel().getKode_Mapel();
            case 2 -> list.get(rowIndex).getNilai_Rata_Rata();
            case 3 -> list.get(rowIndex).getNis_siswa().getNIS();
            case 4 -> list.get(rowIndex).getNIP_guru().getNIP();
            default -> null;
        };
    }
    
    public String getColumnName(int column){
        return switch (column) {
            case 0 -> "Kode_Mapel";
            case 1 -> "Nama_Mapel";
            case 2 -> "Nip_Guru";
            case 3 -> "Nama_guru";
            case 4 -> "Nama_guru";
            default -> null;
        };
    }
}
