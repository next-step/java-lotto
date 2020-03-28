package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextToNumber {
    private static final Pattern CUSTOM_DELIMTER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DELIMETER = ",|:";
    private static final int MATCHING_PART = 1;
    private static final int DELIMETER_FORMULA = 2;
    private List<PositiveNumber> positiveNumbers;

    public TextToNumber(String inputText) {
        this.positiveNumbers = convertToNumbers(splitText(inputText));
    }

    public List<PositiveNumber> getPositiveNumbers() {
        return new ArrayList<>(positiveNumbers);
    }

    private List<String> splitText(String text) {
        Matcher matcher = CUSTOM_DELIMTER_PATTERN.matcher(text);
        if (matcher.find()) {
            return getCustomDelimeterText(matcher);
        }

        return Stream.of(text.split(DELIMETER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private List<String> getCustomDelimeterText(Matcher matcher) {
        String delimiter = matcher.group(MATCHING_PART);
        return Stream.of(matcher.group(DELIMETER_FORMULA).split(delimiter))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private List<PositiveNumber> convertToNumbers(List<String> text) {
        return text.stream()
                .map(this::parseToInt)
                .map(PositiveNumber::new)
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
