package calculator.domain;

import calculator.util.StringUtil;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Expression {

    public static final String OPERAND_OPERATOR_OPERAND = "^\\d+ [-+*/] \\d+( [-+*/] \\d+)*$";

    private final String expression;
    private final Operands operands;
    private final Operators operators;

    public Expression(String expression) {
        validateExpression(expression);

        this.expression = expression;
        this.operands = extractOperands();
        this.operators = extractOperators();
    }

    private void validateExpression(String expression) {
        if (StringUtil.isEmpty(expression)) {
            throw new IllegalArgumentException("수식을 입력해 주세요.");
        }

        boolean isValidExpression = Pattern.matches(OPERAND_OPERATOR_OPERAND, expression);
        if (!isValidExpression) {
            throw new IllegalArgumentException("올바르지 않은 수식입니다.");
        }
    }

    private Operands extractOperands() {
        List<String> elements = StringUtil.splitBySpace(this.expression);

        String[] filtered = IntStream.rangeClosed(0, elements.size())
                .filter(index -> index % 2 != 0)
                .mapToObj(elements::get)
                .toArray(String[]::new);

        return new Operands(filtered);
    }

    private Operators extractOperators() {
        List<String> elements = StringUtil.splitBySpace(this.expression);

        String[] filtered = IntStream.rangeClosed(0, elements.size())
                .filter(index -> index % 2 == 0)
                .mapToObj(elements::get)
                .toArray(String[]::new);

        return new Operators(filtered);
    }
}
