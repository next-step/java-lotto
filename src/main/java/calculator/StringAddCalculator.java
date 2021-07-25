package calculator;

import calculator.model.NaturalNumber;
import calculator.tokenizer.CustomTokenizer;
import calculator.tokenizer.Tokenizer;

import java.util.Objects;

import static java.util.Arrays.stream;

public class StringAddCalculator {
    private static final Tokenizer defaultTokenizer = new Tokenizer();
    private static final CustomTokenizer customTokenizer = new CustomTokenizer();

    private static StringAddCalculator calculator = null;

    private StringAddCalculator() {
    }

    public static StringAddCalculator getInstance() {
        if (Objects.isNull(calculator)) {
            calculator = new StringAddCalculator();
        }
        return calculator;
    }

    public int splitAndSum(String str) {
        if (Objects.isNull(str) || str.isBlank()) {
            return NaturalNumber.ZERO;
        }

        return sum(split(str));
    }

    private String[] split(String str) {
        if (customTokenizer.isCustomExpression(str)) {
            return customTokenizer.tokenize(str);
        }
        return defaultTokenizer.tokenize(str);
    }

    private int sum(String... numbers) {
        return stream(numbers)
                .map(NaturalNumber::parseNaturalNumber)
                .reduce(0, Integer::sum);
    }
}
