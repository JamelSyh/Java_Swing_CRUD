import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard {

  private JPanel dashboardP, operationP, tableP;
  private JTable jTable;
  JTextField searchT;
  JButton searchB, clearB;
  Database db;
  String[] columnNames = {"code", "name", "price", "date", "quantity"};
  String[][] data;

  public Dashboard() {

    dashboardP = new JPanel();
    dashboardP.setLayout(null);
    dashboardP.setBounds(0, 250, 550, 430);

    operationP = new JPanel();
    operationP.setLayout(null);
    operationP.setBounds(30, 0, 460, 50);

    searchT = new JTextField(5);
    searchB = new JButton("search");

    searchT.setBounds(10, 10, 150, 30);
    searchB.setBounds(170, 10, 100, 30);

    clearB = new JButton("clear");
    clearB.setBounds(350, 10, 100, 30);

    tableP = new JPanel();
    tableP.setBounds(30, 50, 460, 430);

    db = new Database();
    data = queryData(10);

    jTable = new JTable(new DefaultTableModel(data, columnNames));
    JScrollPane sp = new JScrollPane(jTable);


    tableP.add(sp);

    operationP.add(searchB);
    operationP.add(searchT);
    operationP.add(clearB);

    dashboardP.add(operationP);
    dashboardP.add(tableP);

    searchB.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int quantity = Integer.parseInt(searchT.getText().toString());
        String[][] data = queryData(quantity);
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        if (data != null) {
          jTable.setModel(tableModel);
        } else {
          tableModel.setRowCount(0);
          jTable.setModel(tableModel);
        }
      }
    });

    clearB.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String[][] data = queryData(10);
        DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
        jTable.setModel(dtm);
      }
    });
  }

  

  public JPanel getDashboardP() {
    return dashboardP;
  }

  public String[][] queryData(int quantity) {
    Medicine[] medList = db.queryUnderCondition(quantity);
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
}
