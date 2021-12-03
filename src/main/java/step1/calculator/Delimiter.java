package step1.calculator;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.function.Function;

/**
 * .
 */
public enum Delimiter {

    COMMA(","
            , str -> new Numbers(new DefaultSplitString().split(str))),
    COLON(":"
            , str -> new Numbers(new DefaultSplitString().split(str))),
    ETC(""
            , str -> new Numbers(new EtcSplitString().split(str)));

    private String delimiter;
    private Function<String, Numbers> splitNumbers;

    Delimiter(String delimiter, Function<String, Numbers> splitNumbers) {
        this.delimiter = delimiter;
        this.splitNumbers = splitNumbers;
    }

    public Numbers convertToNumbers(String input) {
        return splitNumbers.apply(input);
    }

    public static Delimiter of(String input) {
        return Arrays.stream(values())
                .filter(value -> input.contains(value.delimiter))
                .findFirst()
                .orElseThrow(() -> new InvalidParameterException("올바른 구분자를 입력하세요"));
    }
}
