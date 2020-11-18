package humbledude.stringaddcalculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputParser {
    private static final String DEFAULT_SPLIT_TOKEN = ",|:";
    private static final String CUSTOM_SPLIT_TOKEN_PATTERN = "^//(.)\n(.*)$";

    private InputParser() {}

    public static List<Integer> parse(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_SPLIT_TOKEN_PATTERN)
                .matcher(input);

        if (!matcher.find()) {
            return splitInputToNumbers(DEFAULT_SPLIT_TOKEN, input);
        }

        String splitToken = matcher.group(1);
        String inputBody = matcher.group(2);
        return splitInputToNumbers(splitToken, inputBody);
    }

    private static List<Integer> splitInputToNumbers(String splitToken, String inputBody) {
        String[] strNumbers = inputBody.split(splitToken);

        return Stream.of(strNumbers)
                .map(InputParser::parseToInteger)
                .peek(InputParser::validateNumber)
                .collect(Collectors.toList());
    }

    private static Integer parseToInteger(String strNumber) {
        try {
            return Integer.valueOf(strNumber);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 이외의 문자가 입력됨");
        }
    }

    private static void validateNumber(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 지원하지 않습니다");
        }
    }

}
