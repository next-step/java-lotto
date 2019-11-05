package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Inputs {
    private static final String BASIC_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final String STRING_ZERO = "0";
    private static final int INTEGER_ZERO = 0;
    private List<String> inputs;

    Inputs() {

    }

    Inputs(String input) {
        validate(input);
        this.inputs = Arrays.asList(inputSplitWithCustom(input));
    }

    private void validate(String input) {
        if (input == null || input.isEmpty()) {
            this.inputs.clear();
        }
    }

    int addInput() {
        int sum = INTEGER_ZERO;
        for (String input : this.inputs) {
            sum += checkInput(input);
        }
        return sum;
    }

    private int checkInput(String input) {
        if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }


    String[] basicSplit(String input) {
        return input.split(BASIC_DELIMITER);
    }

    String[] inputSplitWithCustom(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return basicSplit(input);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inputs inputs1 = (Inputs) o;
        return Objects.equals(inputs, inputs1.inputs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputs);
    }

}
