package drawing;


import javax.swing.*; // For GUI
import javax.swing.border.*;
import java.awt.*; // For mouse listeners and events
import java.util.*;  // For ArrayList<>
import text.*;

public class DrawingComponent {
    private DrawingPanel drawingPanel;
    private ArrayList<JTextField> textFieldList;

    public void createDrawingUI(JFrame frame) {
        // Create panel for text fields
        TextPanel textPanel = new TextPanel(BoxLayout.X_AXIS);
        textFieldList = textPanel.addTextFields(2);
        frame.add(textPanel, BorderLayout.NORTH);

                // Create panel for drawing
        drawingPanel = new DrawingPanel(textFieldList.get(0),textFieldList.get(1));
        drawingPanel.setPreferredSize(new Dimension(400,200));
        drawingPanel.setBorder(new LineBorder(Color.BLACK,2));
        frame.add(drawingPanel, BorderLayout.EAST);

        // Create panel for drawing buttons
        DrawingButtonPanel drawingButtonPanel = new DrawingButtonPanel(BoxLayout.Y_AXIS);
        JButton drawButton = drawingButtonPanel.addButton("Select Pen Color");
        drawingButtonPanel.addPenButtonListener(drawButton, frame, drawingPanel);
        frame.add(drawButton, BorderLayout.SOUTH);


    }

}

    