
/**
 * Main runner that initializes and runs the UI
 *
 * Special Notes:
 *
 * Pressing a single operator button will immediately display the result without pressing "="
 * After pressing an operand, sometimes the first button press immediately after will not register
 * By using a list/array button implementation generation, you limit the flexibility in positioning
 * the buttons
 *
 * @author Soria, Steckler, Tesic, Metsis
 * @Modified Eugenio Montealegre
 */

import javax.swing.SwingUtilities;

import calculator.*;

public class GraphingCalculatorMain {
	public static void main(String[] args) {

		SwingUtilities.invokeLater(()-> {
			Calculator calculator = new Calculator();
			new CalculatorUI(calculator);
		}); //modified
			
			
		// 	new CalculatorUI(calculator));
		// Calculator calculator = new Calculator();
		// CalculatorUI uiCal = new CalculatorUI(calculator);
		// uiCal.init();
		// ready to final commit

	}
}
