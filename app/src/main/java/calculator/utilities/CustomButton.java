package calculator.utilities;

import javax.swing.*;
import java.awt.*;

// Class in charge of creating modified buttons
public class CustomButton extends JButton {

    public CustomButton(String text, Color bgColor) {
        this(text, bgColor, UIColors.miscColor);

    }

    public CustomButton(String text, Color bgColor, Color textColor) {
        super(text);
        // this(text,bgColor,UIColors.miscColor);
        buildButton(bgColor, textColor);

    }

    // set dimensions // set colors // select font
    private void buildButton(Color bgColor, Color textColor) {
        // super(text);
        setPreferredSize(new Dimension(90, 60));
        setOpaque(false);
        setBorderPainted(false);
        setContentAreaFilled(false);// removes defaul squares

        setBackground(bgColor);
        setForeground(textColor);

        setFont(new Font("Dialog", Font.BOLD, 15));
        setFocusPainted(false);

        // Change colors on mouse events(rollover, click)
        addPropertyChangeListener("pressed", event -> repaint());
        addPropertyChangeListener("rollover", event -> repaint());

    }

    // creates custom borders so that we can have nice round corners :D
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        // System.out.println("Painting component"); // Debugging output

        // kill the jaggies
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // checks if pressed or rollover so that it looks nice
        if (getModel().isPressed()) {
            g2.setColor(getBackground().darker()); // make button darker if pressed
            // System.out.println("Painting Pressed"); // Debugging output
        } else if (getModel().isRollover()) {
            g2.setColor(getBackground().brighter()); // make button pinkish if pressed (red ish)
            // System.out.println("Painting Pink"); // Debugging output
        } else {
            g2.setColor(getBackground()); // stay the same
            // System.out.println("Painting Normal"); // Debugging output
        }
        // make them curvy corners
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50);
        g2.dispose();

        super.paintComponent(g);// make sure we draw those button labels bugfix

    }

}