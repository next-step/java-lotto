package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OperatorTest {

	@ParameterizedTest(name = "특정 기호 {0}만 허용한다")
	@ValueSource(strings = {"+", "-", "*", "/"})
	void only_certain_operators_are_allowed(String operator) {
		assertThatNoException().isThrownBy(() -> new Operator(operator));
	}

	@ParameterizedTest(name = "허용되지 않은 사칙연산 기호 {0}는 오류를 발생시킨다")
	@ValueSource(strings = {"(", "&", "aa"})
	void not_allowed_operators_throws_exception(String operator) {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Operator(operator));
	}
}