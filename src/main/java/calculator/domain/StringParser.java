package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {

    private static final String ERROR_INVALID_NUMBER = "ERROR : 0 이상의 숫자만 계산할 수 있습니다.";
    private static final int MINIMUM_LIMIT = 0;

    private StringParser() {
    }

    public static List<Integer> parseString(String userInput) {
        String[] stringTokens = StringSplitter.splitString(userInput);
        return Arrays.stream(stringTokens)
                .map(StringParser::parseIntAndValidate)
                .collect(Collectors.toList());
    }

    private static Integer parseIntAndValidate(String string) {
        Integer number = Integer.parseInt(string);
        if (number < MINIMUM_LIMIT)
            throw new InvalidNumberException(ERROR_INVALID_NUMBER);
        return number;
    }
}
