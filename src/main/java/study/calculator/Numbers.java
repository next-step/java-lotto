package study.calculator;

import study.calculator.pattern.CustomPattern;
import study.calculator.pattern.DefaultPattern;
import study.calculator.pattern.PatternSeparator;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static study.calculator.Validator.PREFIX_STRATEGY_CONDITION;
import static study.calculator.Validator.STRING_WHITESPACE;

/**
 * 숫자를 관리 할 일급 컬렉션
 */
public class Numbers {

    private final List<Number> numbers;

    public Numbers() {
        this(STRING_WHITESPACE);
    }

    private Numbers(String text) {
        this(text, new DefaultPattern());
    }

    protected Numbers(String text, PatternSeparator patternSeparator) {
        numbers = getExtractNumbers(text, patternSeparator);
    }

    public static Numbers of(String text) {
        if(text.startsWith(PREFIX_STRATEGY_CONDITION)) {
            return new Numbers(text, new CustomPattern());
        }
        return new Numbers(text);
    }

    protected List<Number> getExtractNumbers(String text, PatternSeparator patternSeparator) {
        String[] stringsSeparatedBySeparator = patternSeparator.matches(text);

        return Arrays.stream(stringsSeparatedBySeparator)
                .filter(Validator::isNumeric)
                .map(Number::of)
                .collect(toList());
    }

    public List<Number> getNumbers() {
        return numbers;
    }
}
