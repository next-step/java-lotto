package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

	@DisplayName("숫자만 입력하면 입력숫자 그대로 종료")
	@CsvSource(value = {"5:5"}, delimiter = ':')
	@ParameterizedTest
	public void noOperatorInputTest(String value, int result) {
		Calculator calculator = new Calculator();

		assertThat(calculator.add(value))
			.isEqualTo(result);
	}

	@DisplayName("입력한 문자가 계산식에 해당하는 연산자가 아닌 경우")
	@ValueSource(strings = {"!","X","&","3"})
	@ParameterizedTest
	public void checkIncorrectOperatorTest(String value) {

		assertThat(Operator.containCode(value))
			.isFalse();
	}

	@DisplayName("입력한 문자가 정수도, 연산자도 아닌경우 RuntimeException 발생")
	@ValueSource(strings = {"!","X","&","123.43","Abc"})
	@ParameterizedTest
	public void checkIncorrectStringExceptionTest(String value) {
		Calculator calculator = new Calculator();

		assertThatThrownBy(() -> calculator.add(value))
			.isInstanceOf(RuntimeException.class);
	}

	@DisplayName("덧셈")
	@CsvSource(value = {"5 + 5:10"}, delimiter = ':')
	@ParameterizedTest
	public void plusTest(String value, int expected) {
		Calculator calculator = new Calculator();

		assertThat(calculator.calculate(value))
			.isEqualTo(expected);
	}

	@DisplayName("뺄셈")
	@CsvSource(value = {"5 - 5:0", "5 - 8:-3", "10 - 3:7"}, delimiter = ':')
	@ParameterizedTest
	public void minusTest(String value, int expected) {
		Calculator calculator = new Calculator();

		assertThat(calculator.calculate(value))
			.isEqualTo(expected);
	}

	@DisplayName("곱셈")
	@CsvSource(value = {"5 * 5:25", "5 * -8:-40", "-10 * 3:-30"}, delimiter = ':')
	@ParameterizedTest
	public void multiplicationTest(String value, int expected) {
		Calculator calculator = new Calculator();

		assertThat(calculator.calculate(value))
			.isEqualTo(expected);
	}

	@DisplayName("나눗셈")
	@CsvSource(value = {"5 / 5:1", "8 / -2:-4", "-3 / -1:3"}, delimiter = ':')
	@ParameterizedTest
	public void divisionTest(String value, int expected) {
		Calculator calculator = new Calculator();

		assertThat(calculator.calculate(value))
			.isEqualTo(expected);
	}

	@DisplayName("순차적으로 계산")
	@CsvSource(value = {"1 + 5 / 3:2", "1 - 5 / 4:-1", "5 / 1 * 3:15", "3 * 2 / 6:1"}, delimiter = ':')
	@ParameterizedTest
	public void arithmeticOperationTest(String value, int expected) {
		Calculator calculator = new Calculator();

		assertThat(calculator.calculate(value))
			.isEqualTo(expected);
	}
}
