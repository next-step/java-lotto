package step1;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private final List<Integer> numbers = new ArrayList<>();
    private final List<Operator> operators = new ArrayList<>();

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.init("2 + 3 * 4 / 2");
        System.out.println(calculator.compute());
    }

    public void init(String input) {
        validateInput(input);
        String[] formula = input.split(" ");
        for (String element : formula) {
            wrangleData(element);
        }
    }

    public void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("null 또는 빈 공백 문자");
        }
    }

    public void wrangleData(String element) {
        try {
            numbers.add(Integer.parseInt(element));
        } catch (NumberFormatException e) {
            operators.add(Operator.getOperator(element));
        }
    }

    public int compute() {
        int answer = 0;
        for (int idx = 0; idx < operators.size(); idx++) {
            int left = idx == 0 ? numbers.get(idx) : answer;
            Integer right = numbers.get(idx + 1);

            answer = operators.get(idx).applyAsInt(left, right);
        }

        return answer;
    }
}
