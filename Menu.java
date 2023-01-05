import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;


public class Menu {

  JPanel nav, menuP, menuBtnP, mainCreateP, mainReadP;
  JButton createB, dashboardB, stockB;
  Border blackLine;

  public Menu() {

    blackLine = BorderFactory.createLineBorder(Color.black);

    menuP = new JPanel();
    menuP.setPreferredSize(new Dimension(150, 500));
    menuP.setBackground(Color.WHITE);


    menuBtnP = new JPanel(new GridLayout(3, 1));
    menuBtnP.setPreferredSize(new Dimension(150, 150));
    menuBtnP.setBorder(blackLine);


    createB = new JButton("Create");
    createB.setBackground(Color.WHITE);
    createB.setBorder(blackLine);

    stockB = new JButton("Stock");
    stockB.setBackground(Color.WHITE);

    dashboardB = new JButton("Dashboard");
    dashboardB.setBackground(Color.WHITE);

    menuBtnP.add(createB);
    menuBtnP.add(stockB);
    menuBtnP.add(dashboardB);
    menuP.add(menuBtnP);

    menuP.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY)));

  }
  
  public JPanel getMenu() {
    return menuP;
  }

  public JButton getCreateB() {
    return createB;
  }

  public JButton getStockB() {
    return stockB;
  }

  public JButton getDashboardB() {
    return dashboardB;
  }
}
