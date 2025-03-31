package com.nextstep.camp.calculator.config;

import com.nextstep.camp.calculator.application.service.CalculatorService;
import com.nextstep.camp.calculator.infrastructure.view.handler.ExpressionInputViewHandler;
import com.nextstep.camp.calculator.infrastructure.view.handler.ExpressionResultViewHandler;
import com.nextstep.camp.calculator.presentation.controller.CalculatorController;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {

    private static final ApplicationContext instance = new ApplicationContext();
    private final Map<Class<?>, Object> beans = new HashMap<>();

    private ApplicationContext() {
        register(ExpressionInputViewHandler.class, new ExpressionInputViewHandler());
        register(CalculatorService.class, new CalculatorService());
        register(CalculatorController.class, new CalculatorController(getBean(CalculatorService.class)));
        register(ExpressionResultViewHandler.class, new ExpressionResultViewHandler());
    }

    public static ApplicationContext getInstance() {
        return instance;
    }

    public <T> void register(Class<T> type, T instance) {
        beans.put(type, instance);
    }

    public <T> T getBean(Class<T> type) {
        return type.cast(beans.get(type));
    }
}
