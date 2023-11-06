/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemod;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.Modelmapel;

/**
 *
 * @author ACER
 */
public class Tablemodmapel extends AbstractTableModel{

    private List<Modelmapel> list = new ArrayList<>();
    
    public void tambahdata(Modelmapel modmapel){
        list.add(modmapel);
        fireTableRowsInserted(list.size() -1,list.size() -1);
        JOptionPane.showMessageDialog(null, "data berhasil ditambah");
    }
    public void perbaruidata(int row, Modelmapel modmapel){
        list.add(row,modmapel);
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
    public void setData(List<Modelmapel>list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    public void setData(int index, Modelmapel modmapel){
        list.set(index, modmapel);
        fireTableRowsUpdated(index, index);
    }
    public Modelmapel getData(int index){
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
       return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> list.get(rowIndex).getKode_Mapel();
            case 1 -> list.get(rowIndex).getNama_Mapel();
            case 2 -> list.get(rowIndex).getMod_guru().getNip_Guru();
            case 3 -> list.get(rowIndex).getMod_guruMapel().getNama_Guru();
            default -> null;
        };
    }
    
    public String getColumnName(int column){
        return switch (column) {
            case 0 -> "Kode_Mapel";
            case 1 -> "Nama_Mapel";
            case 2 -> "Nip_Guru";
            case 3 -> "Nama_guru";
            default -> null;
        };
    }
}
