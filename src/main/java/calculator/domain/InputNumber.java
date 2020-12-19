package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputNumber {

    public static final String DEFAULT_DELEMITER = "[,:]";
    private final String input;

    public InputNumber(String input) {
        this.input = input;

    }

    public boolean isEmpty() {
        return input == null || input.trim().isEmpty();
    }

    public int getNumber() {
        return Integer.parseInt(input);
    }


    public List<Integer> getNumbers() {
        return Arrays.stream(splitInput())
            .map(s -> Integer.parseInt(s.trim()))
            .collect(Collectors.toList());
    }

    private String[] splitInput() {
        Matcher m = Pattern.compile("//(.)\\n(.*)")
            .matcher("//;\n1;2;3");
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return input.split(DEFAULT_DELEMITER);
    }


    public boolean isOneLength() {
        return input.length() == 1;
    }
}
