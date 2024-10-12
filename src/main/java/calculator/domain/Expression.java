package calculator.domain;

import calculator.domain.operator.Operator;
import calculator.util.StringUtil;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Expression {

    public static final String OPERAND_OPERATOR_OPERAND = "^-?\\d+ [-+*/] -?\\d+( [-+*/] -?\\d+)*$";

    private final String expression;

    public Expression(String expression) {
        validateExpression(expression);

        this.expression = expression;
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

    public Iterator<Integer> getOperands() {
        List<String> elements = StringUtil.splitBySpace(this.expression);

        String[] filtered = IntStream.range(0, elements.size())
                .filter(index -> index % 2 == 0)
                .mapToObj(elements::get)
                .toArray(String[]::new);

        return new Operands(filtered).iterator();
    }

    public Iterator<Operator> getOperators() {
        List<String> elements = StringUtil.splitBySpace(this.expression);

        String[] filtered = IntStream.range(0, elements.size())
                .filter(index -> index % 2 != 0)
                .mapToObj(elements::get)
                .toArray(String[]::new);

        return new Operators(filtered).iterator();
    }
}
