package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.String.format;

class StringAddCalculator {
    private static final int DEFAULT_VALUE = 0;
    private static final String DEFAULT_SEPARATOR = "[,:]";
    private static final String SEPARATOR_FORMAT = "-?\\d+(?:%s-?\\d+)*";
    private static final String DEFAULT_SEPARATOR_PATTERN = format(SEPARATOR_FORMAT, DEFAULT_SEPARATOR);
    private static final String CUSTOM_SEPARATOR_PATTERN = format("//(?<customDelimiter>[^/])\n(?<text>%s)", format(SEPARATOR_FORMAT, "\\k<customDelimiter>"));
    private static final Pattern customPattern = Pattern.compile(CUSTOM_SEPARATOR_PATTERN);
    public static final String ERROR_MSG_NEGATIVE_VALUE = "음수가 전달된 경우 예외가 발생됩니다.";

    public static int splitAndSum(String text) {
        if (null == text || "".equals(text.trim())) {
            return DEFAULT_VALUE;
        }
        int defaultSplitAndSum = defaultSplitAndSum(text);
        if (0 == defaultSplitAndSum){
            return customSplitAndSum(text);
        }
        return defaultSplitAndSum;
    }

    private static int defaultSplitAndSum(String text){
        if (text.matches(DEFAULT_SEPARATOR_PATTERN)) {
            String[] defaultSplit = text.split(DEFAULT_SEPARATOR);
            return numStringsToSum(text.split(DEFAULT_SEPARATOR));
        }
        return DEFAULT_VALUE;
    }

    static int customSplitAndSum(String customText){
        final Matcher matcher = customPattern.matcher(customText);
        if (matcher.matches()) {
            final String customDelimiter = matcher.group("customDelimiter");
            final String text = matcher.group("text");
            return numStringsToSum(text.split(customDelimiter));
        }
        return DEFAULT_VALUE;
    }

    private static int numStringsToSum(String[] splitNumStrings) {
        final int[] splitNums = Arrays.stream(splitNumStrings)
                                      .mapToInt(Integer::parseInt)
                                      .toArray();
        validNegativeValue(splitNums);
        return Arrays.stream(splitNums)
                     .sum()
            ;
    }

    private static void validNegativeValue(int[] splitNums) {
        Arrays.stream(splitNums)
              .min()
              .ifPresent(m -> {
                  if ( 0 > m) {
                      throw new IllegalArgumentException(ERROR_MSG_NEGATIVE_VALUE);
                  }
              })
        ;
    }
}
