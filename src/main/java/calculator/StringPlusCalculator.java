package calculator;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringPlusCalculator {

    private final String DEFAULT_SEPARATOR = ",|:";
    private final String REGEX = "^(\\d+)(?:[\\,\\:](\\d+))+$";
    private final Pattern INPUT_PATTERN = Pattern.compile(REGEX);

    public int calculate(String input) {

        validate(input);

        String[] result = input.split(DEFAULT_SEPARATOR);

        return Arrays.stream(result)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private void validate(String input) {
        if(!defaultMatches(input)){
            throw new IllegalArgumentException("올바르지 않은 구분자 입니다.");
        }
    }

    private boolean defaultMatches(String input){
        return INPUT_PATTERN.matcher(input).matches();
    }

}
