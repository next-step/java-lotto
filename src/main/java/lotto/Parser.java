package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {
    private static final String DELIMETER = ",";
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
    Set<Integer> numbers = new HashSet<>();

    public Parser(final String inputText) {
        numbers = convertToNumbers(splitText(inputText));
    }

    public Numbers getNumbers () {
        return new Numbers(numbers);
    }

    private List<String> splitText(String text) {
        return Stream.of(text.split(DELIMETER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private Set<Integer> convertToNumbers(List<String> text) {
        return text.stream()
                .map(this::parseToInt)
                .filter(this::isLottoRange)
                .collect(Collectors.toSet());
    }

    private int parseToInt(String inputText) {
        try {
            return (Integer.parseInt(inputText));
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자가 아닙니다. " + e.getMessage());
        }
    }

    private boolean isLottoRange(int number) {
        return MIN_LOTTO_NUMBER <= number && number <= MAX_LOTTO_NUMBER;
    }
}
