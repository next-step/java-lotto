package calculator;

import calculator.controller.CalculatorController;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CalculatorController.of(new Scanner(System.in), System.out).calculate();
    }
}
