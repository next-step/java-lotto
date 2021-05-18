package study.calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * 문자 변환을 담당한다.
 */
public class TextParser {
    private static final String INPUT_ERROR = "올바른 값을 입력해주세요";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DELIMITER = ",|:";
    private static final int MATCHING_PART = 1;
    private static final int DELIMITER_FORMULA = 2;

    private TextParser() {
    }

    /**
     * 문자를 변환한다.
     *
     * @param text 입력된 문자
     * @return 숫자로 변환된 목록.
     */
    public static List<Integer> parseFromText(final String text) {
        if (Objects.isNull(text) || text.trim().isEmpty()) {
            return Collections.singletonList(0);
        }
        final Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.find()) {
            return getNumbersWithCustomDelimiter(matcher);
        }
        return getNumbers(text);
    }

    private static List<Integer> getNumbers(String text) {
        final String[] textNumbers = text.split(DELIMITER);
        return Arrays.stream(textNumbers).
                map(TextParser::changeToNumber)
                .collect(toList());
    }

    private static int changeToNumber(final String textNumber) {
        try {
            return Integer.parseUnsignedInt(textNumber);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException(INPUT_ERROR + e.getMessage());
        }
    }

    private static List<Integer> getNumbersWithCustomDelimiter(Matcher matcher) {
        final String delimiter = matcher.group(MATCHING_PART);
        return Stream.of(matcher.group(DELIMITER_FORMULA).split(delimiter))
                .map(String::trim)
                .map(TextParser::changeToNumber)
                .collect(toList());
    }

}
