import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    private static final String FORMULA_REGEX = "^[0-9+\\-*/\\s]+$";
    private static List<BasicOperator> operations = new ArrayList<>();
    private static List<Integer> numbers = new ArrayList<>();
    private static int calculationResult;

    public static int calculate(String formula) {
        validateFormula(formula);
        preprocess(formula);
        return calculate();
    }

    private static int calculate() {
        for (int i = 1; i < numbers.size(); i++) {
            BasicOperator operator = operations.get(i - 1);
            int number = numbers.get(i);
            calculationResult = operator.apply(calculationResult, number);
        }
        return calculationResult;
    }

    private static void preprocess(String formula) {
        String[] strings = formula.split(" ");
        operations = extractOperator(strings);
        numbers = extractNumbers(strings);
        calculationResult = numbers.get(0);
    }

    private static List<Integer> extractNumbers(String[] nums) {
        return Arrays.stream(nums)
                .filter(str -> !BasicOperator.hasOperator(str))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static List<BasicOperator> extractOperator(String[] nums) {
        return Arrays.stream(nums)
                .filter(BasicOperator::hasOperator)
                .map(BasicOperator::find)
                .collect(Collectors.toList());
    }

    private static void validateFormula(String formula) {
        if (formula == null || !formula.matches(FORMULA_REGEX)) {
            throw new IllegalArgumentException("숫자와 사칙연산 기호만이 입력 되어야 합니다.");
        }
    }
}
