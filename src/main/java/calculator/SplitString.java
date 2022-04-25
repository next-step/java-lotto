package calculator;

import java.util.List;
import java.util.stream.IntStream;

public class SplitString {
    private static final String BLANK_DELIMITER = " ";
    private static final List<String> OPERATOR = List.of("+", "-", "*", "/");

    private SplitString() {
    }

    public static List<String> split(String text) {
        if (isBlank(text)) {
            throw new IllegalArgumentException("입력 문자열은 비어있을 수 없습니다.");
        }
        List<String> elements = split(text, BLANK_DELIMITER);
        validateElement(elements);
        return elements;
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static List<String> split(String text, String delimiter) {
        return List.of(text.split(delimiter));
    }

    private static void validateElement(List<String> elements) {
        IntStream.range(0, elements.size()).forEach(index -> {
            if (index % 2 == 0 && !isDigit(elements.get(index))) {
                throw new IllegalArgumentException("숫자가 아닙니다.");
            }
            if (index % 2 == 1 && !isOperator(elements.get(index))) {
                throw new IllegalArgumentException("연산자가 아닙니다.");
            }
        });
    }

    private static boolean isDigit(String value) {
        return value.chars().allMatch(Character::isDigit);
    }

    private static boolean isOperator(String value) {
        return OPERATOR.contains(value);
    }
}
