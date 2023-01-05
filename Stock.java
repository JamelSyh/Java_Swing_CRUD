import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import javax.swing.table.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Stock {

  Update update;
  Read read;
  Form updateForm;
  private JPanel stockP, updateP, readP;
  private JButton deleteB, searchB;
  private JTextField searchT;
  private JTable jTable;

  public Stock() {

    stockP = new JPanel();
    stockP.setLayout(null);

    // ========================= update ======================

    update = new Update();
    updateForm = update.getUpdateForm();
    updateP = update.getUpdateP();
    // updateB = update.getUpdateB();





    // ======================== read ==========================


    read = new Read();
    readP = read.getReadP();
    searchT = read.getSearchT();
    searchB = read.getSearchB();
    jTable = read.getTable();
    deleteB = read.getDeleteB();


    deleteB.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        updateForm.formDelete();
        String[][] data = read.queryData();
        DefaultTableModel tableModel = new DefaultTableModel(data, read.columnNames);
        jTable.setModel(tableModel);
      }
    });

    searchB.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String code = searchT.getText().toString();
        String[][] data = read.queryDataByCode(code);
        DefaultTableModel tableModel = new DefaultTableModel(data, read.columnNames);
        if (data != null) {
          jTable.setModel(tableModel);
        } else {
          tableModel.setRowCount(0);
          jTable.setModel(tableModel);
        }
      }
    });


    stockP.add(updateP);
    stockP.add(readP);

    // stockP.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "stock"));

  }

  public JPanel getStockP() {
    return stockP;
  }

  public JTable getTable() {
    return jTable;
  }

  public Read getRead() {
    return read;
  }

  public Form getUpdateForm() {
    return updateForm;
  }
}
