package domain;

import java.util.List;

public class StringCalculator {

    void validExpression(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException("유효한 표현식이 아닙니다.");
        }
    }

    Numbers extractNumbers(String expression) {
        CalculatorTokenFactory numberListFactory = new NumbersFactory();
        List<Integer> numbers = null;
        try {
            numbers = numberListFactory.extractList(splitByBlank(expression));
        } catch (Exception e) {
            throw new IllegalArgumentException("유효한 숫자가 아닙니다.");
        }
        return new Numbers(numbers);
    }

    Operations extractOperation(String expression) {
        CalculatorTokenFactory operationListFactory = new OperatorFactory();
        return new Operations(operationListFactory.extractList(splitByBlank(expression)));
    }

    private String[] splitByBlank(String expression) {
        return expression.split(" ");
    }

    public int calculate(Numbers numbers, Operations operations) {
        int result = 0;
        while (operations.hasNext()) {
            Operator operator = operations.next();
            Integer left = numbers.getNextNumber();
            Integer right = numbers.getNextNumber();
            result = operator.calculate(left, right);

            numbers.add(result);
        }
        return result;
    }
}

