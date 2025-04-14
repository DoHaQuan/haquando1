package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    static CalculatorTest createCalculatorTest() {
        return new CalculatorTest();
    }

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after multiplicating two positive multi-digit numbers")
    void TestPositiveMultiplication() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();
        String expected = "400";
        String actual = calc.readScreen();
        assertEquals(expected, actual);

    }


    // grüner Test
    @Test
    @DisplayName("will display the result after subtracting two positive multi-digit numbers")
    void testSubtraction() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();
        String expected = "18";
        String actual = calc.readScreen();
        assertEquals(expected, actual);

    }


    @Test
    @DisplayName("should display Error after pressing square root of negative number")
    void testSquareRootOfNegativeNumber() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(9);
        calc.pressNegativeKey();       // tạo số âm: -9
        calc.pressUnaryOperationKey("√"); // bấm căn bậc hai

        String expected = "Error";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should ignore second dot key press")
    void testIgnoreSecondDot() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(4);
        calc.pressDotKey();      // Lần đầu tiên -> thêm dấu .
        calc.pressDigitKey(2);   // 4.2
        calc.pressDotKey();      // Lần thứ hai -> không được thêm

        String expected = "4.2";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }


    // Roter Test
    @Test
    @DisplayName("should show Error when pressing 1/x with 0 on screen")
    void testInverseOfZeroShowsError() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(0);
        calc.pressUnaryOperationKey("1/x");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual); //
    }

    // Roter Test
    @Test
    @DisplayName("should show the squared result after pressing the squared number? ")
    void TestSquaredResult() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressUnaryOperationKey("x²");

        String expected = "400.0";
        String actual = calc.readScreen();
        assertEquals(expected, actual);


    }
}








