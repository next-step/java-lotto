package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.domain.Expression;

public class ExpressionTest {
	private Expression expression;

	@BeforeEach
	public void setUp() {
		String[] tokens = {"1", "+", "2", "*", "3", "/", "2", "-", "1"};
		expression = new Expression(tokens);
	}

	@DisplayName("표현식 생성")
	@Test
	public void createExpression() {
		assertThat(expression).isNotNull();
	}

	@DisplayName("표현식 계산")
	@Test
	public void calculateExpression() {
		int result = expression.calculate();
		assertThat(result).isEqualTo(3);
	}

}
