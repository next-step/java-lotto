package calculator.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	@DisplayName("문자열 계산기: 객체 생성 및 전체 계산 테스트")
	void calculateAllTest() {

		Expression expression = new Expression("//;\n1;2:3;4:5;6,7,8;9");
		Calculator calculator = new Calculator(expression);

		assertThat(calculator.getSum()).isEqualTo(45);
	}
}
