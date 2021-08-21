package calculator;

import static calculator.CalculatorContext.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorContextTest {

	@Test
	@DisplayName("수식과 구분자를 분리")
	void expressionAndDelimiter() {
		CalculatorContext context = new CalculatorContext("//;\n1;2;3");
		CalculatorExpression expression = context.expression();
		CalculatorDelimiter delimiter = context.delimiter();

		assertThat(expression).isEqualTo(new CalculatorExpression("1;2;3"));

		assertThat(delimiter).isEqualTo(new CalculatorDelimiter(";"));
	}

	@Test
	@DisplayName("커스텀 구분자가 없을 경우")
	void noCustomDelimiter() {
		CalculatorContext context = new CalculatorContext("1,2,3");
		CalculatorExpression expression = context.expression();
		CalculatorDelimiter delimiter = context.delimiter();

		assertThat(expression).isEqualTo(new CalculatorExpression("1,2,3"));

		assertThat(delimiter).isEqualTo(new CalculatorDelimiter(DEFAULT_DELIMITER));
	}

	@Test
	@DisplayName("널일경우")
	void nullTest() {
		CalculatorContext context = new CalculatorContext(null);
		CalculatorExpression expression = context.expression();

		assertThat(expression).isEqualTo(new CalculatorExpression(ZERO));
	}

	@Test
	@DisplayName("빈문자열일경우")
	void zeroTest() {
		CalculatorContext context = new CalculatorContext("");
		CalculatorExpression expression = context.expression();

		assertThat(expression).isEqualTo(new CalculatorExpression(ZERO));
	}
}
