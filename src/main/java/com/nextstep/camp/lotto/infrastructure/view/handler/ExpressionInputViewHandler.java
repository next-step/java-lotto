package com.nextstep.camp.lotto.infrastructure.view.handler;


import com.nextstep.camp.lotto.infrastructure.view.ExpressionInputView;
import com.nextstep.camp.lotto.infrastructure.view.component.ExpressionInput;
import com.nextstep.camp.lotto.infrastructure.view.dto.InputData;

import java.util.Scanner;

public class ExpressionInputViewHandler {

    public InputData handleUserInput() {
        ExpressionInput input = ExpressionInput.create(new Scanner(System.in));
        ExpressionInputView view = ExpressionInputView.publish(input);
        view.render();
        return view.toInputData();
    }
}
