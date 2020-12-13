import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class StringCalculator {
    private final List<PositiveNumber> values;

    public StringCalculator(String input) {
        values = toInteger(SplitUtils.split(input));
    }

    public int run() {
        PositiveNumber result = new PositiveNumber(0);
        for (PositiveNumber value : values) {
            result = result.add(value);
        }
        return result.getValue();
    }

    private List<PositiveNumber> toInteger(String[] split) {
        return Arrays.stream(split)
            .map(PositiveNumber::new)
            .collect(toList());
    }

    class PositiveNumber {
        private static final String REGEX_INTEGER_PATTERN = "^[0-9]+$";
        private final Pattern validPattern = Pattern.compile(REGEX_INTEGER_PATTERN);

        private int value;

        PositiveNumber(int value) {
            if (value < 0) {
                throw new IllegalArgumentException("문자열 계산기에 숫자 이외의 값 또는 음수를 전달해서는 안됩니다.");
            }
            this.value = value;
        }

        PositiveNumber(String value) {
            if (!isInteger(value)) {
                throw new IllegalArgumentException("문자열 계산기에 숫자 이외의 값 또는 음수를 전달해서는 안됩니다.");
            }
            this.value = Integer.parseInt(value);
        }

        private PositiveNumber add(PositiveNumber number) {
            return new PositiveNumber(value + number.value);
        }

        private boolean isInteger(String value) {
            return validPattern.matcher(value).find();
        }

        private int getValue() {
            return value;
        }
    }
}
