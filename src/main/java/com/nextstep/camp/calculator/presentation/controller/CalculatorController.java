package com.nextstep.camp.calculator.presentation.controller;

import com.nextstep.camp.calculator.application.dto.ExpressionRequest;
import com.nextstep.camp.calculator.application.dto.ExpressionResponse;
import com.nextstep.camp.calculator.application.service.CalculatorService;

public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public ExpressionResponse calculate(ExpressionRequest request) {
        return calculatorService.calculate(request);
    }
}
