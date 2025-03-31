package com.nextstep.camp.calculator.application.service;

import com.nextstep.camp.calculator.application.dto.ExpressionRequest;
import com.nextstep.camp.calculator.application.dto.ExpressionResponse;
import com.nextstep.camp.calculator.domain.entity.Expression;

public class CalculatorService {
    public ExpressionResponse calculate(ExpressionRequest request) {
        Expression expression = Expression.of(request.getExpressionTokens());
        return ExpressionResponse.of(expression.evaluate());
    }
}
