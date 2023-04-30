package domain;

import java.util.List;

public class StringCalculator {

    void validExpression(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException("유효한 표현식이 아닙니다.");
        }
    }

    Numbers extractNumbers(String expression) {
        ListFactory numberListFactory = new NumberListFactory();
        List<Integer> numbers = null;
        try {
            numbers = numberListFactory.extractToList(splitByBlank(expression));
        } catch (Exception e) {
            throw new IllegalArgumentException("유효한 숫자가 아닙니다.");
        }
        return new Numbers(numbers);
    }

    Operations extractOperation(String expression) {
        ListFactory operationListFactory = new OperationListFactory();
        return new Operations(operationListFactory.extractToList(splitByBlank(expression)));
    }

    private String[] splitByBlank(String expression) {
        return expression.split(" ");
    }

    public int calculate(Numbers numbers, Operations operations) {
        int result = 0;
        while (operations.hasNext()) {
            Operator operator = operations.next();
            result = operator.calculate(numbers.getNextNumbers());
            numbers.add(result);
        }
        return result;
    }
}

