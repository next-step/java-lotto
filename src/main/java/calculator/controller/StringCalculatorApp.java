package calculator.controller;

import calculator.StringCalculator;
import calculator.model.Operand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringCalculatorApp {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            printResult(StringCalculator.calculate(br.readLine()));
        } catch (IllegalArgumentException e) {
            System.out.println("invalid input");
            throw e;
        } catch (ArithmeticException e) {
            System.out.println("zero cannot be used as divisor");
            throw new IllegalArgumentException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printResult(Operand result) {
        System.out.println(result.getOperand());
    }
}
