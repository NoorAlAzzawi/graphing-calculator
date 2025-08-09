package calculator.panels;

import javax.swing.*;

import calculator.utilities.*;

import java.awt.*;

public class BinaryOpPanel extends JPanel {
    private OperatorHandler operatorHandler; //my ref to op handler

    // multiline
    public BinaryOpPanel(JPanel subRegion,OperatorHandler operatorHandler) {

        this.operatorHandler = operatorHandler;

        initBinaryOperators(subRegion);
    }
    /** Init my binary panel
     * */
    private void initBinaryOperators(JPanel subRegion) {
        setLayout(new GridLayout(5, 1, 10, 10));
        String[] binaryOps = { "/", "x", "+", "-", "=" };
        
        for (String op : binaryOps) {

            CustomButton button = createButton(op);

            if ("=".equals(op)) {
                button.setBackground(UIColors.equalColor);
                subRegion.add(button, BorderLayout.SOUTH);// adds = to the centralregio
            } else {
                add(button);
            }

        }
    }
    /**my Helper buttonMaker 
     * @return button 
     * */
    private CustomButton createButton(String operation){
        CustomButton button = new CustomButton(operation,UIColors.binaryOpColor);
        button.setActionCommand(operation);
        button.addActionListener(operatorHandler);
        return button;
        
    }




}
