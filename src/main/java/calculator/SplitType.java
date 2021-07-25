package calculator;

import calculator.exception.NotFoundSplitTypeException;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum SplitType {

    DEFAULT(SplitType::splitTypeDefault, Pattern.compile(",|:")),
    SINGLE(SplitType::splitTypeSingle, Pattern.compile("^[0-9]*$")),
    USER_DEFINE(SplitType::splitTypeUserDefine, Pattern.compile("//(.)\n(.*)"));

    private final StringSeparate separate;
    private final Pattern pattern;

    SplitType(StringSeparate stringSeparate, Pattern pattern) {
        this.separate = stringSeparate;
        this.pattern = pattern;
    }

    public static SplitNumber split(String separateStr) {
        return Arrays.stream(values())
                .filter(f -> f.pattern.matcher(separateStr).find())
                .findFirst()
                .map(s -> s.separate.split(s.pattern, separateStr))
                .orElseThrow(() -> new NotFoundSplitTypeException(separateStr));
    }

    private static SplitNumber splitTypeDefault(Pattern separatePattern, String separateStr) {
        return new SplitNumber(separatePattern.split(separateStr));
    }

    private static SplitNumber splitTypeSingle(Pattern separatePattern, String separateStr) {
        return new SplitNumber(new String[]{separateStr});
    }

    private static SplitNumber splitTypeUserDefine(Pattern separatePattern, String separateStr) {
        Matcher matcher = separatePattern.matcher(separateStr);
        if (!matcher.find()) {
            throw new NotFoundSplitTypeException(separateStr);
        }
        int delimiterGroup = 1;
        int patternGroup = 2;
        String customDelimiter = matcher.group(delimiterGroup);
        String[] split = matcher.group(patternGroup).split(customDelimiter);

        return new SplitNumber(split);
    }
}
