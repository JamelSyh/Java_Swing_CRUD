import javax.swing.*;
import java.awt.*;


public class Nav {

  JPanel nav;
  JLabel title;

  public Nav() {

    nav = new JPanel();
    nav.setPreferredSize(new Dimension(500, 50));
    nav.setBackground(Color.WHITE);
    nav.setLayout(new GridBagLayout());

    title = new JLabel("Medicine");

    nav.add(title);
     
    nav.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY)));
  }

  public JPanel getNav() {
    return nav;
  }
}
