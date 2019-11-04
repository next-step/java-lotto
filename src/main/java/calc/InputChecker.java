package calc;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputChecker {

    private static final String ILLEGAL_INPUT = "음수가 입력되었습니다.";
    private static final String DEFAULT_INPUT_DELIMETER = ",|:";
    private static final String CUSTOM_INPUT_DELIMETER_START = "//";
    private static final String CUSTOM_INPUT_DELIMETER_END = "\n";
    private static final Pattern INPUT_DELIMETER_PATTERN = Pattern
        .compile(CUSTOM_INPUT_DELIMETER_START + "(.)" + CUSTOM_INPUT_DELIMETER_END + "(.*)");
    private final List<Integer> numbers;

    public InputChecker(String input) {
        this.numbers = checkInput(input);
    }

    private List<Integer> checkInput(String input) {
        if (Objects.isNull(input) || input.equals("")) {
            return Arrays.asList(0);
        }

        Matcher inputMatcher = INPUT_DELIMETER_PATTERN.matcher(input);
        if (inputMatcher.find()) {
            String customDelimeter = inputMatcher.group(1);
            return convertInputWithDelimeter(inputMatcher.group(2), customDelimeter);
        }

        return convertInputWithDelimeter(input, DEFAULT_INPUT_DELIMETER);
    }

    private List<Integer> convertInputWithDelimeter(String input,
        String delimeter) {
        Stream<Integer> numbersStream = Arrays.stream(input.split(delimeter))
                                              .map(Integer::parseInt);
        if (numbersStream.anyMatch(integer -> integer < 0)) {
            throw new IllegalArgumentException(ILLEGAL_INPUT);
        }

        return numbersStream.collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
