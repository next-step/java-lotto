package com.nextstep.camp.lotto.domain.vo;

import com.nextstep.camp.common.utils.StringUtils;
import com.nextstep.camp.lotto.domain.exception.NotFoundValueException;
import com.nextstep.camp.lotto.domain.exception.UnsupportedOperatorException;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class OperatorToken implements ExpressionToken {

    private final String value;

    public final static OperatorToken PLUS = new OperatorToken("+", false);
    public final static OperatorToken MINUS = new OperatorToken("-", false);
    public final static OperatorToken MULTIPLY = new OperatorToken("*", false);
    public final static OperatorToken DIVIDE = new OperatorToken("/", false);
    private final static Set<String> OPERATOR_TOKENS = new HashSet<>();

    static {
        OPERATOR_TOKENS.add(PLUS.value);
        OPERATOR_TOKENS.add(MINUS.value);
        OPERATOR_TOKENS.add(MULTIPLY.value);
        OPERATOR_TOKENS.add(DIVIDE.value);
    }

    private OperatorToken(String value, boolean isTest) {
        if (isTest) {
            validate(value);
        }
        this.value = value;
    }

    private static void validate(String value) {
        if (StringUtils.hasNotText(value)) {
            throw new NotFoundValueException();
        }
        if (OPERATOR_TOKENS.stream().noneMatch(value::equals)) {
            throw new UnsupportedOperatorException();
        }
    }

    public static OperatorToken of(String value) {
        return new OperatorToken(value, true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        OperatorToken operatorToken = (OperatorToken) o;
        return Objects.equals(value, operatorToken.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
