package calculator.domain;

import calculator.enums.Operator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CalculateParameter {
    public static final String SPACE = " ";
    Queue<Integer> numbers = new LinkedList<>();
    Queue<String> operators = new LinkedList<>();

    public int operatorsSize() {
        return operators.size();
    }

    public int numbersSize() {
        return numbers.size();
    }

    public boolean validateQueueSize() {
        if (numbers.size() != operators.size() + 1) {
            throw new IllegalStateException("연산이 성립되지 않습니다.");
        }
        return true;
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

    public List<String> split(String text) {
        if (isBlank(text)) {
            throw new IllegalStateException("문자열이 비어있습니다.");
        }
        return List.of(text.split(SPACE));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    public void makeParameter(String text) {
        List<String> splitText = split(text);
        addSplitTexts(splitText);
    }

    private void addSplitTexts(List<String> splitText) {
        for (int i = 0; i < splitText.size(); i++) {
            addQueue(i, splitText);
        }
    }

    private void addQueue(int index, List<String> splitText) {
        if (isEven(index)) {
            addNumbers(splitText.get(index));
        }
        if (isOdd(index)) {
            addOperators(splitText.get(index));
        }
    }

    private static boolean isOdd(int i) {
        return i % 2 == 1;
    }

    private boolean isEven(int i) {
        return i % 2 == 0;
    }


    public void addNumbers(String number) {
        int parseNumber = parseNumber(number);
        addNumbers(parseNumber);
    }

    public int parseNumber(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException ex) {
            throw new IllegalStateException("숫자가 아닌 문자는 허용하지 않습니다.");
        }
    }

    public void addNumbers(int number) {
        numbers.add(number);
    }

    public void addOperators(String operator) {
        if (isOperator(operator)) {
            operators.add(operator);
        }
    }
    public boolean isOperator(String operator) {
        if (!isContainOperator(operator)) {
            throw new IllegalStateException("연산자가 아닌 문자는 허용하지 않습니다.");
        }
        return true;
    }

    private boolean isContainOperator(String operator) {
        return Operator.getOperators().contains(operator);
    }

}
