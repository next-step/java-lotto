package calculator;

import calculator.domain.Calculator;
import calculator.domain.Operand;
import calculator.domain.Operator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class StringCalculator {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<Operand> operands = inputView.getOperands();
        List<Operator> operators = inputView.getOperators();

        Double result = calculate(operands, operators);

        OutputView outputView = new OutputView(result);
    }

    public static Double calculate(List<Operand> operands, List<Operator> operators) {
        Operand result;

        result = operands.get(0);
        for (int i = 1; i < operands.size(); i++) {
            result = Calculator.calculate(
                    result,
                    operators.get(i - 1),
                    operands.get(i)
            );
        }
        return result.getOperand();
    }
}
