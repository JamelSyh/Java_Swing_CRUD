import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;


public class Main {

  Create create;
  Stock stock;
  Read read;
  Dashboard dashboard;
  Form form, updateForm;
  JPanel mainP, createP, stockP, dashboardP;
  JButton createB;
  CardLayout cardLayout;
  JTable jTable;

  public Main() {


    mainP = new JPanel();
    cardLayout = new CardLayout();
    mainP.setLayout(cardLayout);


    // =============================== Create =================================

    create = new Create();
    form = create.getFrom();
    createP = create.getCreateP();
    createB = create.getCreateB();


    // =============================== Stock =================================

    stock = new Stock();
    read = stock.getRead();
    updateForm = stock.getUpdateForm();
    stockP = stock.getStockP();
    jTable = stock.getTable();
    

    // =============================== Dashboard =================================

    dashboard = new Dashboard();
    dashboardP = dashboard.getDashboardP();

    mainP.add(createP, "1");
    mainP.add(stockP, "2");
    mainP.add(dashboardP, "3");
    
  }
  
  public JPanel getMain() {
    return mainP;
  }

  public CardLayout getLayout() {
    return cardLayout;
  }

  public JTable getTable() {
    return jTable;
  }

  public JButton getCreateB() {
    return createB;
  }

  public Form getForm() {
    return form;
  }
  public Read getRead() {
    return read;
  }

  public Form getUpdateForm() {
    return updateForm;
  }

}
