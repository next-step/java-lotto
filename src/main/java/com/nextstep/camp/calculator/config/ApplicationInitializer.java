package com.nextstep.camp.calculator.config;


import com.nextstep.camp.calculator.application.dto.ExpressionRequest;
import com.nextstep.camp.calculator.application.dto.ExpressionResponse;
import com.nextstep.camp.calculator.infrastructure.view.dto.InputData;
import com.nextstep.camp.calculator.infrastructure.view.handler.ExpressionInputViewHandler;
import com.nextstep.camp.calculator.infrastructure.view.handler.ExpressionResultViewHandler;
import com.nextstep.camp.calculator.presentation.controller.CalculatorController;

public class ApplicationInitializer {

    private final ApplicationContext context;

    private ApplicationInitializer() {
        this.context = ApplicationContext.getInstance();
    }

    public static void initialize() {
        new ApplicationInitializer().run();
    }

    public void run() {
        ExpressionInputViewHandler inputViewHandler = context.getBean(ExpressionInputViewHandler.class);
        CalculatorController controller = context.getBean(CalculatorController.class);
        ExpressionResultViewHandler resultViewHandler = context.getBean(ExpressionResultViewHandler.class);

        InputData inputData = inputViewHandler.handleUserInput();
        ExpressionRequest request = inputData.toExpressionRequest();
        ExpressionResponse response = controller.calculate(request);
        resultViewHandler.handle(response);

    }
}
