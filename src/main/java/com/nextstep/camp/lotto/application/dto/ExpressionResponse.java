package com.nextstep.camp.lotto.application.dto;

public class ExpressionResponse {
    private final int result;

    public ExpressionResponse(int result) {
        this.result = result;
    }

    public static ExpressionResponse of(int evaluate) {
        return new ExpressionResponse(evaluate);
    }

    public int getResult() {
        return result;
    }
}
