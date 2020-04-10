package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
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
    public List<LottoNumber> generateNumbers() {
        return convertToNumbers(splitText(inputText));
    }

    private List<String> splitText(String text) {
        return Stream.of(text.split(DELIMETER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private List<LottoNumber> convertToNumbers(List<String> text) {
        return text.stream()
                .map(this::parseToInt)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    private int parseToInt(String inputText) {
        try {
            return (Integer.parseInt(inputText));
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자가 아닙니다. " + e.getMessage());
        }
    }


}
