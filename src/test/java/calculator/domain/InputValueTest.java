package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class InputValueTest {

	@DisplayName("입력값은 문자나 음수를 허용하지 않는다.")
	@Test
	void 숫자_요구사항_테스트() {
		assertThatThrownBy(() -> new InputValue("-1"))
			.isInstanceOf(RuntimeException.class)
			.hasMessage("음수를 입력할수 없습니다.");

		assertThatThrownBy(() -> new InputValue("a"))
			.isInstanceOf(NumberFormatException.class);
	}

}
