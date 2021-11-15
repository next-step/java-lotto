package com.kakao.stringadder.domain.calculator;

import java.util.List;
import java.util.stream.Collectors;

public class OperandCollection {
    private final List<Operand> operands;

    public OperandCollection(List<Operand> operands) {
        this.operands = operands;
    }

    public static OperandCollection of(List<String> stringOperands){
        List<Operand> operands = stringOperands.stream()
                .map(Operand::of)
                .collect(Collectors.toList());
        return new OperandCollection(operands);
    }

    public Operand plusAll() {
        return operands.stream()
                .reduce(Operand::plus)
                .orElse(Operand.zero());
    }
}
