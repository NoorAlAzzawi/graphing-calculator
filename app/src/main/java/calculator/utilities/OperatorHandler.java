package calculator.utilities;

import javax.swing.*;

import calculator.Calculator;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.text.DecimalFormat;

/**
 * Operator Handler is in charge of listening for events and
 * talk to the Calculator.java and DisplayPanel.java with the help
 * of reader() and writer()
 * 
 * @param e
 */

public class OperatorHandler implements ActionListener {
    private boolean clearNext;
    private Calculator c = new Calculator();
    private JTextField t; // text values que le pasamos al display
    // private JPanel gp; //my ref to mygraphpanel

    public OperatorHandler(JTextField t) {
        this.t = t;// textfield
        this.clearNext = false;
    }

    // adpted version of vanially action performed code
    @Override
    public void actionPerformed(ActionEvent e) {
        final Object source = e.getSource();

        if (source instanceof JButton) {
            JButton button = (JButton) source;
            String command = button.getActionCommand();

            switch (command) {
                // binary Op
                case "+":
                    System.out.println(command);
                    writer(c.twoOpCaller(Calculator.twoOperator.add, reader()));
                    clearNext = true;
                    break;
                case "-": // need to fix thi activation
                    System.out.println(command);
                    writer(c.twoOpCaller(Calculator.twoOperator.subtract, reader()));
                    clearNext = true;
                    break;
                case "x":
                    System.out.println(command);
                    writer(c.twoOpCaller(Calculator.twoOperator.multiply, reader()));
                    clearNext = true;
                    break;
                case "/":
                    System.out.println(command);
                    writer(c.twoOpCaller(Calculator.twoOperator.divide, reader()));
                    clearNext = true;
                    break;

                // single operator "calcScience"
                // Unary Operators
                case "sqr":
                    System.out.println(command);
                    writer(c.calcScience(Calculator.singleOperator.square, reader()));
                    break;
                case "sqrt":
                    System.out.println(command);
                    writer(c.calcScience(Calculator.singleOperator.squareRoot, reader()));
                    break;
                case "oneDivideBy":
                    System.out.println(command);
                    writer(c.calcScience(Calculator.singleOperator.oneDevidedBy, reader()));
                    break;
                case "abs":
                    System.out.println(command);
                    writer(c.calcScience(Calculator.singleOperator.abs, reader()));
                    break;
                case "fact":
                    System.out.println(command);
                    writer(c.calcScience(Calculator.singleOperator.fact, reader()));
                    break;
                case "tmode":
                    System.out.println(command);
                    writer("Saylor Twift");
                    taylorMode();
                    break;
                //////////////////////////////
                case "sin":
                    System.out.println(command);
                    writer(c.calcScience(Calculator.singleOperator.sin, reader()));
                    break;
                case "cos":
                    System.out.println(command);
                    writer(c.calcScience(Calculator.singleOperator.cos, reader()));
                    break;
                case "tan":
                    System.out.println(command);
                    writer(c.calcScience(Calculator.singleOperator.tan, reader()));
                    break;
                ////////////////////////////////////////
                case "arcsin":
                    System.out.println(command);
                    writer(c.calcScience(Calculator.singleOperator.asin, reader()));
                    break;
                case "arccos":
                    System.out.println(command);
                    writer(c.calcScience(Calculator.singleOperator.acos, reader()));
                    break;
                case "arctan":
                    System.out.println(command);
                    writer(c.calcScience(Calculator.singleOperator.atan, reader()));
                    break;
                // other trascendetals
                case "e":
                    System.out.println(command);
                    writer(c.calcScience(Calculator.singleOperator.eul, reader()));
                    break;
                case "pi":
                    System.out.println(command);
                    writer(c.calcScience(Calculator.singleOperator.pi, reader()));
                    break;
                case "log":
                    System.out.println(command);
                    writer(c.calcScience(Calculator.singleOperator.log, reader()));
                    break;
                case "ln":
                    System.out.println(command);
                    writer(c.calcScience(Calculator.singleOperator.logn, reader()));
                    break;

                // Equal , Clear, tmod
                case ".":
                    System.out.println(command);
                    handleDecimalPoint();
                    break;
                case "=":
                    System.out.println(command);
                    writer(c.calculateEqual(reader()));
                    clearNext = true;
                    break;
                case "C":
                    System.out.println(command);
                    writer(c.reset());
                    clearNext = true;
                    break;
                case "f(x)":
                    System.out.println(command);
                    writer(String.valueOf(command));
                    break;

                default:
                    try {
                        // handle button press and correctly append operand at the end
                        int num = Integer.parseInt(command);
                        if (clearNext) {
                            t.setText("");
                            clearNext = false;

                        }
                        t.setCaretPosition(t.getDocument().getLength());
                        t.replaceSelection(String.valueOf(num));

                    } catch (NumberFormatException ex) {
                        // handle exceptions
                    }
                    break;
            }
            t.selectAll();

        }
    }

    // my function handle decimal points could use some imprvements if i have time
    private void handleDecimalPoint() {
        if (clearNext) {
            t.setText("0.");
            clearNext = false;
        } else {
            String currentText = t.getText();
            if (!currentText.contains(".")) {
                t.setText(currentText + ".");

            }
        }
        // String currentText = t.getText();
        // if (currentText.isEmpty()) {
        // writer(0.); // Start with "0."
        // t.setText("0");
        // } else if (!currentText.contains(".")) {
        // t.setText(currentText+".");
        // }

    }

    // integrated reader
    public Double reader() {
        try {
            return Double.valueOf(t.getText());
        } catch (NumberFormatException e) {
            return 0.0;
        }

    }

    // integrated writer with trailing zero remove
    // overload writer
    public void writer(String num) {
        t.setText(num);
    }

    public void writer(final Double num) {
        if (Double.isNaN(num)) {// maybe display operator if input is NaN but operator?
            t.setText("");
        } else {
            // trailing zeros format
            DecimalFormat decimalFormat = new DecimalFormat("#.#############");
            t.setText(decimalFormat.format(num));
        }
    }

    // easter egg
    int taylor = 0;

    public void taylorMode() {
        if (taylor < 2) {
            String[] t = { "Taylor...", "Swift...", "Mode..." };
            writer(t[taylor]);
            taylor++;
        } else {
            writer("Mode...");
            try {
                URI uri = new URI("https://www.youtube.com/watch?v=8ybW48rKBME");
                Desktop desktop = Desktop.getDesktop();
                desktop.browse(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
