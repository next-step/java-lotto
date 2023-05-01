import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;

public class Calculator {
    private final LinkedList<String> inputValue;

    private IntConverter intConverter;

    private int answer;

    public Calculator(LinkedList<String> queue) {
        this.inputValue = queue;
        this.intConverter = new IntConverter();
        this.answer = 0;
    }

    public static Calculator of(String inputVal) {
        isValid(inputVal);
        String[] result = inputVal.split(" ");
        LinkedList<String> queue = new LinkedList<>();
        Collections.addAll(queue, result);
        return new Calculator(queue);
    }

    private static void isValid(String inputVal) {
        if (Objects.isNull(inputVal)
            || Objects.equals("", inputVal)
            || Objects.equals(" ", inputVal)) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다.");
        }
    }

    public int calculate() {
        String start = inputValue.remove();
        if (intConverter.isConvertibleToInt(start)) {
            answer = intConverter.convertStringToInt(start);
        }
        while (inputValue.size() > 0) {
            calculateByOperator();
        }
        return answer;
    }

    private void calculateByOperator() {
        String operator = inputValue.remove();
        if (intConverter.isConvertibleToInt(operator)) {
            throw new IllegalArgumentException("값이 잘못 입력되었습니다.");
        }
        performAddition(operator);
        performSubtraction(operator);
        performMultiplication(operator);
        performDivision(operator);
    }

    private void performAddition(String operator) {
        if (Objects.equals(operator, "+")) {
            answer += intConverter.convertStringToInt(inputValue.remove());
        }
    }

    private void performSubtraction(String operator) {
        if (Objects.equals(operator, "-")) {
            answer -= intConverter.convertStringToInt(inputValue.remove());
        }
    }

    private void performMultiplication(String operator) {
        if (Objects.equals(operator, "*")) {
            answer *= intConverter.convertStringToInt(inputValue.remove());
        }
    }

    private void performDivision(String operator) {
        if (Objects.equals(operator, "/")) {
            answer /= intConverter.convertStringToInt(inputValue.remove());
        }
    }

}
