package drawing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawingButtonPanel extends JPanel {

    public  DrawingButtonPanel(int axis){
        super();
        this.setLayout(new BoxLayout(this,axis)); 
    }

    public JButton addButton(String name){
        JButton button = new JButton(name);
        
        // Add button to drawing button panel
        this.add(button);
        return(button);
    }

    public void addPenButtonListener(JButton button, JFrame frame, DrawingPanel drawingPanel) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(frame, "Choose a Pen Color", drawingPanel.getPenColor());
                if (color != null) {
                    drawingPanel.setPenColor(color);
                }
            }
        });
    }
}
