package calculator.domain;

import calculator.enums.Operator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CalculateParameter {
    public static final List<String> OPERATORS = Operator.getOperators();
    Queue<Integer> numbers = new LinkedList<>();
    Queue<String> operators = new LinkedList<>();

    public void addNumbers(String number) {
        int parseNumber = parseNumber(number);
        addNumbers(parseNumber);
    }

    public void addNumbers(int number) {
        numbers.add(number);
    }

    public int numbersSize() {
        return numbers.size();
    }

    public void addOperators(String operator) {
        if (isOperator(operator)) {
            operators.add(operator);
        }
    }

    public int operatorsSize() {
        return operators.size();
    }

    public boolean isValidQueueSize() {
        if (numbers.size() != operators.size() + 1) {
            throw new IllegalStateException("연산이 성립되지 않습니다.");
        }
        return true;
    }

    public boolean isOperator(String operator) {
        if (!isContainOperator(operator)) {
            throw new IllegalStateException("연산자가 아닌 문자는 허용하지 않습니다.");
        }
        return true;
    }

    private boolean isContainOperator(String operator) {
        return OPERATORS.contains(operator);
    }

    public int parseNumber(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException ex) {
            throw new IllegalStateException("숫자가 아닌 문자는 허용하지 않습니다.");
        }
    }

    public String getOperator() {
        return operators.poll();
    }

    public Integer getNumber() {
        return numbers.poll();
    }

    public boolean isEmpty() {
        return numbers.isEmpty() || operators.isEmpty();
    }
}
