import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {


  Main main;
  Menu menu;
  Nav nav;
  Form form, updateForm;
  Read read;
  JPanel navP, menuP, mainP, formP;
  CardLayout cardLayout;
  JButton createB, stockB, dashboardB, formCreateB, formUpdateB;
  JTable jTable;

  public MainFrame() {

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setBounds(100, 100, 700, 800);
    setLayout(new BorderLayout());


    // ====================== nav ======================


    nav = new Nav();
    navP = nav.getNav();


    // ==================== menu =======================

    
    menu = new Menu();
    menuP = menu.getMenu();

    createB = menu.getCreateB();
    stockB = menu.getStockB();
    dashboardB = menu.getDashboardB();

    createB.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          cardLayout.show(mainP, "1");
        }
    });
    stockB.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          cardLayout.show(mainP, "2");
        }
    });

    dashboardB.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          cardLayout.show(mainP, "3");
        }
    });


    // ==================== Main =======================

    main = new Main();
    form = main.getForm();
    updateForm = main.getUpdateForm();
    read = main.getRead();

    mainP = main.getMain();
    jTable = read.getTable();
    formP = form.getFormP();

    formCreateB = form.getSubmitB();
    formUpdateB = updateForm.getSubmitB();
    cardLayout = main.getLayout();

    formCreateB.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        cardLayout.show(mainP, "2");
        form.formInsert();
        String[][] data = read.queryData();
        DefaultTableModel tableModel = new DefaultTableModel(data, read.columnNames);
        jTable.setModel(tableModel);
      }
    });

    formUpdateB.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        cardLayout.show(mainP, "2");
        updateForm.formInsert();
        String[][] data = read.queryData();
        DefaultTableModel tableModel = new DefaultTableModel(data, read.columnNames);
        jTable.setModel(tableModel);
      }
    });
    jTable.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        int row = jTable.rowAtPoint(evt.getPoint());
        if (row >= 0 ) {
          String code = jTable.getModel().getValueAt(row, 0).toString();
          String name = jTable.getModel().getValueAt(row, 1).toString();
          double price = Double.valueOf(jTable.getModel().getValueAt(row, 2).toString());
          String date = jTable.getModel().getValueAt(row, 3).toString();
          int quantity = Integer.parseInt(jTable.getModel().getValueAt(row, 4).toString());
          updateForm.setText(new Medicine(code, name, price, quantity, date));
        }

      }
    });


    // ====================== adding =====================

    add(navP, BorderLayout.NORTH);
    add(menuP, BorderLayout.WEST);
    add(mainP, BorderLayout.CENTER);
    // pack();
    // setVisible(true);
  }

  public static void main(String[] args) {
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
  }
}
