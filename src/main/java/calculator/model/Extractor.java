package calculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Extractor {

    private static final String NUMBER_PATTERN = "[0-9]";
    private static final String OPERATOR_PATTERN = "[-+*/]";

    private Extractor(){}

    public static List<Number> extractNumbers(String string) {
        return Arrays.stream(string.split(OPERATOR_PATTERN))
                .map(Number::new)
                .collect(Collectors.toList());
    }

    public static List<Operator> extractOperator(String string) {
        String replaced = string.replaceAll(NUMBER_PATTERN,"");
        return Arrays.stream(replaced.split(""))
                .map(Operator::of)
                .collect(Collectors.toList());
    }
}
