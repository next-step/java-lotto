package calculator.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OperatorTest {
	@Test
	@DisplayName("덧셈 연산 테스트")
	void addTest() {
		assertEquals(5, Operator.ADD.apply(2, 3));
	}

	@Test
	@DisplayName("뺄셈 연산 테스트")
	void subtractTest() {
		assertEquals(-1, Operator.SUBTRACT.apply(2, 3));
	}

	@Test
	@DisplayName("곱셈 연산 테스트")
	void multiplyTest() {
		assertEquals(6, Operator.MULTIPLY.apply(2, 3));
		assertEquals(0, Operator.MULTIPLY.apply(2, 0));
	}

	@Test
	@DisplayName("나눗셈 연산 테스트 - 결과 값이 정수로 떨어진다.")
	void divideTest_returnsInteger() {
		assertEquals(2, Operator.DIVIDE.apply(4, 2));
		assertEquals(1, Operator.DIVIDE.apply(3, 2));
	}

	@Test
	@DisplayName("나눗셈 연산 테스트 - 0으로 나누면 예외가 발생한다.")
	void divideTest_divideByZero() {
		assertThatExceptionOfType(ArithmeticException.class)
			.isThrownBy(() -> Operator.DIVIDE.apply(2, 0));
	}

	@ParameterizedTest
	@DisplayName("올바른 Operator를 찾는다.")
	@CsvSource({
		"+, ADD",
		"- , SUBTRACT",
		"*, MULTIPLY",
		"/, DIVIDE"
	})
	void findOperatorTest(String symbol, Operator expected) {
		assertEquals(expected, Operator.fromSymbol(symbol));
	}

	@Test
	@DisplayName("잘못된 연산자를 입력하면 예외가 발생한다.")
	void fromSymbolTest() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Operator.fromSymbol("%"))
			.withMessageContaining("사용할 수 없는 연산자 입니다 : %");
	}

}
