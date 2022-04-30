package stringcalculator;

import java.util.regex.Pattern;

public class Calculation {
    private Operator operator;
    private int firstOperand;
    private int secondOperand;

    private Calculation(String operator, String firstOperand, String secondOperand) {
        this.operator = new Operator(operator);
        this.firstOperand = Integer.parseInt(firstOperand);
        this.secondOperand = Integer.parseInt(secondOperand);
    }

    public static Calculation of(String operator, String firstOperand, String secondOperand) {
        return new Calculation(operator, firstOperand, secondOperand);
    }

    public String calculate() {
        if (Operator.isAddition(this.operator)) {
            return add(this.firstOperand, this.secondOperand);
        }

        if (Operator.isSubtraction(this.operator)) {
            return subtract(this.firstOperand, this.secondOperand);
        }

        if (Operator.isMultiplication(this.operator)) {
            return multiply(this.firstOperand, this.secondOperand);
        }

        return divide(this.firstOperand, this.secondOperand);
    }

    static String add(int a, int b) {
        return String.valueOf(a + b);
    }

    static String subtract(int a, int b) {
        return String.valueOf(a - b);
    }

    static String multiply(int a, int b) {
        return String.valueOf(a * b);
    }

    static String divide(int a, int b) {
        return String.valueOf(a / b);
    }
}
