package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import calculator.exception.InputNullOrBlankException;

public class ExpressionArgumentsTest {

	@DisplayName("표현식 null 또는 빈문자 예외 테스트")
	@ParameterizedTest
	@NullAndEmptySource
	void expressionIsNullOrBlankThrowException(String text) {
		assertThatThrownBy(() -> new ExpressionArguments(text))
			.isInstanceOf(InputNullOrBlankException.class);
	}
}
