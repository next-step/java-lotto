package step1.calculator.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step1.calculator.domain.Operator;

public class OperatorTest {
	@DisplayName("연산자를 생성할 때 수학 기호를 제외한 문자열 값들은 예외처리 되어야 한다.")
	@Test
	void 잘못된_입력값_예외처리() {
		assertThatThrownBy(() -> Operator.from("a"))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
