package calculator.domain;

import java.util.Collections;
import java.util.List;

public class Expression {

    private final List<ExpressionElement> elements;

    public Expression(List<ExpressionElement> elements) {
        if (isEmpty(elements)) {
            throw new IllegalArgumentException("null 이거나 빈 리스트로 Expression 객체를 생성할 수 없습니다.");
        }
        this.elements = Collections.unmodifiableList(elements);
    }

    private boolean isEmpty(List<ExpressionElement> elements) {
        return elements == null || elements.isEmpty();
    }

    public ExpressionElement get(int index) {
        return elements.get(index);
    }

    public int size() {
        return elements.size();
    }
}
