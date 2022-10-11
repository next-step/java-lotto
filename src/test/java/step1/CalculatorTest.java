package step1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {
	@Test
	@DisplayName("첫번째 수 결과에 삽입")
	void calculate() {
		Calculator calculator = new Calculator("1 + 2 + 3");
		assertThat(calculator.getResult()).isEqualTo(1);
	}

	@Test
	@DisplayName("첫번째 수 공백일 때 예외")
	void validBlank() {
		assertThatThrownBy(() -> new Calculator("  + 2 + 3"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("덧셈테스트")
	void plus() {
		Calculator calculator = new Calculator("1 + 2");
		assertThat(calculator.start()).isEqualTo(3);
	}

	@Test
	@DisplayName("뺄셈테스트")
	void minus() {
		Calculator calculator = new Calculator("1 - 2");
		assertThat(calculator.start()).isEqualTo(-1);
	}

	@Test
	@DisplayName("곱셈테스트")
	void multiple() {
		Calculator calculator = new Calculator("1 * 2");
		assertThat(calculator.start()).isEqualTo(2);
	}

	@Test
	@DisplayName("나눗셈테스트")
	void divide() {
		Calculator calculator = new Calculator("2 / 1");
		assertThat(calculator.start()).isEqualTo(2);
	}

	@Test
	@DisplayName("0으로 나눗셈테스트")
	void divideByZero() {
		Calculator calculator = new Calculator("2 / 0");
		assertThatThrownBy(calculator::start)
			.isInstanceOf(ArithmeticException.class);
	}
}
