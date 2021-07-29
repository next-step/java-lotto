package calculators;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {

    private final Pattern pattern = Pattern.compile("//(.)\n(.*)");
    private final String COMMA = ",";
    private final String COLON = ":";

    public Integer calculate(String input) {
        List<Integer> numbers = splitNumbers(input);
        return numbers.stream().reduce(0, Integer::sum);
    }

    private List<Integer> splitNumbers(String text) {
        String separator = COLON;

        Matcher matcher = pattern.matcher(text);
        String input = text;

        if (matcher.matches()) {
            separator = matcher.group(1);
            input = matcher.group(2);
        }

        input = input.replaceAll(separator, COMMA);
        String[] separatedInputs = input.split(COMMA);

        checkValidInput(separatedInputs);

        return Arrays.stream(separatedInputs)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void checkValidInput(String[] inputs) {
        checkExistCharacter(inputs);
        checkExistNegative(inputs);
    }

    private void checkExistCharacter(String[] inputs) {
        boolean isExistCharacter = Arrays.stream(inputs)
                .noneMatch(this::isNumber);
        if (isExistCharacter) {
            throw new RuntimeException("문자는 존재할 수 없습니다.");
        }
    }

    private void checkExistNegative(String[] inputs) {
        boolean isExistNegative = Arrays.stream(inputs)
                .map(Integer::parseInt)
                .anyMatch(r -> r < 0);
        if (isExistNegative) {
            throw new RuntimeException("음수는 존재할 수 없습니다.");
        }
    }

    private boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
