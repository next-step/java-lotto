package domain;

import java.util.List;

public class StringCalculator {

    private Numbers numbers;
    private Operations operations;

    void validExpression(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException("유효한 표현식이 아닙니다.");
        }
    }

    List<Integer> extractNumbers(String expression) {
        ListFactory numberListFactory = new NumberListFactory();
        List<Integer> numbers = null;
        try {
            numbers = numberListFactory.extractToList(splitByBlank(expression));
        }catch (Exception e){
            throw new IllegalArgumentException("유효한 숫자가 아닙니다.");
        }
        return numbers;
    }

    List<Operation> extractOperation(String expression) {
        ListFactory operationListFactory = new OperationListFactory();
        return operationListFactory.extractToList(splitByBlank(expression));
    }

    private String[] splitByBlank(String expression) {
        return expression.split(" ");
    }

    public int calculate() {
        int result = 0;
        while (operations.hasNext()) {
            result = calculate(numbers.getNextNumbers(), operations.next());
            numbers.add(result);
        }
        return result;
    }

    public int calculate(List<Integer> numbers, Operation operation) {

        if (Operation.PLUS.equals(operation)) {
            return Calculator.plus(numbers.get(0), numbers.get(1));
        }
        if (Operation.SUBTRACT.equals(operation)) {
            return Calculator.subtract(numbers.get(0), numbers.get(1));
        }
        if (Operation.DIVIDE.equals(operation)) {
            return Calculator.divide(numbers.get(0), numbers.get(1));
        }
        if (Operation.MULTIPLY.equals(operation)) {
            return Calculator.multiply(numbers.get(0), numbers.get(1));
        }

        throw new IllegalArgumentException("유효한 연산자가 아닙니다.");
    }


}

