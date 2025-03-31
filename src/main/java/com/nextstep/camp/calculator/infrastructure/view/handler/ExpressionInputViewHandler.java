package com.nextstep.camp.calculator.infrastructure.view.handler;


import com.nextstep.camp.calculator.infrastructure.view.ExpressionInputView;
import com.nextstep.camp.calculator.infrastructure.view.component.ExpressionInput;
import com.nextstep.camp.calculator.infrastructure.view.dto.ExpressionInputData;

import java.util.Scanner;

public class ExpressionInputViewHandler {

    public ExpressionInputData handleUserInput() {
        ExpressionInput input = ExpressionInput.create(new Scanner(System.in));
        ExpressionInputView view = ExpressionInputView.publish(input);
        view.render();
        return view.toInputData();
    }
}
