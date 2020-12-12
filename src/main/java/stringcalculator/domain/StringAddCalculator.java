package stringcalculator.domain;

import java.util.List;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        List<Integer> integers = InputConvertor.convert(input);
        return Adder.add(integers);
    }
}
