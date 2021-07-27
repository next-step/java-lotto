package calculator;

import calculator.model.NaturalNumber;
import calculator.tokenizer.CustomDelimTokenizer;
import calculator.tokenizer.Tokenizer;

import java.util.Objects;

import static java.util.Arrays.stream;

public class StringAddCalculator {
    private static final Tokenizer DEFAULT_TOKENIZER = new Tokenizer();
    private static final CustomDelimTokenizer CUSTOM_DELIM_TOKENIZER = new CustomDelimTokenizer();
    private static final StringAddCalculator CALCULATOR = new StringAddCalculator();

    private StringAddCalculator() {
    }

    public static StringAddCalculator getInstance() {
        return CALCULATOR;
    }

    public int splitAndSum(String str) {
        if (Objects.isNull(str) || str.isBlank()) {
            return NaturalNumber.ZERO;
        }
        return sum(split(str));
    }

    private String[] split(String str) {
        if (CUSTOM_DELIM_TOKENIZER.isCustomExpression(str)) {
            return CUSTOM_DELIM_TOKENIZER.tokenize(str);
        }
        return DEFAULT_TOKENIZER.tokenize(str);
    }

    private int sum(String... numbers) {
        return stream(numbers)
                .map(NaturalNumber::parseNaturalNumber)
                .reduce(0, Integer::sum);
    }
}
