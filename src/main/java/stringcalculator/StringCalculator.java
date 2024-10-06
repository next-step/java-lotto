package stringcalculator;

import stringcalculator.domain.operator.OperandParser;
import stringcalculator.domain.operator.Operator;
import stringcalculator.domain.operator.OperatorFactory;
import stringcalculator.view.InputView;
import stringcalculator.view.ResultView;

import java.util.List;

public class StringCalculator {
    private final InputView inputView;
    private final ResultView resultView;

    public StringCalculator(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        List<String> inputs = inputView.getInputsFromUser();
        int result = calculate(inputs);
        resultView.showResult(result);
    }

    public int calculate(List<String> inputs) {
        int result = OperandParser.parse(inputs.get(0));

        for (int i = 1; i < inputs.size(); i += 2) {
            Operator operator = OperatorFactory.getOperation(inputs.get(i));
            int firstOperand = result;
            int secondOperand = OperandParser.parse(inputs.get(i + 1));
            result = operator.calculate(firstOperand, secondOperand);
        }

        return result;
    }
}