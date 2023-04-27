package domain;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    private Numbers numbers;
    private Operations operations;

    public void readExpression(String exp) throws IllegalArgumentException {
        validExpression(exp);
        numbers = new Numbers(extractNumbers(exp.split(" ")));
        operations = new Operations(extractOperation(exp.split(" ")));
    }

    private void validExpression(String exp) {
        if (exp == null || exp.isBlank()) {
            throw new IllegalArgumentException("유효한 표현식이 아닙니다.");
        }
    }

    List<Integer> extractNumbers(String[] splits) {
        List<Integer> stringNums = new ArrayList<>();

        for (int i = 0; i < splits.length; i++) {
            if (i % 2 != 0) {
                continue;
            }
            stringNums.add(toInt(splits[i]));
        }
        return stringNums;
    }

    private Integer toInt(String stringNum) {
        Integer num = null;
        try {
            num = Integer.parseInt(stringNum);
        } catch (NullPointerException | NumberFormatException e) {
            throw new IllegalArgumentException("올바른 정수 값이 아닙니다.");
        }
        return num;
    }

    List<Operation> extractOperation(String[] splits) {
        List<Operation> operation = new ArrayList<>();

        for (int i = 0; i < splits.length; i++) {
            if (i % 2 == 0) {
                continue;
            }
            operation.add(Operation.toOperation(splits[i]));
        }
        return operation;

    }


    public int calculate(Numbers numbers, Operation operation) {
        List<Integer> nextNumbers = numbers.getNextNumbers();

        if (Operation.PLUS.equals(operation)) {
            return Calculator.plus(nextNumbers.get(0), nextNumbers.get(1));
        }
        if (Operation.SUBTRACT.equals(operation)) {
            return Calculator.subtract(nextNumbers.get(0), nextNumbers.get(1));
        }
        if (Operation.DIVIDE.equals(operation)) {
            return Calculator.divide(nextNumbers.get(0), nextNumbers.get(1));
        }
        if (Operation.MULTIPLY.equals(operation)) {
            return Calculator.multiply(nextNumbers.get(0), nextNumbers.get(1));
        }

        throw new IllegalArgumentException("유효한 연산자가 아닙니다.");
    }


}

