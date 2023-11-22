package StringCalculator;

import java.util.ArrayList;
import java.util.List;

public class CalculateController {
    public static final int OPERATOR_INDEX_OFFSET = 1;

    public void run() {
        String[] calcaultionValues = InputView.inputCalculation();

        List<Integer> numbers = extractNumbers(calcaultionValues);
        List<Operator> operators = extractOperators(calcaultionValues);

        int sum = calculateSum(numbers, operators);
        System.out.println(sum);
    }

    private List<Integer> extractNumbers(String[] calcaultionValues) {
        List<Integer> numbers = new ArrayList<>();
        for (int index = 0; index < calcaultionValues.length; index += 2) {
            numbers.add(Integer.parseInt(calcaultionValues[index]));
        }
        return numbers;
    }

    private List<Operator> extractOperators(String[] calcaultionValues) {
        List<Operator> operators = new ArrayList<>();
        for (int index = 1; index < calcaultionValues.length; index += 2) {
            operators.add(Operator.from(calcaultionValues[index]));
        }
        return operators;
    }

    private int calculateSum(List<Integer> numbers, List<Operator> operators) {
        int sum = numbers.get(0);
        for (int index = 0; index < operators.size(); index++) {
            Operator operator = operators.get(index);
            int number = numbers.get(index + OPERATOR_INDEX_OFFSET);
            sum = operator.calculate(sum, number);
        }
        return sum;
    }
}
