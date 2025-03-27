package calculator.domain;

import java.util.ArrayDeque;
import java.util.Deque;

import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator {
	private final InputView inputView;
	private final OutputView outputView;
	private Deque<Operand> operands = new ArrayDeque<>();
	private Deque<Operator> operators = new ArrayDeque<>();

	public Calculator(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void startCalculation() {
		String[] values = inputView.readAndSplitInput();
		for (int i = 0; i < values.length; i++) {
			addDeque(i, values[i]);
		}
		int result = calculateOutput();
		outputView.printOutput(result);
	}

	public int calculateOutput() {
		while (!operators.isEmpty()) {
			applyOperator();
		}
		return operands.peekFirst()
			.getNumber();
	}

	private void addDeque(int index, String value) {
		if (index % 2 == 0) {
			operands.add(new Operand(Integer.parseInt(value)));
			return;
		}
		operators.add(Operator.fromSymbol(value));
	}

	private void applyOperator() {
		Operand first = operands.pollFirst();
		Operand second = operands.pollFirst();
		Operator operator = operators.pollFirst();
		int result = operator.apply(first.getNumber(), second.getNumber());
		operands.addFirst(new Operand(result));
	}

}
