package me.namuhuchutong.stringcalculator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Operands {

    private static final String OPERAND_PATTERN = "[^0-9]+";

    private final Deque<Integer> values;

    public static Operands from(String input) {
        Deque<Integer> collect = Stream.of(input.split(OPERAND_PATTERN))
                                       .map(Integer::parseInt)
                                       .collect(Collectors.toCollection(ArrayDeque::new));
        return new Operands(collect);
    }

    public Operands(Deque<Integer> values) {
        validateOperands(values);
        this.values = values;
    }

    private void validateOperands(Deque<Integer> values) {
        if (values.size() == 0) {
            throw new IllegalArgumentException("올바르지 않는 피연산자입니다.");
        }
    }
}
