package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final Pattern POSITIVE_NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
    private static final String SPLIT_REGEX = ",|:";

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }
        if (isPatternDelimiter(text)){
            return addStringArray(splitPatternDelimiter(text));
        }
        return addStringArray(text.split(SPLIT_REGEX));
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static boolean isPatternDelimiter(String text) {
        return DELIMITER_PATTERN.matcher(text).matches();
    }

    private static String[] splitPatternDelimiter(String text) {
        Matcher patternMather = DELIMITER_PATTERN.matcher(text);
        while (patternMather.find()) {
            String customDelimiter = patternMather.group(1);
            return patternMather.group(2).split(customDelimiter);
        }
        return new String[0];
    }

    private static int addStringArray(String[] tokens){
        return Arrays.stream(filterPositiveNumber(tokens))
                        .mapToInt(number -> parseStringToInt(number))
                        .sum();
    }

    private static String[] filterPositiveNumber(String[] tokens){
        return Arrays.stream(tokens)
                .filter(m -> isPositiveNumber(m))
                .toArray(String[]::new);
    }

    private static boolean isPositiveNumber(String text){
        if(POSITIVE_NUMBER_PATTERN.matcher(text).matches()){
            return true;
        }
        throw new IllegalArgumentException("입력 문자열이 정상적이지 않습니다.");
    }

    private static int parseStringToInt(String number){
        return Integer.parseInt(number);
    }
}
