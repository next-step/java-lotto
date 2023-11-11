package stringcalculator;

import java.util.Arrays;
import java.util.function.DoubleBinaryOperator;

public class Calculator {

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLICATION = "*";
    private static final String DIVISION = "/";

    private double number;

    public Calculator() {
    }

    public Calculator(double number) {
        this.number = number;
    }

    public static boolean isOperationSymbol(String symbol) {
        return Arrays.asList(PLUS, MINUS, MULTIPLICATION, DIVISION).contains(symbol);
    }

    public double calculateBy(String symbol, double nextNum) {
        if (isPlus(symbol)) {
            return calculateBy(((a, b) -> a + b), number, nextNum);
        }

        if (isMinus(symbol)) {
            return calculateBy(((a, b) -> a - b), number, nextNum);
        }

        if (isMultiplication(symbol)) {
            return calculateBy(((a, b) -> a * b), number, nextNum);
        }

        if (isDivision(symbol)) {
            return calculateBy(((a, b) -> a / b), number, nextNum);
        }

        throw new IllegalArgumentException("해당하는 연산 기호가 없습니다.");
    }

    private double calculateBy(DoubleBinaryOperator intBinaryOperator, double left, double right) {
        return intBinaryOperator.applyAsDouble(left, right);
    }

    private boolean isPlus(String numAndSymbol) {
        return PLUS.equals(numAndSymbol);
    }

    private boolean isMinus(String numAndSymbol) {
        return MINUS.equals(numAndSymbol);
    }

    private boolean isMultiplication(String numAndSymbol) {
        return MULTIPLICATION.equals(numAndSymbol);
    }

    public boolean isDivision(String numAndSymbol) {
        return DIVISION.equals(numAndSymbol);
    }
}
