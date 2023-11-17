package calculator.domain;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Calculator {

    private final List<String> strings;

    private Calculator(List<String> strings) {
        this.strings = strings;
    }

    public static Calculator of(String origin) {
        validate(origin);
        List<String> splitStrings = splitStrings(origin);
        return new Calculator(splitStrings);
    }

    private static void validate(String origin) {
        if (origin == null || origin.isEmpty()) {
            throw new IllegalArgumentException("올바른 수식이 아닙니다.");
        }
    }

    public Variable calculate() {
        Iterator<String> iterator = strings.iterator();
        Variable result = Variable.of(iterator.next());
        while (iterator.hasNext()) {
            String anyExpression = iterator.next();
            String anyVariable = iterator.next();
            result = Expression.of(anyExpression).expression(result, Variable.of(anyVariable))
                .calculate();
        }
        return result;
    }

    private static List<String> splitStrings(String origin) {
        return Arrays.asList(origin.split(" "));
    }
}
