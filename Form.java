import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Form {

  private JPanel formP;

  private JTextField codeT;
  private JTextField dateT;
  private JTextField nameT;
  private JTextField quantityT;
  private JTextField priceT;
  private JButton submitB;
  private JLabel codeL;
  private JLabel nameL;
  private JLabel priceL;
  private JLabel dateL;
  private JLabel quantityL;
  Database db;
  Medicine med;
  String type;


  public Form(String type) {
    this.type = type;
    db = new Database();

    formP = new JPanel();
    formP.setBounds(30, 0, 460, 200);
    formP.setLayout(null);


    codeT = new JTextField (5);
    dateT = new JTextField (5);
    nameT = new JTextField (5);
    quantityT = new JTextField (5);
    priceT = new JTextField (5);
    submitB = new JButton (type);
    codeL = new JLabel ("Code");
    nameL = new JLabel ("Name");
    priceL = new JLabel ("Price");
    dateL = new JLabel ("Date");
    quantityL = new JLabel ("quantity");


    codeT.setBounds (60, 30, 150, 30);
    nameT.setBounds (60, 70, 150, 30);
    priceT.setBounds (60, 110, 150, 30);
    dateT.setBounds (300, 30, 150, 30);
    quantityT.setBounds (300, 70, 150, 30);
    codeL.setBounds (10, 30, 50, 30);
    nameL.setBounds (10, 70, 50, 30);
    priceL.setBounds (10, 110, 50, 30);
    dateL.setBounds (225, 30, 50, 30);
    quantityL.setBounds (225, 70, 60, 30);
    dateT.setToolTipText ("yyyy-mm-dd");
    submitB.setBounds (350, 150, 100, 30);

    // submitB.addActionListener(new ActionListener() {
    //   public void actionPerformed(ActionEvent e) {
    //     formInsert();
    //   }
    // });


    formP.add (codeT);
    formP.add (dateT);
    formP.add (nameT);
    formP.add (quantityT);
    formP.add (priceT);
    formP.add (submitB);
    formP.add (codeL);
    formP.add (nameL);
    formP.add (priceL);
    formP.add (dateL);
    formP.add (quantityL);

    formP.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), type + " Data"));

  }

  public void formDelete() {
    med = validator();
    if (med != null) {
      db.delete(med.getCode());
    }

  }

  public void formInsert() {
    med = validator();
    if (type == "create") {
      if (med != null) {
        db.insert(med);
      }
    } else if (type == "update") {
      if (med != null) {
        med.toString();
        db.update(med);
      }
    }
  }

  public JPanel getFormP() {
    return formP;
  }

  public JButton getSubmitB() {
    return submitB;
  }

  private Medicine validator() {
    Medicine med = getText();
    
    if (med.getCode().isEmpty() || med.getName().isEmpty() || med.getPrice() < 0 || med.getDate().isEmpty() || med.getQuantity() < 0) {
      // JFrame f1 = (JFrame) SwingUtilities.windowForComponent(formP);
      // JDialog d = new JDialog(f1, "dialog Box");
      // JLabel l = new JLabel("fill the required fields");
      // d.add(l);
      // f1.add(d);
      setText();
      return null;
    } 
    setText();
    return  med;
  }

  public Medicine getText() {
  
    String code = codeT.getText();
    String name = nameT.getText();
    String price = priceT.getText();
    String date = dateT.getText();
    String quantity = quantityT.getText();

    double newPrice = price.isEmpty() ? -1 : Double.parseDouble(price);
    int newQuantity = quantity.isEmpty() ? -1 : Integer.parseInt(quantity);
    System.out.println(newPrice);

    return  new Medicine(code, name, newPrice, newQuantity, date);
  }

  public void setText(Medicine med) {
      codeT.setText(med.getCode());
      nameT.setText(med.getName());
      priceT.setText(Double.toString(med.getPrice()));
      dateT.setText(med.getDate());
      quantityT.setText(Integer.toString(med.getQuantity()));
  }
  
  public void setText() {
      codeT.setText("");
      nameT.setText("");
      priceT.setText("");
      dateT.setText("");
      quantityT.setText("");
  }
}
