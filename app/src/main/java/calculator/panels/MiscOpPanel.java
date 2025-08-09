package calculator.panels;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import calculator.Calculator;
import calculator.utilities.CustomButton;
import calculator.utilities.OperatorHandler;
import calculator.utilities.UIColors;

// this class has the C and f(x) operator Misc. removed from displaypanel
public class MiscOpPanel extends JPanel {

    public MiscOpPanel(Calculator calculator, DisplayPanel displayPanel, OperatorHandler operatorHandler) {

        setLayout(new GridLayout(1, 1, 10, 10));
        String[] displayOps = { "C" };// "f(x)" to render graph

        for (String op : displayOps) {
            CustomButton button = new CustomButton(op, UIColors.miscColor, UIColors.displayColor);
            button.setPreferredSize(new Dimension(190, 60));
            ///////////// test changes
            button.setActionCommand(op); // Set the action command to the operation name
            button.addActionListener(operatorHandler);// Add the same OperatorHandler to handle all button presses
            this.add(button);
        }
    }
}
