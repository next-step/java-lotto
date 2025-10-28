package ui;

import domain.Operand;
import domain.Operator;

public class StringCalculator {
    public final InputView inputView;
    public final OutputView outputView;
    Operator operator;

    public StringCalculator(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
    public int calculate(String input) {
        String[] tokens = inputView.readAndSplitInput(input);
        return evaluate(tokens);
    }

    private int evaluate(String[] tokens) {
        int result = Integer.parseInt(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            Operator operator = Operator.fromSymbol(tokens[i]);
            Operand operand = new Operand(Integer.parseInt(tokens[i + 1]));
            result = applyOperation(result, operator, operand);
        }
        return result;
    }

    private int applyOperation(int left, Operator operator, Operand operand) {
        return operator.operate(left, operand.getNumber());
    }
}