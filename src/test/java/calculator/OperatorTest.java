package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class OperatorTest {

	@DisplayName("사칙연산 연산자인지 확인")
	@ValueSource(strings = {"+","-","/","*"})
	@ParameterizedTest
	public void checkOperatorTest(String value) {

		assertThat(Operator.containCode(value))
			.isTrue();
	}

	@DisplayName("사칙연산 연산자아닌지 확인")
	@ValueSource(strings = {"%","#","123","5*"})
	@ParameterizedTest
	public void checkNotOperatorTest(String value) {

		assertThat(Operator.containCode(value))
			.isFalse();
	}

	@DisplayName("사칙연산 연산자 찾기")
	@CsvSource(value = {"+:PLUS","-:MINUS","/:DIVISION","*:MULTIPLICATION"}, delimiter = ':')
	@ParameterizedTest
	public void checkOperatorReturnTest(String value, String expectedOperator) {

		assertThat(Operator.valueOfCode(value).name())
			.isEqualTo(expectedOperator);
	}

	@DisplayName("사칙연산 연산자 찾을 때 없는 경우 RuntimeException 발생")
	@ValueSource(strings = {"%","#","123","5*"})
	@ParameterizedTest
	public void checkOperatorReturnIllegalArgumentExceptionTest(String value) {

		assertThatThrownBy(() -> Operator.valueOfCode(value))
			.isInstanceOf(IllegalArgumentException.class);
	}
}