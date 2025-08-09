package calculator.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;

import calculator.utilities.UIColors;


import javax.swing.*;

/**
 * Basic DisplayPanel class this should not handle calculator 
 */
public class DisplayPanel extends JPanel {
    private JTextField display;

    public DisplayPanel(){
        super();
        setupDisplay();
    }

    private void setupDisplay(){
        display = new JTextField(){
            @Override
        protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(UIColors.displayColor);//fixed
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50);// arc should be a cosntant
                g2.dispose();
                super.paintComponent(g);
            }
        };

        display.setEditable(false);
        display.setPreferredSize(new Dimension(500,80));
        display.setHorizontalAlignment(JTextField.RIGHT);// display text to the right of the display
        display.setFont(new Font("Monospaced", Font.BOLD, 30));
        display.setOpaque(false);
        display.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));
        
        setLayout(new BorderLayout(10, 10));
        JPanel dpScreenPanel = new JPanel(new GridLayout(1, 1, 10, 10));// holds the screen


        dpScreenPanel.add(display, BorderLayout.CENTER);
        add(dpScreenPanel);

        // add other stuff here later
        
    }
    

    public JTextField getDisplay(){
        return display;
    }
    
}
