package carculator.domain;

import carculator.domain.token.Operand;
import carculator.domain.token.Operator;
import carculator.domain.token.Token;
import carculator.view.input.InputView;
import carculator.view.output.OutputView;

import java.util.List;

public class Calculator {

    public static final int TOKEN_STEP = 2;

    private final InputView inputView;
    private final OutputView outputView;

    private Integer result;

    public Calculator(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        result = 0;
    }

    public void run() {
        List<Token> tokens = parseInput();
        printResult(calculate(tokens));
    }

    private void printResult(Integer result) {
        outputView.printResult(result);
    }

    public Integer calculate(List<Token> tokens) {
        for (int i = 0; i < tokens.size() - 1; i += TOKEN_STEP) {
            this.result = calculateTokenPair(tokens, i);
        }
        return result;
    }

    private Integer calculateTokenPair(List<Token> tokens, int index) {
        Operand operand = (Operand) tokens.get(index);
        Operator operator = (Operator) tokens.get(index + 1);

        this.result += operator.apply(new Operand(result), operand);
        return result;
    }

    private List<Token> parseInput() {
        return inputView.getTokens();
    }

}
