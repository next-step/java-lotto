package domain;

import java.util.List;

public class Expression {
    private final List<String> elements;

    public Expression(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력값이 비어 있습니다.");
        }
        this.elements = List.of(input.split(" "));
    }

    public int evaluate() {
        int result = new Operand(elements.get(0)).getValue();

        for (int i = 1; i < elements.size(); i += 2) {
            Operator operator = Operator.from(elements.get(i));
            int nextValue = new Operand(elements.get(i + 1)).getValue();
            result = operator.apply(result, nextValue);
        }

        return result;
    }
}