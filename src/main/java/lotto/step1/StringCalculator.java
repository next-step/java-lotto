package lotto.step1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    private static final String BASIC_DELIMITER_PATTERN = "[,:]";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    private List<Integer> values = new ArrayList<>();
    private int result;

    public StringCalculator(String input) {
        if (input != null && !input.isEmpty()) {
            this.values = splitInput(input);
        }
    }

    public List<Integer> getValues() {
        return values;
    }

    public int calculateResult() {
        return result;
    }

    public void add() {
        this.result = values.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private List<Integer> splitInput(String input) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
        if (m.find()) {
            return splitCustom(input, m);
        }
        return splitBasic(input);
    }

    private List<Integer> splitBasic(String input) {
        String[] arr = input.split(BASIC_DELIMITER_PATTERN);
        return toList(arr);
    }

    private List<Integer> splitCustom(String input, Matcher m) {
        String customDelimiter = m.group(1);
        String[] arr = m.group(2).split(customDelimiter);
        return toList(arr);
    }

    private List<Integer> toList(String[] stringArr) {
        return Arrays.stream(stringArr)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringCalculator that = (StringCalculator) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

}
