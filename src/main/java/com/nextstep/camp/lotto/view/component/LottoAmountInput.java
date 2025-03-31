package com.nextstep.camp.lotto.view.component;

import com.nextstep.camp.calculator.domain.vo.ExpressionTokens;
import com.nextstep.camp.common.view.component.AbstractInput;

import java.util.Scanner;

public class LottoAmountInput extends AbstractInput<ExpressionTokens> {

    private static final String EXPRESSION_REGEX = "^-?\\d+(?: [+\\-*/] -?\\d+)*$";

    private LottoAmountInput(Scanner scanner) {
        super(scanner);
    }

    public static LottoAmountInput create(Scanner scanner) {
        return new LottoAmountInput(scanner);
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
