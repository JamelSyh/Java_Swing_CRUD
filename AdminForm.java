import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class AdminForm {
    private static final String[] labels = {"Code", "Name", "Price", "Date", "Quantity"};
    
    private JFrame frame;
    private JPanel pane;
    private JPanel leftPane;
    private JPanel rightPane;
    private JTextField[] fields;
    private JButton searchButton;
    private JTextField searchField;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton clearButton;
    private JButton nextButton;
    private JButton previousButton;
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new AdminForm()::createAndShowGUI);
    }
    
    private void createAndShowGUI() {
        frame = new JFrame();
        pane = new JPanel();
        leftPane = createLeftPane();
        rightPane = createRightPane();
        
        pane.add(leftPane);
        pane.add(rightPane);
        
        frame.add(pane);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private JPanel createRightPane() {
        JPanel panel = new JPanel();
        
        searchButton = new JButton("Search");
        searchField = new JTextField(10);
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");
        nextButton = new JButton("Next");
        previousButton = new JButton("Previous");
        
        panel.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        panel.add(searchButton, gbc);
        
        gbc.gridy++;
        gbc.gridwidth = 2;
        
        panel.add(searchField, gbc);
        
        gbc.gridy++;
        gbc.gridwidth = 1;
        
        panel.add(updateButton, gbc);
        
        gbc.gridy++;
        
        panel.add(deleteButton, gbc);
        
        gbc.gridx++;
        panel.add(clearButton, gbc);
        
        gbc.gridx = 0;
        gbc.gridy++;
        
        panel.add(nextButton, gbc);
        
        gbc.gridy++;
        panel.add(previousButton, gbc);
        
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        return panel;
    }
    
    private JPanel createLeftPane() {
        JPanel panel = new JPanel();
        fields = new JTextField[labels.length];
        
        panel.setLayout(new GridLayout(0, 2, 5, 5));
        
        for (int i = 0; i < fields.length; i++) {
            fields[i] = new JTextField(10);
            panel.add(new JLabel(labels[i]));
            panel.add(fields[i]);
        }
        
        //Investigate how to change color of border, etc
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Update Data"));
        
        return panel;
    }
}
