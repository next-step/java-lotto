package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Input {

    private static final String REGEX_NUMBER = "[0-9]";
    private static final String REGEX_NOT_NUMBER = "[^0-9]";
    private static final String ARITHMETIC = "[+\\-*/]";
    private static final String BLANK = " ";
    private static final String EMPTY = "";
    private static final Pattern ARITHMETIC_PATTERN = Pattern.compile(ARITHMETIC);

    private final String text;

    public Input(String text) {
        validateEmptyOrNull(text);
        validateArithmetic(text);
        this.text = text;
    }

    public void validateEmptyOrNull(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자일 수 없습니다.");
        }
    }

    public void validateArithmetic(String text) {
        String operators = extractOperator(text);
        for (char operator : operators.toCharArray()) {
            validateOperator(Character.toString(operator));
        }
    }

    private void validateOperator(String operator) {
        Matcher matcher = ARITHMETIC_PATTERN.matcher(String.valueOf(operator));
        if (!matcher.find()) {
            throw new IllegalArgumentException("사칙연산 기호만 사용 가능합니다.");
        }
    }

    public List<Integer> extractNumber(){
        String number = text.replaceAll(REGEX_NOT_NUMBER, "");
        return Arrays.stream(number.split(EMPTY))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<String> extractOperator(){
        return Arrays.stream(extractOperator(text).split(EMPTY))
                .collect(Collectors.toList());
    }

    private String extractOperator(String text) {
        return text.replaceAll(REGEX_NUMBER, "")
                .replaceAll(BLANK, "");
    }

}
