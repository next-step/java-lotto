package lotto;

import org.w3c.dom.ranges.Range;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultView {
    private static final String DELIMETER = ",";

    private Numbers numbers;

    public ResultView(String inputText) {
        numbers = new Numbers(convertToNumbers(splitText(inputText)));
    }

    public Set<Integer> winnerNumber() {
        return numbers.getNumbers();
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

    private boolean isLottoRange(int number) {
        return 1 <= number && number <= 45;
    }

    private int parseToInt(String inputText) {
        try {
            return (Integer.parseInt(inputText));
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자가 아닙니다. " + e.getMessage());
        }
    }
}
