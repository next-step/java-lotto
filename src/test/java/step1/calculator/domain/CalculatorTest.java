package step1.calculator.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class CalculatorTest {
	private Calculator calculator;

	@BeforeEach
	void setUp() {
		this.calculator = Calculator.create();
	}

	@ParameterizedTest
	@NullAndEmptySource
	void 빈문자열_혹은_null_예외처리(String nullOrEmpty) {
		assertThatThrownBy(() -> calculator.put(nullOrEmpty))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 문자열_피연산자_연산자_구분() {
		calculator.put("1 + 1 - 0");

		assertAll(
			() -> assertThat(calculator.getOperands()).isNotNull(),
			() -> assertThat(calculator.getOperators()).isNotNull()
		);
	}

	@Test
	void 분모가_0인_나눗셈_예외처리() {
		calculator.put("10 / 0");

		assertThatThrownBy(() -> calculator.calculate())
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 숫자가_아닌_문자열_예외처리() {
		calculator.put("10 / 0");

		assertThatThrownBy(() -> calculator.calculate())
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 피연산자_하나() {
		calculator.put("1");

		assertThat(calculator.calculate()).isEqualTo(1);
	}

	@Test
	void 덧셈() {
		calculator.put("1 + 2 + 3");

		assertThat(calculator.calculate()).isEqualTo(6);
	}

	@Test
	void 뺄셈() {
		calculator.put("4 - 5 - 6");

		assertThat(calculator.calculate()).isEqualTo(-7);
	}

	@Test
	void 곱셈() {
		calculator.put("7 * 8");

		assertThat(calculator.calculate()).isEqualTo(56);
	}

	@Test
	void 나눗셈() {
		calculator.put("10 / 5");

		assertThat(calculator.calculate()).isEqualTo(2);
	}
}
