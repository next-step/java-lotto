package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {

	private final Queue<Number> numbers;

	private final Queue<Operator> operators;

	public Calculator() {
		this.numbers = new LinkedList<>();
		this.operators = new LinkedList<>();
	}

	// 분류된 값들을 가지고 최종 계산 수행
	public int calculate(Formula formula) {
		classifyFormula(formula);

		int result = numbers.poll().getValue();

		while (!operators.isEmpty()) {
			int num = numbers.poll().getValue();
			Operator operator = operators.poll();

			result = operator.operate(result, num);
		}

		return result;
	}

	private void classifyFormula(Formula formula) {
		numbers.add(new Number(formula.get()));
		while (!formula.isEnd()) {
			operators.add(Operator.of(formula.get()));
			numbers.add(new Number(formula.get()));
		}
	}

}
