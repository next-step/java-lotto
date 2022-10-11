package step1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SignTest {
	@ParameterizedTest
	@DisplayName("식 받아서 사친연산 기호 예외")
	@ValueSource(strings = {"1", ":", "?"})
	void separateValidateSign(String input) {
		assertThatThrownBy(() -> Sign.find(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("사칙연산 기호가 아닙니다");
	}
}
