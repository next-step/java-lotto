package study.calculator;

import study.calculator.argument.Argument;
import study.calculator.argument.BlankArgument;
import study.calculator.argument.CustomArgument;
import study.calculator.argument.DefaultArgument;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringAddCalculator {

    private static final Delimiter COMMA = new Delimiter(",");
    private static final Delimiter COLON = new Delimiter(":");

    public static int splitAndSum(String source) {

        Argument argument = getArgument(source);

        List<Number> numbers = argument.parseToNumber();

        return sum(numbers).getValue();
    }

    private static Argument getArgument(String source) {
        if (BlankArgument.isBlankArgument(source)) {
            return new BlankArgument();
        }

        if (CustomArgument.hasCustomArgument(source)) {
            return new CustomArgument(source);
        }

        return new DefaultArgument(source);
    }

    private static Number sum(List<Number> numbers) {
        Number result = Number.zero();

        for (Number number : numbers) {
            result = result.plus(number);
        }

        return result;
    }

}
