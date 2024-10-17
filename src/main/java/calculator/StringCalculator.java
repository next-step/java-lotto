package calculator;

import calculator.util.StringUtils;

import java.util.List;
import java.util.Optional;

public class StringCalculator {
    private static final List<Operators> OPERATORS = List.of(
            new AdditionOperator(),
            new SubtractionOperator(),
            new MultiplicationOperator(),
            new DivisionOperator(),
            new RemainOperator());

    private StringCalculator() {
        throw new UnsupportedOperationException("유틸 클래스는 생성할 수 없습니다.");
    }

    public static int calculate(final String input) {
        String[] elements = getElements(input);
        int calculatedValue = toInt(elements[0]);
        for (int i = 1; i < elements.length; i = i + 2) {
            String operator = elements[i];
            calculatedValue = getOperators(operator)
                    .calculate(calculatedValue, toInt(elements[i + 1]));
        }
        return calculatedValue;
    }

    private static int toInt(final String elements) {
        return Optional.ofNullable(elements)
                .map(Integer::parseInt)
                .orElseThrow(() -> new IllegalArgumentException("숫자로 변환할 수 없습니다."));
    }

    private static Operators getOperators(final String operator) {
        return OPERATORS.stream()
                .filter(it -> it.matchOperator(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("계산할 수 없는 연산자 입니다."));
    }

    private static String[] getElements(final String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException("입력값에 null 또는 공백만 존재하여 계산을 할 수 없습니다.");
        }
        return input.split(" ");
    }
}
