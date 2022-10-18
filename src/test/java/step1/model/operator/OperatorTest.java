package step1.model.operator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import step1.exception.BadRequestException;
import step1.model.number.Number;

class OperatorTest {

	@DisplayName("연산자가 아니면 예외를 던진다.")
	@Test
	void Given_NotOperator_Then_ThrowException() {

		assertThatThrownBy(() -> new Operator("k")).isInstanceOf(BadRequestException.class);
	}

	@DisplayName("연산자이면 예외를 던지지 않는다.")
	@ParameterizedTest(name = "{index} {displayName}")
	@ValueSource(strings = {"+", "-", "*", "/"})
	void Given_Operator_Then_ReturnOperator(String string) {
		assertDoesNotThrow(() -> new Operator(string));
	}

	@DisplayName("연산자가 + 이면 add 메서드가 실행된다.")
	@Test
	void Given_Plus_Then_ExecuteAddMethod() {
		Number number = new Number("1");
		Operator operator = new Operator("+");

		operator.operate(1, number);

		assertThat(number.getValue()).isEqualTo(2);
	}

	@DisplayName("연산자가 - 이면 minus 메서드가 실행된다.")
	@Test
	void Given_Minus_Then_ExecuteMinusMethod() {
		Number number = new Number("1");
		Operator operator = new Operator("-");

		operator.operate(1, number);

		assertThat(number.getValue()).isEqualTo(0);
	}

	@DisplayName("연산자가 * 이면 multiply 메서드가 실행된다.")
	@Test
	void Given_Multiply_Then_ExecuteMultiplyMethod() {
		Number number = new Number("1");
		Operator operator = new Operator("*");

		operator.operate(2, number);

		assertThat(number.getValue()).isEqualTo(2);
	}

	@DisplayName("연산자가 / 이면 divide 메서드가 실행된다.")
	@Test
	void Given_Divide_Then_ExecuteDivideMethod() {
		Number number = new Number("4");
		Operator operator = new Operator("/");

		operator.operate(1, number);

		assertThat(number.getValue()).isEqualTo(4);
	}
}