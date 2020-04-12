package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoManualGenerator implements GenerateStrategy {
    private static final String NOT_NUMBER = "숫자가 아닙니다. ";
    private final List<String> parsedText;
    private final Set<LottoNumber> numbers;

    public LottoManualGenerator(final List<String> parsedText) {
        this.parsedText = new ArrayList<>(parsedText);
        this.numbers = new TreeSet<>();
    }

    @Override
    public List<LottoNumber> generateNumbers() {
        return convertToLottoNumbers(parsedText);
    }

    private List<LottoNumber> convertToLottoNumbers(List<String> text) {
        return text.stream()
                .map(this::parseToInt)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    private int parseToInt(String inputText) {
        try {
            return (Integer.parseInt(inputText));
        } catch (Exception e) {
            throw new NumberFormatException(NOT_NUMBER + e.getMessage());
        }
    }


}
