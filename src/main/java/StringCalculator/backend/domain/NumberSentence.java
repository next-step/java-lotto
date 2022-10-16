package StringCalculator.backend.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberSentence {

    private static final String BLANK = " ";
    private final List<String> value;

    public NumberSentence(String value) {
        checkNullAndEmpty(value);
        this.value = List.of(value.split(BLANK));
    }

    private void checkNullAndEmpty(String value) {
        if (value == null || value.trim().isBlank()) {
            throw new IllegalArgumentException("빈 값이 입력되었습니다.");
        }
    }

    public List<Operand> findOperand() {
        return Stream.iterate(0, i -> i + 1)
                .limit(value.size())
                .peek(i -> checkNullAndEmpty(value.get(i)))
                .filter(this::isEven)
                .map(i -> new Operand(Integer.parseInt(value.get(i))))
                .collect(Collectors.toList());
    }

    public List<Operator> findOperator() {
        return Stream.iterate(0, i -> i + 1)
                .limit(value.size())
                .peek(i -> checkNullAndEmpty(value.get(i)))
                .filter(this::isOdd)
                .map(i -> OperatorFactory.getOperator(value.get(i)))
                .collect(Collectors.toList());
    }

    private boolean isOdd(int i) {
        return i % 2 == 1;
    }

    private boolean isEven(int i) {
        return i % 2 == 0;
    }
}
