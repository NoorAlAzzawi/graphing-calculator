package calculator.panels;

import javax.swing.*;

import calculator.Calculator;

import calculator.utilities.*;

import java.awt.*;

public class UnaryOpPanel extends JPanel {

    public UnaryOpPanel(Calculator calculator, DisplayPanel displayPanel, JPanel subRegion,
            OperatorHandler operatorHandler) {

        setLayout(new GridLayout(5, 1, 10, 10));
        // String[] unaryOperators = {"√", "1/x", "x²", "n!", "Σ", "|x|"};

        // 2D Array to replace old hasmap
        String[][] unaryOperators = {
                { "sqr", "x\u00B2" },
                { "sqrt", "\u221A" },
                { "oneDivideBy", "1/x" },
                { "abs", "|\u0078|" },
                { "fact", "n!" },
                { "tmode", "T" },

        };

        for (String[] op : unaryOperators) {
            String opKey = op[0];
            String opSymbol = op[1];
            CustomButton button = new CustomButton(opSymbol, UIColors.unaryColor);

            if (opKey.equals("tmode")) {
                button.setBackground(UIColors.unaryColor);
                subRegion.add(button);
            } else {
                // sino ponemos todos los botones donde les toca
                add(button);
            }

            // Changes to work with operatorHandler
            button.setActionCommand(opKey); // Set the action command to the operation name
            button.addActionListener(operatorHandler);// Add the same OperatorHandler to handle all button presses

        }

    }

}
