package calculator;

import calculator.domain.Calculator;
import calculator.domain.Operand;
import calculator.domain.Operator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class StringCalculator {
    public static void main(String[] args) {
        InputView inputView = new InputView("2 + 3 * 4 / 2");
        List<Operand> operands = inputView.getOperands();
        List<Operator> operators = inputView.getOperators();

        Double result = calculate(operands, operators);

        OutputView outputView = new OutputView(result);
        outputView.print();
    }

    public static Double calculate(List<Operand> operands, List<Operator> operators) {
        Double result;


        result = operands.get(0).getOperand();
        for (int i = 1; i < operands.size(); i++){
            Calculator calculator = new Calculator(result, operators.get(i-1).getOperator(), operands.get(i).getOperand());
            result = calculator.calculate();
        }

        return result;
    }
}
