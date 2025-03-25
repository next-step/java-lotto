package step2.domain;

import java.util.List;

public class ExpressionElement {
    List<Integer> elements;
    List<String> operators;

    public ExpressionElement(List<Integer> elements, List<String> operators) {
        this.elements = elements;
        this.operators = operators;
    }

    public List<Integer> getElements() {
        return elements;
    }

    public List<String> getOperators() {
        return operators;
    }
}
