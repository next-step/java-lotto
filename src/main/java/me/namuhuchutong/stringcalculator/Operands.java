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

    public int getOperand() {
        return this.values.poll();
    }

    public void push(int value) {
        this.values.push(value);
    }

    public int getResult() {
        if (this.values.size() != 1) {
            throw new ArithmeticException("연산이 안 된 피연산자가 존재합니다.");
        }
        return this.values.poll();
    }

    public int getOperandsSize() {
        return this.values.size();
    }
}
