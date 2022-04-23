package calculator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCalculator {
    private static final int START_NUMBER = 0;
    private static final int CHECK_NUMBER_LIST_SIZE = 2;
    private static final int CHECK_NUMBER_LIST_OPERATOR_LIST_GAP = 1;
    private static final String SPACE = " ";
    private static final String DECIMAL_POINT_PATTERN = "\\.";
    private static final Map<String, BiFunction<Double, Double, Double>> OPERATORS = new HashMap<>();

    static {
        OPERATORS.put("+", (num1, num2) -> num1 + num2);
        OPERATORS.put("-", (num1, num2) -> num1 - num2);
        OPERATORS.put("*", (num1, num2) -> num1 * num2);
        OPERATORS.put("/", (num1, num2) -> {
            if (Double.isInfinite(num1 / num2)) {
                throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
            }
            return num1 / num2;
        });
    }

    public static double calculate(String operator, double num1, double num2) {
        return OPERATORS.get(operator).apply(num1, num2);
    }

    public static double input(String s) {
        checkNullAndEmpty(s);
        List<String> stringList = stringArrayToList(s);
        List<Double> numberList = toNumberList(stringList);
        List<String> operators = toOperatorList(stringList);

        return result(numberList, operators);
    }

    private static double result(List<Double> numberList, List<String> operators) {
        validateNumberListAndOperations(numberList, operators);
        double total = numberList.get(START_NUMBER);

        for (int i = START_NUMBER; i < operators.size(); i++) {
            total = calculate(operators.get(i), total, numberList.get(i + 1));
        }

        return total;
    }

    private static void validateNumberListAndOperations(List<Double> numberList, List<String> operations) {
        if (!(numberList.size() - CHECK_NUMBER_LIST_OPERATOR_LIST_GAP == operations.size())) {
            throw new IllegalArgumentException("숫자 개수와 연산자 개수 차이는 1개여야 합니다.");
        }
    }

    private static List<String> toOperatorList(List<String> stringList) {
        List<String> toOperator = IntStream.range(START_NUMBER, stringList.size())
                .filter(i -> i % 2 != 0)
                .mapToObj(stringList::get)
                .filter(StringCalculator::checkOperator)
                .collect(Collectors.toList());

        validateOperators(toOperator);
        return toOperator;
    }

    private static void validateOperators(List<String> toOperator) {
        checkOperationsNullAndEmpty(toOperator);
    }

    private static void checkOperationsNullAndEmpty(List<String> toOperation) {
        if (toOperation == null || toOperation.isEmpty()) {
            throw new IllegalArgumentException("사칙연산 기호가 없습니다.");
        }
    }

    private static boolean checkOperator(String operator) {
        if (!OPERATORS.containsKey(operator)) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
        return true;
    }

    private static boolean checkNumberIndex(String s) {
        if (!s.replaceAll(DECIMAL_POINT_PATTERN, "")
                .chars()
                .allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("띄어쓰기를 기준으로 홀수 자리엔 숫자밖에 올 수 없습니다.");
        }
        return true;
    }

    private static List<Double> toNumberList(List<String> stringList) {
        List<Double> numberList = IntStream.range(START_NUMBER, stringList.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(stringList::get)
                .filter(StringCalculator::checkNumberIndex)
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        validateNumberList(numberList);
        return numberList;
    }

    private static void validateNumberList(List<Double> numberList) {
        if (numberList.size() < CHECK_NUMBER_LIST_SIZE) {
            throw new IllegalArgumentException("숫자는 최소 2개 이상 입력해야 합니다.");
        }
    }

    private static List<String> stringArrayToList(String s) {
        return Arrays.stream(s.split(SPACE))
                .collect(Collectors.toList());
    }

    private static void checkNullAndEmpty(String s) {
        if (s == null || s.isEmpty()) {
            throw new NullPointerException("공백이나 빈 문자는 입력할 수 없습니다.");
        }
    }

}
