package calculator;

/**
 * This class takes care of the brains of the calculator by enumerating the
 * actions, and using a constructor that returns the appropriately enumerated command,
 * which allows us to split into two operator and one operator calculations, then using the
 * .operand allows us to do the actual calculation and return the right values.
 * Additional math functions can easily be added here. 
 * @author Soria, Steckler, Tesic, Metsis
 */
public class Calculator{

	public enum twoOperator {
		normal, add, subtract, multiply, divide
	}

	public enum singleOperator { //custom added operators asin,acos,atan,eul,pi,log,logn,abs,fact
		square, squareRoot, oneDevidedBy, cos, sin, tan,asin,acos,atan,eul,pi,log,logn,abs,fact
	}

	public Double num1, num2;
	public twoOperator mode = twoOperator.normal;

	/**
	 * The final call in enumeration that returns the specificed operation result
	 * @return returns the called operation's result
	 */
	public Double twoOpOperations() {
		if (mode == twoOperator.normal) {
			return num2;
		}
		if (mode == twoOperator.add) {
			return num1 + num2;
		}
		if (mode == twoOperator.subtract) {
			return num1 - num2;
		}
		if (mode == twoOperator.multiply) {
			return num1 * num2;
		}
		if (mode == twoOperator.divide) {

				if(num2==0){
					System.out.println("Woops, division by 0");
					throw new ArithmeticException("Cant divide by 0.");
				}
				return num1 / num2;
		}
		// never reach
		throw new Error(); 
	}

	/**
	 * Handles = operand, and calls Primitives if not = operand, updates the number parameters and returns as necessary
	 * if normal displays the buffer and clears the proper num values
	 * @param newMode  the method of operation being passed
	 * @param num the number being calculated
	 * @return
	 */
	public Double twoOpCaller(twoOperator newMode, Double num) {
		if (mode == twoOperator.normal) {
			num2 = 0.0;
			num1 = num;
			mode = newMode;
			return Double.NaN;
		} else {
			num2 = num;
			num1 = twoOpOperations();
			mode = newMode;
			return num1;
		}
	}

	/**
	 * The caller for equal to determine if Primitives or =
	 * @param num the number passed from the calculator
	 * @return
	 */
	public Double calculateEqual(Double num) {
		return twoOpCaller(twoOperator.normal, num);
	}

	/**
	 * Clears all numbers and text from the calculator
	 * @return
	 */
	public Double reset() {
		num2 = 0.0;
		num1 = 0.0;
		mode = twoOperator.normal;

		return Double.NaN;
	}

	/**
	 * Caller function that passes the mode for a single operator function, and returns the proper value
	 * depending on which math button newMode is pressed for Squared, square root, 1/x, cos, sin, tan
	 * @param newMode determines the operation type
	 * @param num the number as input from buttons
	 * @return
	 */
	public Double calcScience(singleOperator newMode, Double num) {
		// VANILLA OPERATORS PROVIDED
		if (newMode == singleOperator.square) {
			return num * num;
		}
		if (newMode == singleOperator.squareRoot) {
			return Math.sqrt(num);
		}

		if (newMode == singleOperator.oneDevidedBy) {
			return 1 / num;
		}

		if (newMode == singleOperator.cos) {
			return Math.cos(num);
		}
		if (newMode == singleOperator.sin) {
			return Math.sin(num);
		}
		if (newMode == singleOperator.tan) {
			return Math.tan(num);
		}
		//////////////////////////////////////
		// ADDED CUSTOM OPERATORS
		/////////// asin,acos,atan //////////
		if (newMode == singleOperator.asin) {
			return Math.asin(num);
		}
		if (newMode == singleOperator.acos) {
			return Math.acos(num);
		}
		if (newMode == singleOperator.atan) {
			return Math.atan(num);
		}
		//////////////////////////////////////
		///////  e,pi,log,ln ////////////////
		//////////////////////////////////////
		if (newMode == singleOperator.eul) {
			return Math.E;
		}
		if (newMode == singleOperator.pi) {
			return Math.PI;
		}
		if (newMode == singleOperator.log) {
			return Math.log10(num);// log
		}
		if (newMode == singleOperator.logn) {
			return Math.log(num); // natural log base e
		}
		//////////////////////////////////////
		////// abs , fact, taylor/////////////
		//////////////////////////////////////
		if (newMode == singleOperator.abs) {
			return Math.abs(num);//|x|
		}
		if (newMode == singleOperator.fact) {

			return fact(num);
		}
		// never reach
		throw new Error();
	}
	// quick factorial method 
	static double fact(double n){
		if(n==0){
			return 1;
		}return n* fact(n-1);
	}


}
