package calculator.domain;

import java.util.List;

public class Expressions {

    private final List<String> expressions;

    public Expressions(final List<String> expressions) {

        validateWrongInput(expressions);
        this.expressions = expressions;
    }

    public Expressions(final Expression expression) {

        this(expression.split());
    }

    /**
     * 숫자와 연산자의 수는 짝수가 되면 안되기 떄문에 2로 나누었을때 나머지가 0이면 익셉션 처리
     */
    private void validateWrongInput(final List<String> expressions) {

        final int remainder = Math.floorMod(expressions.size(), 2);
        if (remainder == 0) {
            throw new IllegalArgumentException("계산기를 잘못 입력하였습니다.");
        }
    }

    public List<Operation> separate() {

        return Operation.from(expressions);
    }

    public List<Number> disunite() {

        return Number.from(expressions);
    }
}
