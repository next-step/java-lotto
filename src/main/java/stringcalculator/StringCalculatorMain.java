package stringcalculator;

import stringcalculator.io.StringCalculatorInput;

import java.util.Scanner;

public class StringCalculatorMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(StringCalculatorController.calculate(StringCalculatorInput.input(" ")));
    }
}
