import javax.swing.*;
import java.awt.*;


public class Update {

  private Form form;
  private JPanel updateP, formP;
  private JButton updateB;

  JTextField searchT;
  JLabel searchL;

  public Update() {

    updateP = new JPanel();
    updateP.setLayout(null);
    updateP.setBounds(0, 0, 490, 200);
      

    form = new Form("update");
    formP = form.getFormP();
    // formP.setLayout(null);
    updateB = form.getSubmitB();
    
    updateP.add(formP);

  }

  public JPanel getUpdateP() {
    return updateP;
  }

  public JButton getUpdateB() {
    return updateB;
  }

  public Form getUpdateForm() {
    return form;
  }
}
