package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextToNumber {
    private static final Pattern CUSTOM_DELIMTER_PATTERN = Pattern.compile("//(.)\n(.*)");
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
        Matcher matcher = CUSTOM_DELIMTER_PATTERN.matcher(text);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            return Stream.of(matcher.group(2).split(delimiter))
                    .map(String::trim)
                    .collect(Collectors.toList());
        }

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
