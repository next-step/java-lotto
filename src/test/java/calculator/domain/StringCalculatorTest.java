package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import java.text.MessageFormat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.exception.ErrorMessage;
import calculator.exception.OperatorInvalidException;

public class StringCalculatorTest {
	private Calculator calculator = new StringCalculator();

	@DisplayName("계산기 정상 계산 테스트")
	@Test
	void calculateSuccess() {
		int actualResult = calculator.calculate("2 + 3 - 1 * 4 / 2");
		assertThat(actualResult).isEqualTo(8);
	}

	@DisplayName("계산기 연산자 예외 테스트")
	@Test
	void calculateFail() {
		String testExpression = "2 & 4 * 4 / 2";
		assertThatThrownBy(() -> {
			calculator.calculate(testExpression);
		}).isInstanceOf(OperatorInvalidException.class)
			.hasMessage(MessageFormat.format(ErrorMessage.INVALID_OPERATOR.getMessage(), "&"));
	}
}
