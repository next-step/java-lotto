package com.nextstep.camp.lotto.application.service;

import com.nextstep.camp.lotto.application.dto.ExpressionRequest;
import com.nextstep.camp.lotto.application.dto.ExpressionResponse;
import com.nextstep.camp.lotto.domain.entity.Expression;

public class CalculatorService {
    public ExpressionResponse calculate(ExpressionRequest request) {
        Expression expression = Expression.of(request.getExpressionTokens());
        return ExpressionResponse.of(expression.evaluate());
    }
}
