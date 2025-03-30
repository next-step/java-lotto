package com.nextstep.camp.lotto.presentation.controller;

import com.nextstep.camp.lotto.application.dto.ExpressionRequest;
import com.nextstep.camp.lotto.application.dto.ExpressionResponse;
import com.nextstep.camp.lotto.application.service.CalculatorService;

public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public ExpressionResponse calculate(ExpressionRequest request) {
        return calculatorService.calculate(request);
    }
}
