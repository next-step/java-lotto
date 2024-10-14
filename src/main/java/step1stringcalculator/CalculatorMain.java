package step1stringcalculator;

import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        String calculatorString = InputView.insertCalculatorString(scanner);

    }
}
