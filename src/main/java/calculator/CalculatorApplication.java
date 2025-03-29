package calculator;

import java.util.List;

import calculator.domain.Calculator;
import calculator.domain.Operand;
import calculator.domain.Operator;
import calculator.domain.Parser;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorApplication {
	public static void main(String[] args) {
		InputView inputView = new InputView();
		OutputView outputView = new OutputView();
		Parser parser = new Parser();

		String[] tokens = parser.splitString(inputView.getInput());
		List<Operand> operands = parser.parseOperand(tokens);
		List<Operator> operators = parser.parseOperator(tokens);

		Calculator calculator = new Calculator(operands, operators);
		outputView.printOutput(calculator.calculateOutput());
	}
}
