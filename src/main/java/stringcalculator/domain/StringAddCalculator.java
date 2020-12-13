package stringcalculator.domain;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        return Adder.add(InputConvertor.convert(input));
    }
}
