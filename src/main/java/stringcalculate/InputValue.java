package stringcalculate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputValue {
    private static final String BLANK = "\\s";
    private static final Pattern FILTER = Pattern.compile("^([0-9\\-+*/\\s]+)$");
    private static final Pattern OPERATOR = Pattern.compile("^[+/*-]$");
    private final List<String> operators;

    private final List<Integer> numbers;

    public InputValue(String input) {
        validateInput(input);
        this.numbers = createNumbers(input);
        this.operators = crateOperators(input);
    }

    private void validateInput(String input) {
        validateSpacial(input);
        validateBlank(input);
        validateEmpty(input);
    }

    private static void validateSpacial(String input) {
        if (!FILTER.matcher(input).matches()) {
            throw new WrongInputException("사칙연산 기호, 숫자, 앞의 둘을 포함한 공백외에는 입력 받을 수 없습니다.");
        }
    }

    private static void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new WrongInputException("빈 값은 입력 받을  수 없습니다.");
        }
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new WrongInputException("값이 없는 빈 공백은 입력 받을 수 없습니다.");
        }
    }

    private List<String> crateOperators(String input) {

        return Arrays
                .stream(splitInput(input))
                .filter(i -> OPERATOR.matcher(i).matches())
                .collect(Collectors.toList());
    }

    private List<Integer> createNumbers(String input) {

        return Arrays
                .stream(splitInput(input))
                .filter(i -> !OPERATOR.matcher(i).matches())
                .mapToInt(pareInt())
                .boxed()
                .collect(Collectors.toList());
    }

    private static ToIntFunction<String> pareInt() {
        return i -> {
            return checkInteger(i);
        };
    }

    private static int checkInteger(String i) {
        try {
            return Integer.parseInt(i);
        } catch (Exception e) {
            throw new WrongInputException("정수만 입력이 가능합니다.");
        }
    }

    private String[] splitInput(String input) {
        return input.split(BLANK);
    }

    public List<String> getOperators() {
        return Collections.unmodifiableList(operators);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

}
