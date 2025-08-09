package calculator;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static Calculator classUnderTest;

    @BeforeAll
    public static void setUp() {
        classUnderTest = new Calculator();
    }

    @DisplayName("Tests the addition function")
    @Test
    void testTwoOpOperationsAdd() {
        classUnderTest.mode = Calculator.twoOperator.add;
        classUnderTest.num1 = 5.5;
        classUnderTest.num2 = 3.0;
        assertEquals(8.5, classUnderTest.twoOpOperations());
    }


    @DisplayName("Test subtraction: 10.0 - 4.0 = 6.0")
    @Test
    void testTwoOpOperationsSubtract() {
        classUnderTest.mode = Calculator.twoOperator.subtract;
        classUnderTest.num1 = 10.0;
        classUnderTest.num2 = 4.0;
        assertEquals(6.0, classUnderTest.twoOpOperations());
}

    @DisplayName("Test multiplication: 7.0 * 3.0 = 21.0")
    @Test
    void testTwoOpOperationsMultiply() {
        classUnderTest.mode = Calculator.twoOperator.multiply;
        classUnderTest.num1 = 7.0;
        classUnderTest.num2 = 3.0;
    assertEquals(21.0, classUnderTest.twoOpOperations());
}

    @DisplayName("Test division: 20.0 / 4.0 = 5.0")
    @Test
    void testTwoOpOperationsDivide() {
        classUnderTest.mode = Calculator.twoOperator.divide;
        classUnderTest.num1 = 20.0;
        classUnderTest.num2 = 4.0;
        assertEquals(5.0, classUnderTest.twoOpOperations());
}


    @DisplayName("Test multi-operation: 2 + 3 * 6 = 20")
    @Test
    void testMultiOperation_AddThenMultiply() {
        classUnderTest.mode = Calculator.twoOperator.multiply;
        classUnderTest.num1 = 3.0;
        classUnderTest.num2 = 6.0;
        double multResult = classUnderTest.twoOpOperations();

        classUnderTest.mode = Calculator.twoOperator.add;
        classUnderTest.num1 = 2.0;
        classUnderTest.num2 = multResult;
        assertEquals(20.0, classUnderTest.twoOpOperations());
}

    @DisplayName("Test multi-operation: (10 - 2) / 2 = 4")
    @Test
    void testMultiOperation_SubtractThenDivide() {
        classUnderTest.mode = Calculator.twoOperator.subtract;
        classUnderTest.num1 = 10.0;
        classUnderTest.num2 = 2.0;
        double subResult = classUnderTest.twoOpOperations();

        classUnderTest.mode = Calculator.twoOperator.divide;
        classUnderTest.num1 = subResult;
        classUnderTest.num2 = 2.0;
        assertEquals(4.0, classUnderTest.twoOpOperations());
}

    @DisplayName("Test multi-operation: (8 / 2) + (3 * 2) = 10")
    @Test
    void testMultiOperation_DivideThenAddMultiply() {
        classUnderTest.mode = Calculator.twoOperator.divide;
        classUnderTest.num1 = 8.0;
        classUnderTest.num2 = 2.0;
        double firstPart = classUnderTest.twoOpOperations(); // 4

        classUnderTest.mode = Calculator.twoOperator.multiply;
        classUnderTest.num1 = 3.0;
        classUnderTest.num2 = 2.0;
        double secondPart = classUnderTest.twoOpOperations(); // 6

        classUnderTest.mode = Calculator.twoOperator.add;
        classUnderTest.num1 = firstPart;
        classUnderTest.num2 = secondPart;
        assertEquals(10.0, classUnderTest.twoOpOperations());
}

@DisplayName("Test division by zero throws exception")
@Test
void testDivideByZero() {
    classUnderTest.mode = Calculator.twoOperator.divide;
    classUnderTest.num1 = 10.0;
    classUnderTest.num2 = 0.0;
    assertThrows(ArithmeticException.class, () -> classUnderTest.twoOpOperations());
}


@DisplayName("Test multiplication with negative numbers")
@Test
void testMultiplyWithNegative() {
    classUnderTest.mode = Calculator.twoOperator.multiply;
    classUnderTest.num1 = -5.0;
    classUnderTest.num2 = 4.0;
    assertEquals(-20.0, classUnderTest.twoOpOperations());
}


@DisplayName("Test adding zero returns same number")
@Test
void testAddZero() {
    classUnderTest.mode = Calculator.twoOperator.add;
    classUnderTest.num1 = 7.0;
    classUnderTest.num2 = 0.0;
    assertEquals(7.0, classUnderTest.twoOpOperations());
}


}
