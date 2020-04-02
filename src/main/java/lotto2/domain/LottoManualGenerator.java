package lotto2.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoManualGenerator implements GenerateStrategy {
    private static final String DELIMETER = ",";

    private final String inputText;
    private final Set<LottoNumber> numbers;

    public LottoManualGenerator(final String inputText) {
        this.inputText = inputText;
        this.numbers = new TreeSet<>();
    }

    @Override
    public Set<LottoNumber> generateNumbers() {
        return convertToNumbers(splitText(inputText));
    }

    private List<String> splitText(String text) {
        return Stream.of(text.split(DELIMETER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private Set<LottoNumber> convertToNumbers(List<String> text) {
        return text.stream()
                .map(this::parseToInt)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    private int parseToInt(String inputText) {
        try {
            return (Integer.parseInt(inputText));
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자가 아닙니다. " + e.getMessage());
        }
    }


}
