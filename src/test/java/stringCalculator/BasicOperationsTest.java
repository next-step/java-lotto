package stringCalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BasicOperationsTest {

	@Test
	@DisplayName("사칙 연산 기호를 찾아 반환합니다.")
	void return_matched_basic_operation() {
		assertThat(BasicOperations.match("+")).isEqualTo(BasicOperations.PLUS);
		assertThat(BasicOperations.match("-")).isEqualTo(BasicOperations.SUBTRACT);
		assertThat(BasicOperations.match("*")).isEqualTo(BasicOperations.MULTIPLY);
		assertThat(BasicOperations.match("/")).isEqualTo(BasicOperations.DIVIDE);
	}

	@Test
	@DisplayName("사칙 연산 기호에 따른 연산을 합니다.")
	void calculate_numbers() {
		assertThat(BasicOperations.PLUS.calculate(6,2)).isEqualTo(8);
		assertThat(BasicOperations.SUBTRACT.calculate(6,2)).isEqualTo(4);
		assertThat(BasicOperations.MULTIPLY.calculate(6,2)).isEqualTo(12);
		assertThat(BasicOperations.DIVIDE.calculate(6,2)).isEqualTo(3);
	}

	@Test
	@DisplayName("사칙 연산 기호가 아닐시 IllegalArgumentException을 던진다.")
	void is_not_basic_operations() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> BasicOperations.match("1"));
	}
}
