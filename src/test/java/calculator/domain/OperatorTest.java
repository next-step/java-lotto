package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import java.text.MessageFormat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import calculator.exception.ErrorMessage;
import calculator.exception.OperatorInvalidException;

public class OperatorTest {
	public static final int NUMBER_FOUR = 4;
	public static final int NUMBER_TWO = 2;

	@DisplayName("사칙 연산 정상 테스트")
	@ParameterizedTest
	@CsvSource(value = {"+:6", "-:2", "*:8", "/:2"}, delimiter = ':')
	void operateSuccess(String operator, int expected) {
		assertThat(Operator.findBySymbol(operator)
			.operate(NUMBER_FOUR, NUMBER_TWO))
			.isEqualTo(expected);
	}

	@DisplayName("연산자 찾기 예외 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"!", "@", "#", "$"})
	void findBySymbolFail(String value) {
		assertThatThrownBy(() -> {
			Operator.findBySymbol(value);
		}).isInstanceOf(OperatorInvalidException.class)
			.hasMessageContaining(MessageFormat.format(ErrorMessage.INVALID_OPERATOR.getMessage(), value));
	}

	@DisplayName("연산자 찾기 정상 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"+", "-", "*", "/"})
	void findBySymbolSuccess(String value) {
		assertThatCode(() -> {
			Operator.findBySymbol(value);
		}).doesNotThrowAnyException();
	}
}
