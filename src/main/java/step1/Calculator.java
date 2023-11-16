package step1;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private final List<Integer> numbers = new ArrayList<>();
    private final List<Operator> operators = new ArrayList<>();

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.init("2 + 3 * 4 / 2");
    }

    public void init(String input) {
        validateInput(input);
        String[] formula = input.split(" ");
        for (String element : formula) {
            parseData(element.charAt(0));
        }
        validateFormula();

        System.out.println(compute());
    }

    protected void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("null 또는 빈 공백 문자");
        }
    }

    // 숫자의 개수는 항상 기호보다 많아야한다.
    // 숫자의 개수는 기호보다 항상 1 크다.
    protected void validateFormula() {
        boolean firstRule = numbers.size() > operators.size();
        boolean secondRule = numbers.size() == operators.size() + 1;
        if (!firstRule || !secondRule) {
            throw new IllegalArgumentException("잘 못된 수식입니다.");
        }
    }

    protected void parseData(Character element) {
        if (Character.isDigit(element)) {
            numbers.add(Integer.parseInt(String.valueOf(element)));
            return;
        }

        operators.add(Operator.getOperator(String.valueOf(element)));
    }

    protected int compute() {
        int answer = 0;
        for (int idx = 0; idx < operators.size(); idx++) {
            answer = operators.get(idx)
                              .applyAsInt(getLeft(idx, answer), getRight(idx));
        }

        return answer;
    }

    private int getLeft(int idx, int answer) {
        if (idx == 0) {
            return numbers.get(idx);
        }

        return answer;
    }

    private int getRight(int idx) {
        return numbers.get(idx + 1);
    }
}
