package calculator.panels;

import javax.swing.*;
import java.awt.*;

import calculator.Calculator;
import calculator.utilities.CustomButton;
import calculator.utilities.OperatorHandler;
import calculator.utilities.UIColors;

public class TrigOpPanel extends JPanel {

    public TrigOpPanel(Calculator calculator, DisplayPanel displayPanel, OperatorHandler operatorHandler) {

        JPanel topTrigPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        // 2d Array to better handle symbols
        String[][] trigOps = {
                { "sin", "Sin" },
                { "arcsin", "Sin\u207B\u00B9" }, // superscrio "-" not working \u207B

                { "cos", "Cos" },
                { "arccos", "Cos\u207B\u00B9" },

                { "tan", "Tan" },
                { "arctan", "Tan\u207B\u00B9" },

                { "e", "e" },
                { "pi", "\u03C0" },
                { "log", "log" },
                { "ln", "ln" },
        };

        setLayout(new BorderLayout(10, 10));// row/col
        // loop to pull keys and symbols to create buttons and place them on panels
        for (String[] op : trigOps) {

            String opKey = op[0];
            String opSymbol = op[1];
            CustomButton button = new CustomButton(opSymbol, UIColors.trigOpColor);

            // change the colors of the
            if (opKey.equals("e") || opKey.equals("pi") || opKey.equals("log") || opKey.equals("ln")) {
                button.setBackground(UIColors.trascendentalColor);
            }

            ///////////// test changes
            button.setActionCommand(opKey); // Set the action command to the operation name
            button.addActionListener(operatorHandler);// Add the same OperatorHandler to handle all button presses
            topTrigPanel.add(button);
        }
        add(topTrigPanel, BorderLayout.CENTER);

    }

}
