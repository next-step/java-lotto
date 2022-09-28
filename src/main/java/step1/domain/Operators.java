package step1.domain;

import java.util.ArrayDeque;
import java.util.List;

public class Operators {

    private final ArrayDeque<Operator> operators;

    public Operators(ArrayDeque<Operator> operators) {
        this.operators = new ArrayDeque<>(operators);
    }

    public Operators(List<Operator> operatorList) {
        this(new ArrayDeque<>(operatorList));
    }

    public Operator operator() {
        if (operators.isEmpty()) {
            throw new IllegalStateException("더 이상 연산자가 존재하지 않습니다.");
        }

        return operators.poll();
    }
}
