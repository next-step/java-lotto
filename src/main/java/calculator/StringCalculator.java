package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class StringCalculator {
    public static void main(String[] args) {
        InputView inputView = new InputView("2 + 3 * 4 / 2");
        List<Double> operands = inputView.getOperands();
        List<String> operators = inputView.getOperators();

        Double result = calculate(operands, operators);

        OutputView outputView = new OutputView(result);
        outputView.print();
    }

    public static Double calculate(List<Double> operands, List<String> operators) {
        Double result = 0.0;

        Calculator calculator = new Calculator();
        result = operands.get(0);
        for (int i = 1; i < operands.size(); i++){
            result = calculator.calculate(result, operators.get(i-1), operands.get(i));
        }
        return result;
    }
}
