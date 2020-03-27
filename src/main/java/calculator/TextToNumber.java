package calculator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextToNumber {

    public static final String DELEMTER = ",|:";
    private List<Number> numbers;

    public TextToNumber(String inputText) {
        this.numbers = convertToNumbers(convertToStrings(inputText));
    }

    public Integer sum() {
        return numbers.stream()
                .reduce(new Number(0), Number::sum)
                .getNumber();
    }

    private List<String> convertToStrings(String text) {
        return Stream.of(text.split(DELEMTER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private List<Number> convertToNumbers(List<String> strings) {
        return strings.stream()
                .map(this::parseToInt)
                .map(Number::new)
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
