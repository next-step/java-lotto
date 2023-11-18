package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {
	@Test
	@DisplayName("run_덧셈 기호를 포함한 문자열_올바른 계산결과")
	void 덧셈() {
		Calculator calculator = new Calculator();
		assertThat(calculator.run("3 + 2 + 1")).isEqualTo(6);
	}

	@Test
	@DisplayName("run_뺄셈 기호를 포함한 문자열_올바른 계산결과")
	void 뺄셈() {
		Calculator calculator = new Calculator();
		assertThat(calculator.run("3 - 2 - 1")).isEqualTo(0);
	}

	@Test
	@DisplayName("run_곱셈 기호를 포함한 문자열_올바른 계산결과")
	void 곱셈() {
		Calculator calculator = new Calculator();
		assertThat(calculator.run("3 * 2 * 1")).isEqualTo(6);
	}

	@Test
	@DisplayName("run_나눗셈 기호를 포함한 문자열_올바른 계산결과")
	void 나눗셈() {
		Calculator calculator = new Calculator();
		assertThat(calculator.run("3 / 2 / 2")).isEqualTo(0);
	}

	@Test
	@DisplayName("run_사칙연산 전체 포함된 문자열_올바른 계산결과")
	void 복합계산() {
		Calculator calculator = new Calculator();
		assertThat(calculator.run("2 + 3 * 4 / 2 - 2")).isEqualTo(8);
	}

	@ParameterizedTest
	@NullAndEmptySource
	@DisplayName("run_null or 공백 문자_throw IllegalArgumentException")
	void 입력값_null_빈값(String input) {
		Calculator calculator = new Calculator();
		assertThatIllegalArgumentException().isThrownBy(() -> {
			calculator.run(input);
		}).withMessageMatching("입력값이 null이거나 빈 공백 문자입니다.");
	}
}
