package step1.model.number;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import step1.exception.BadRequestException;

class NumberTest {
	final Number number = new Number("2");

	@DisplayName("숫자가 아니면 예외를 던진다.")
	@Test
	void Given_NotNumber_Then_ThrowException() {

		assertThatThrownBy(() -> new Number("k")).isInstanceOf(BadRequestException.class);
	}

	@DisplayName("숫자이면 예외를 던지지 않는다.")
	@ParameterizedTest(name = "{index} {displayName}")
	@ValueSource(strings = {"0", "1", "10", "999"})
	void Given_Number_Then_ReturnOperator(String number) {
		assertDoesNotThrow(() -> new Number(number));
	}

	@DisplayName("plus 메서드 실행시, 합 연산이 일어난다.")
	@Test
	void Given_Add_Then_Add() {
		number.plus(1);

		assertThat(number.getValue()).isEqualTo(3);
	}

	@DisplayName("minus 메서드 실행시, 차 연산이 일어난다.")
	@Test
	void Given_Minus_Then_ExecuteMinusMethod() {
		number.minus(1);

		assertThat(number.getValue()).isEqualTo(1);
	}

	@DisplayName("multiply 메서드 실행시, 곱 연산이 일어난다.")
	@Test
	void Given_Multiply_Then_ExecuteMultiplyMethod() {
		number.multiply(2);

		assertThat(number.getValue()).isEqualTo(4);
	}

	@DisplayName("divide 메서드 실행시, 나누기 연산이 일어난다.")
	@Test
	void Given_Divide_Then_ExecuteDivideMethod() {
		number.divide(1);

		assertThat(number.getValue()).isEqualTo(2);
	}
}