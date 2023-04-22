package calculator;

import java.util.List;

public class Calculator {
    private final Expression expression;

    public Calculator(String expression) {
        this.expression = new Expression(expression);
    }

    public int add() {
        List<String> element = expression.parseToList();

        int beforeOperation = 0;
        boolean addition = false;
        for (String s : element) {
            if (addition) {
                beforeOperation = beforeOperation + Integer.parseInt(s);
                addition = false;
                continue;
            }
            if (s.equals("+")) {
                addition = true;
                continue;
            }
            beforeOperation = Integer.parseInt(s);
        }
        return beforeOperation;
    }

    public int substract() {
        List<String> element = expression.parseToList();
        int beforeOperation = 0;
        boolean substraction = false;
        for (String s : element) {
            if (substraction) {
                beforeOperation = beforeOperation - Integer.parseInt(s);
                substraction = false;
                continue;
            }
            if (s.equals("-")) {
                substraction = true;
                continue;
            }
            beforeOperation = Integer.parseInt(s);
        }
        return beforeOperation;
    }

    public int multiply() {
        List<String> element = expression.parseToList();
        int beforeOperation = 0;
        boolean multiplication = false;
        for (String s : element) {
            if (multiplication) {
                beforeOperation *= Integer.parseInt(s);
                multiplication = false;
                continue;
            }
            if (s.equals("*")) {
                multiplication = true;
                continue;
            }
            beforeOperation = Integer.parseInt(s);
        }
        return beforeOperation;
    }

    public int divide() {
        List<String> element = expression.parseToList();
        int beforeOperation = 0;
        boolean division = false;
        for (String s : element) {
            if (division) {
                double floatNum = (double) beforeOperation / Integer.parseInt(s);
                beforeOperation = beforeOperation / Integer.parseInt(s);
                if (floatNum != beforeOperation) {
                    throw new ArithmeticException("나누어 떨어지지 않는 값을 입력하셨습니다.");
                }
                division = false;
                continue;
            }
            if (s.equals("/")) {
                division = true;
                continue;
            }
            beforeOperation = Integer.parseInt(s);
        }
        return beforeOperation;
    }

    public int calculate() {
        List<String> element = expression.parseToList();
        int beforeOperation = 0;
        boolean division = false;
        boolean multiplication = false;
        boolean addition = false;
        boolean substraction = false;
        for (String s : element) {
            if (addition) {
                beforeOperation = beforeOperation + Integer.parseInt(s);
                addition = false;
                continue;
            }
            if (substraction) {
                beforeOperation = beforeOperation - Integer.parseInt(s);
                substraction = false;
                continue;
            }
            if (multiplication) {
                beforeOperation *= Integer.parseInt(s);
                multiplication = false;
                continue;
            }
            if (division) {
                double floatNum = (double) beforeOperation / Integer.parseInt(s);
                beforeOperation = beforeOperation / Integer.parseInt(s);
                if (floatNum != beforeOperation) {
                    throw new ArithmeticException("나누어 떨어지지 않는 값을 입력하셨습니다.");
                }
                division = false;
                continue;
            }
            if (s.equals("+")) {
                addition = true;
                continue;
            }
            if (s.equals("-")) {
                substraction = true;
                continue;
            }
            if (s.equals("*")) {
                multiplication = true;
                continue;
            }
            if (s.equals("/")) {
                division = true;
                continue;
            }
            beforeOperation = Integer.parseInt(s);
        }
        return beforeOperation;
    }


}
