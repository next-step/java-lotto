package com.nextstep.lotto.stringCalculator;

import java.util.List;

public class Polynomial {

    private static final String TOO_SHORT_ARGUMENT_MSG = "polynomial must have at least 3 tokens (leftOperand, operator, rightOperand)";
    private static final int MINIMUM_TOKENS = 3;

    private final List<String> tokens;

    public Polynomial(String polynomialString) {
        validate(polynomialString);
        this.tokens = split(polynomialString);
    }

    private void validate(String polynomial) {
        if (isTooShort(polynomial)) {
            throw new IllegalArgumentException(TOO_SHORT_ARGUMENT_MSG);
        }
    }

    private boolean isTooShort(String polynomial) {
        return polynomial == null || polynomial.split(" ").length < MINIMUM_TOKENS;
    }

    private List<String> split(String polynomial) {
        return List.of(polynomial.split(" "));
    }

    public int size() {
        return this.tokens.size();
    }

    public String getTokenAt(int position) {
        return this.tokens.get(position);
    }

}
