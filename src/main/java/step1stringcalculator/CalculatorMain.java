package step1stringcalculator;

import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String calculatorString = InputView.insertCalculatorString(scanner);
        Calculator calculator = new Calculator(calculatorString);
        calculator.checkCalculateString();
        int resultNumber = calculator.calculate();
        PrintView.printResultCalculatedNumber(resultNumber);
    }
}
