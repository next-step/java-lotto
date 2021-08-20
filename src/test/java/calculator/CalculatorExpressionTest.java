package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorExpressionTest {

	@Test
	@DisplayName("덧셈 계산식")
	void expression() {
		CalculatorExpression expression = new CalculatorExpression("1;2;3");
		CalculatorNumber result = expression.resultNumber(new CalculatorDelimiter(";"));
		assertThat(result).isEqualTo(new CalculatorNumber(6));
	}

	@Test
	@DisplayName("널 테스트")
	void nullTest() {
		CalculatorExpression expression = new CalculatorExpression(null);
		CalculatorNumber result = expression.resultNumber(new CalculatorDelimiter(";"));
		assertThat(result).isEqualTo(new CalculatorNumber(0));
	}

	@Test
	@DisplayName("빈 문자열 테스트")
	void emptyTest() {
		CalculatorExpression expression = new CalculatorExpression("");
		CalculatorNumber result = expression.resultNumber(new CalculatorDelimiter(";"));
		assertThat(result).isEqualTo(new CalculatorNumber(0));
	}
}
