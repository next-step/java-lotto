package step1.calculator.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step1.calculator.domain.Operand;

public class OperandTest {
	@DisplayName("피연산자를 생성할 때 빈 문자열 혹은 null 은 예외처리 되어야 한다.")
	@Test
	void 잘못된_입력값_예외처리() {
		assertAll(
			() -> assertThatThrownBy(() -> Operand.from(null))
				.isInstanceOf(IllegalArgumentException.class),
			() -> assertThatThrownBy(() -> Operand.from(""))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}
}
