package step1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

	@Test
	@DisplayName("숫자 검증 테스트")
	void validateNumber() {
		assertThatThrownBy(() -> Validator.validateNumber("-a"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("숫자만 계산할 수 있습니다");
	}

	@ParameterizedTest
	@DisplayName("사칙연산 기호 테스트")
	@ValueSource(strings = {"1", "a", "-b"})
	void validateSign(String input) {
		assertThatThrownBy(() -> Validator.validateSign(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("사칙연산 기호가 아닙니다");
	}
}
