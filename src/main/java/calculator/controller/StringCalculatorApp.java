package calculator.controller;

import calculator.StringCalculator;
import calculator.model.Operand;

import java.util.Scanner;

public class StringCalculatorApp {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            printResult(StringCalculator.calculate(sc.next()));
        } catch (IllegalArgumentException e) {
            System.out.println("invalid input");
            throw e;
        }
    }

    private static void printResult(Operand result) {
        System.out.println(result.getOperand());
    }
}
