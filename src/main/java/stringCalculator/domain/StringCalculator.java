package stringCalculator.domain;

import stringCalculator.util.RegexExpression;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    private final List<Number> numberList;

    public StringCalculator(List<Number> numberList) {
        this.numberList = numberList;
    }

    public static StringCalculator from(String inputExpression) {
        List<Number> numberList = new ArrayList<>();
        for (String number : splitInputExpression(inputExpression)) {
            numberList.add(new Number(number));
        }
        return new StringCalculator(numberList);
    }

    private static String[] splitInputExpression(String inputExpression) {
        String expression = RegexExpression.getReplaceExpression(inputExpression);
        String splitRegex = RegexExpression.getSplitRegex(inputExpression);
        return expression.split(splitRegex);
    }

    public int calculate() {
        return numberList.stream()
                .reduce(Number::add)
                .get()
                .getNumber();
    }
}
