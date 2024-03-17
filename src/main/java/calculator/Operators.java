package calculator;

import java.util.ArrayList;
import java.util.List;

public class Operators {

    private final List<Operator> operators;
    private int currentIndex;

    public Operators(List<String> operators) {
        if (operators.isEmpty()) {
            throw new IllegalArgumentException("연산자를 입력해주세요.");
        }

        this.operators = new ArrayList<>();
        operators.forEach(value -> this.operators.add(Operator.valueOfSign(value)));
    }

    public Operator nextOperation() {
        if (isMaxSizeIndex()) {
            throw new ReachedMaxIndexException();
        }

        return operators.get(currentIndex++);
    }

    private boolean isMaxSizeIndex() {
        return operators.size() == currentIndex;
    }
}
