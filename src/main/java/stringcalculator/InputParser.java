package stringcalculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputParser {

    private static final String INPUT_EMPTY = "";
    private static final String DEFAULT_OUTPUT = "0";
    public static final String CUSTOMIZED_DELIMITER_REGEX = "//(.)\n(.*)";
    public static final String NORMAL_DELIMITER_REGEX = "[,:]";
    public static final int DELIMITER_GROUP_IDEX = 1;
    public static final int NUMBERS_GROUP_INDEX = 2;

    private InputParser() {
        throw new AssertionError("InputParser 클래스는 객체를 생성할 수 없습니다.");
    }

    private static List<String> parseStringToStringList(String input) {
        if (input == null|| INPUT_EMPTY.equals(input)) {
            return Collections.singletonList(DEFAULT_OUTPUT);
        }

        Pattern pattern = Pattern.compile(CUSTOMIZED_DELIMITER_REGEX);
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()) {
            String customDelimiter = matcher.group(DELIMITER_GROUP_IDEX);
            String[] tokens= matcher.group(NUMBERS_GROUP_INDEX).split(customDelimiter);
            return Arrays.asList(tokens);
        }

        return Arrays.asList(input.split(NORMAL_DELIMITER_REGEX));
    }

    public static List<Integer> parseStringListToIntegerList(String input) {
        return parseStringToStringList(input).stream().map(Integer::valueOf).collect(Collectors.toList());
    }
}
