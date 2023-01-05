import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Create {

  private Form form;
  private JPanel createP, formP;
  private JButton createB;
   
  public Create() {

    createP = new JPanel();
    createP.setLayout(null);


    form = new Form("create");
    formP = form.getFormP();

    createB = form.getSubmitB();

    createP.add (formP);

  }


  public JPanel getCreateP() {
    return createP;
  }

  public JButton getCreateB() {
    return createB;
  }
  public Form getFrom() {
    return form;
  }
} 
