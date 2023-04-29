package study.lotto.step1.application.util;

import study.lotto.step1.domain.Operand;
import study.lotto.step1.domain.Operands;
import study.lotto.step1.domain.Operator;
import study.lotto.step1.domain.Operators;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExpressionParser {
    private static final String BLANK = " ";
    private static final int EVEN_INDEX = 2;

    private ExpressionParser() {
    }

    public static Operands operands(String expression) {
        String[] splitExpression = expression.split(BLANK);

        List<Operand> operands = IntStream.range(0, splitExpression.length)
                .filter(ExpressionParser::isOperandIndex)
                .mapToObj(i -> new Operand(splitExpression[i]))
                .collect(Collectors.toList());

        return new Operands(operands);
    }

    public static Operators operators(String expression) {
        String[] splitExpression = expression.split(BLANK);

        List<Operator> operators = IntStream.range(0, splitExpression.length)
                .filter(ExpressionParser::isOperatorIndex)
                .mapToObj(i -> Operator.of(splitExpression[i]))
                .collect(Collectors.toList());

        return new Operators(operators);
    }

    private static boolean isOperandIndex(int i) {
        return i % EVEN_INDEX == 0;
    }

    private static boolean isOperatorIndex(int i) {
        return !isOperandIndex(i);
    }
}
