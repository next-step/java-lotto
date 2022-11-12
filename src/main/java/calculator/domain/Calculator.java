package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<String> inputList;

    public Calculator() {

    }

    public Calculator(List<String> inputList) {
        this.inputList = new ArrayList<>(inputList);
    }

    public int run() {
        while (inputList.size() != 1) {
            inputList.add(0, calculate(inputList.remove(0), inputList.remove(0), inputList.remove(0)));
        }
        return Integer.parseInt(inputList.get(0));
    }

    private String calculate(String left, String operator, String right) {
        if (operator.equals("+")) {
            return String.valueOf(sum(left, right));
        }

        if (operator.equals("-")) {
            return String.valueOf(minus(left, right));
        }

        if (operator.equals("*")) {
            return String.valueOf(multiply(left, right));
        }

        if (operator.equals("/")) {
            return String.valueOf(divide(left, right));
        }

        throw new IllegalArgumentException("알수 없는 사칙연산 기호 입니다.");
    }

    private int sum(String left, String right) {
        return Integer.parseInt(left) + Integer.parseInt(right);
    }

    private int minus(String left, String right) {
        return Integer.parseInt(left) - Integer.parseInt(right);
    }

    private int multiply(String left, String right) {
        return Integer.parseInt(left) * Integer.parseInt(right);
    }

    private int divide(String left, String right) {
        return Integer.parseInt(left) / Integer.parseInt(right);
    }
}
