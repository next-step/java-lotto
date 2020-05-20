package calculator;

import calculator.delimiter.Delimiter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Splitter {

    private Splitter() {
    }

    public static List<String> split(String expression, List<Delimiter> delimiters) {
        List<String> expressions = new ArrayList<>(Arrays.asList(expression));
        for (Delimiter delimiter : delimiters) {
            expressions = delimiter.split(expressions);
        }
        return expressions;
    }
}
