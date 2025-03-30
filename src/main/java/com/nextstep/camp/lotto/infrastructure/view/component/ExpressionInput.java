package com.nextstep.camp.lotto.infrastructure.view.component;

import com.nextstep.camp.lotto.domain.vo.ExpressionTokens;

import java.util.Scanner;

public class ExpressionInput extends AbstractInput<ExpressionTokens> {

    private ExpressionInput(Scanner scanner) {
        super(scanner);
    }

    public static ExpressionInput create(Scanner scanner) {
        return new ExpressionInput(scanner);
    }

    @Override
    protected boolean isValid(String value) {
        return true;
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
