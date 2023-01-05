import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class Read {

  JPanel readP, tableP, operationP;
  JTable jTable;
  JTextField searchT;
  JButton deleteB, searchB;
  Database db;
  String[] columnNames = {"code", "name", "price", "date", "quantity"};
  String[][] data;
  // DefaultTableModel tableModel;

  public Read() {
    readP = new JPanel();
    readP.setLayout(null);
    readP.setBounds(0, 250, 550, 430);


    operationP = new JPanel();
    operationP.setLayout(null);
    operationP.setBounds(30, 0, 460, 50);

    searchT = new JTextField(5);
    searchB = new JButton("search");

    searchT.setBounds(10, 10, 150, 30);
    searchB.setBounds(170, 10, 100, 30);

    deleteB = new JButton("delete");
    deleteB.setBounds(350, 10, 100, 30);


    tableP = new JPanel();
    tableP.setBounds(30, 50, 460, 430);



    db = new Database();
    data = queryData();

    jTable = new JTable(new DefaultTableModel(data, columnNames));
    JScrollPane sp = new JScrollPane(jTable);


    tableP.add(sp);

    operationP.add(searchB);
    operationP.add(searchT);
    operationP.add(deleteB);

    readP.add(operationP);
    readP.add(tableP);

    // tableP.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY)));
  }

  public JPanel getReadP() {
    return readP;
  }

  public JTextField getSearchT() {
    return searchT;
  }

  public JButton getSearchB() {
    return searchB;
  }

  public JTable getTable() {
    return jTable;
  }

  public JButton getDeleteB() {
    return deleteB;
  }

  // public Medicine search(String code) {
  //   return med = db.queryByCode(code);
  // }

  public String[][] queryData() {
    Medicine[] medList = db.queryAll();
    int medLen = medList.length;
    int columnLen = 5;
    String[][] resultSet = new String[medLen][columnLen];
    for (int i = 0; i < medLen; i++) {
      resultSet[i][0] = medList[i].getCode();
      resultSet[i][1] = medList[i].getName();
      resultSet[i][2] = Double.toString(medList[i].getPrice());
      resultSet[i][3] = medList[i].getDate();
      resultSet[i][4] = Integer.toString(medList[i].getQuantity());
    }
    return resultSet;
  }

  public String[][] queryDataByCode(String code) {
    Medicine[] medList = db.queryByCode(code);
    if (medList == null) {
      return null;
    }
    int medLen = medList.length;
    int columnLen = 5;
    String[][] resultSet = new String[medLen][columnLen];
    for (int i = 0; i < medLen; i++) {
      resultSet[i][0] = medList[i].getCode();
      resultSet[i][1] = medList[i].getName();
      resultSet[i][2] = Double.toString(medList[i].getPrice());
      resultSet[i][3] = medList[i].getDate();
      resultSet[i][4] = Integer.toString(medList[i].getQuantity());
    }
    return resultSet;
  }

  public void refreshTable() {
    String[][] data = queryData();
    System.out.println(data.length);
    DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
     jTable.setModel(dtm);
  }
}
