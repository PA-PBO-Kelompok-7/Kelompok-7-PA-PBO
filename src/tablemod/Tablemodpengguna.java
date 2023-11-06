/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemod;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.Modelpengguna;

/**
 *
 * @author ACER
 */
public class Tablemodpengguna extends AbstractTableModel{
    
    private List<Modelpengguna> list = new ArrayList<>();
    
    public void tambahdata(Modelpengguna modpengguna){
        list.add(modpengguna);
        fireTableRowsInserted(list.size() -1,list.size() -1);
        JOptionPane.showMessageDialog(null, "data berhasil ditambah");
    }
    public void perbaruidata(int row, Modelpengguna modpengguna){
        list.add(row,modpengguna);
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
    public void setData(List<Modelpengguna>list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    public void setData(int index, Modelpengguna modpengguna){
        list.set(index, modpengguna);
        fireTableRowsUpdated(index, index);
    }
    public Modelpengguna getData(int index){
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
            case 0 -> list.get(rowIndex).getId_pengguna();
            case 1 -> list.get(rowIndex).getUsername();
            case 2 -> list.get(rowIndex).getPassword();
            case 3 -> list.get(rowIndex).getLevel();
            default -> null;
        };
    }
    
    public String getColumnName(int column){
        return switch (column) {
            case 0 -> "Id_pengguna";
            case 1 -> "Username";
            case 2 -> "Password";
            case 3 -> "Level";
            default -> null;
        };
    }
}
