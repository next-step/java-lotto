package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final String NUMBER_REGULAR = "[0-9]";
    private static final String OPERATION_REGULAR = "[+*-/]";
    private static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_REGULAR);
    private static final Pattern OPERATION_PATTERN = Pattern.compile(OPERATION_REGULAR);


    private Numbers numbers;
    private Operators operators;
    private Integer result;

    public Calculator(String input) {
        validation(input);
        result = 0;
        numbers = new Numbers(findNumber(input));
        operators = new Operators(findOperator(input));
    }

    private void validation(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력 값이 존재하지 습니다.");
        }

        if (input.isBlank()) {
            throw new IllegalArgumentException("입력 값이 공백 입니다.");
        }
    }

    private List<Integer> findNumber(String input) {
        ArrayList<Integer> extractNumbers = new ArrayList<>();

        Matcher matcher = NUMBER_PATTERN.matcher(input);
        while (matcher.find()) {
            extractNumbers.add(Integer.parseInt(matcher.group()));
        }
        return extractNumbers;
    }

    private List<String> findOperator(String input) {
        List<String> extractOperators = new ArrayList<>();

        Matcher matcher = OPERATION_PATTERN.matcher(input);
        while (matcher.find()) {
            extractOperators.add(matcher.group());
        }
        return extractOperators;
    }

    public Integer operation() {
        result = numbers.nextAndGet();
        while (operators.next()) {
            result = operators.findOperator().calculate(result, numbers.nextAndGet());
        }
        return result;

    }
}
