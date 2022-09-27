package calculator.domain;

import java.util.List;

public class Expressions {

    private final List<String> expressions;

    public Expressions(final List<String> expressions) {

        validateWrongInput(expressions);
        this.expressions = expressions;
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

    public String after(final int index) {

        return this.expressions.get(index + 1);
    }

    public String before(final int index) {

        return this.expressions.get(index - 1);
    }

    public void saveAfter(final int index, final int value) {

        this.expressions.set(index + 1, String.valueOf(value));
    }

    public String findLast() {

        return this.expressions.get(this.expressions.size() - 1);
    }

    public Operators extract() {

        return new Operators(expressions);
    }
}
