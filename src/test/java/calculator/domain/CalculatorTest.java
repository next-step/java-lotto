package calculator.domain;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {
	@Test
	@DisplayName("올바른 계산 결과를 반환한다.")
	void calculateOutputTest() {
		// given
		List<Operand> operands = List.of(new Operand(2), new Operand(3), new Operand(4), new Operand(2));
		List<Operator> operators = List.of(Operator.ADD, Operator.MULTIPLY, Operator.DIVIDE);
		Calculator calculator = new Calculator(operands, operators);

		// when
		int result = calculator.calculateOutput();

		// then
		Assertions.assertEquals(result, 10);
	}
}
