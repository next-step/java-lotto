package com.nextstep.camp.calculator.infrastructure.view.component;

import com.nextstep.camp.calculator.domain.vo.ExpressionTokens;
import com.nextstep.camp.common.view.component.AbstractInput;

import java.util.Scanner;

public class ExpressionInput extends AbstractInput<ExpressionTokens> {

    private static final String EXPRESSION_REGEX = "^-?\\d+(?: [+\\-*/] -?\\d+)*$";

    private ExpressionInput(Scanner scanner) {
        super(scanner);
    }

    public static ExpressionInput create(Scanner scanner) {
        return new ExpressionInput(scanner);
    }

    @Override
    protected boolean isValid(String value) {
        return value.matches(EXPRESSION_REGEX);
    }

    @Override
    public String getLabel() {
        return "연산식을 입력하세요.";
    }

    @Override
    public ExpressionTokens getValue() {
        return ExpressionTokens.of(untypedValue);
    }
}
