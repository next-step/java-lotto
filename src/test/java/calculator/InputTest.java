package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class InputTest {

	@Test
	@DisplayName("입력 값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException throw")
	void input_blank() {
		assertThatThrownBy(() -> {
			new Calculator(null);
		}).isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> {
			new Calculator(Arrays.asList(" "));
		}).isInstanceOf(IllegalArgumentException.class);
	}

}
