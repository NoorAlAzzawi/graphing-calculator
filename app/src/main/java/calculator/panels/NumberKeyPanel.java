package calculator.panels;

import javax.swing.JPanel;

import calculator.utilities.CustomButton;
import calculator.utilities.OperatorHandler;
import calculator.utilities.UIColors;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class NumberKeyPanel extends JPanel {

    public NumberKeyPanel(OperatorHandler operatorHandler) {
        // this.c = c;
        // this.displayPanel= displayPanel;
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.HORIZONTAL;

        // my keybpad buttons
        String[] numbers = { "7", "8", "9", "4", "5", "6", "1", "2", "3", "0", "." };
        int row = 0;
        int col = 0;
        int numCols = 3;
        Insets padding = new Insets(5, 5, 5, 5);

        for (String number : numbers) {
            CustomButton button = new CustomButton(number, UIColors.numberColor);

            ////////// working fix for inputs
            button.setActionCommand(number); // Set the action command to the operation name
            button.addActionListener(operatorHandler);// Add the same OperatorHandler to handle all button presses

            // GridBayLayout Logic
            gc.gridx = col; // cell position in x
            gc.gridy = row; // cell position in y
            gc.insets = padding; // add some pads between keys

            if (number.equals("0")) { // mayube not efficient, doing bunch of comparisons
                gc.gridwidth = 2;// if 0 button make it twice as fat(wide) two cells
                gc.weightx = 2; //
            } else {
                gc.gridwidth = 1;
                gc.weightx = 1;
            }
            add(button, gc);// add buttons with gc constrains

            // without this all buttons span on the same cell lol
            col += gc.gridwidth;
            // check our column index, if we are at 3 walk down once cell and reset col to 0
            if (col >= numCols) {
                col = 0;
                row++;
            }
        }
    }

}
