package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Expression {

    public static final Pattern EXPRESSION_PATTERN = Pattern.compile("^-?\\d+ [-+*/] -?\\d+( [-+*/] -?\\d+)*$");

    private final String expression;

    public Expression(String expression) {
        validateExpression(expression);

        this.expression = expression;
    }

    private void validateExpression(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("수식을 입력해 주세요.");
        }

        Matcher matcher = EXPRESSION_PATTERN.matcher(expression);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("올바르지 않은 수식입니다.");
        }
    }

    Iterator<Integer> getOperands() {
        List<String> elements = splitBySpace(this.expression);

        String[] filtered = IntStream.range(0, elements.size())
                .filter(Expression::isEvenNumber)
                .mapToObj(elements::get)
                .toArray(String[]::new);

        return new Operands(filtered).iterator();
    }

    Iterator<IntBinaryOperator> getOperators() {
        List<String> elements = splitBySpace(this.expression);

        String[] filtered = IntStream.range(0, elements.size())
                .filter(Expression::isOddNumber)
                .mapToObj(elements::get)
                .toArray(String[]::new);

        return new Operators(filtered).iterator();
    }

    private List<String> splitBySpace(String input) {
        if (input == null || input.isEmpty()) {
            return new ArrayList<>();
        }

        String[] split = input.split(" ");

        return Arrays.asList(split);
    }

    private static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }

    private static boolean isOddNumber(int number) {
        return number % 2 != 0;
    }
}
