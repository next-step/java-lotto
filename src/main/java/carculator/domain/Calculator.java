package carculator.domain;

import carculator.domain.token.Operand;
import carculator.domain.token.Operator;
import carculator.domain.token.Token;
import carculator.view.input.InputView;
import carculator.view.output.OutputView;

import java.util.List;

public class Calculator {

    InputView inputView;
    OutputView outputView;

    public Calculator(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<Token> tokens = inputView.getTokens();
        Integer result = 0;

        for (int i = 0; i < tokens.size() - 1; i += 2) {
            Operand operand = (Operand) tokens.get(i);
            Operator operator = (Operator) tokens.get(i + 1);

            result += operator.apply(new Operand(result), operand);
        }

        outputView.printResult(result);
    }

}
