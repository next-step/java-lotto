package calculator.view;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {
	@ParameterizedTest
	@ValueSource(strings = {"", "   "})
	@DisplayName("입력 값이 빈 공백 문자일 경우 예외를 반환한다.")
	void validateInputTest_blankString(String input) {
		InputView inputView = new InputView();

		assertThatIllegalArgumentException()
			.isThrownBy(() ->
				inputView.validateInput(input)
			);
	}

	@Test
	@DisplayName("입력 값이 null 이면 예외를 반환한다.")
	void validateInputTest_NullString() {
		InputView inputView = new InputView();

		assertThatIllegalArgumentException()
			.isThrownBy(() ->
				inputView.validateInput(null)
			);
	}

	@Test
	@DisplayName("공백을 기준으로 문자열을 자른다.")
	void splitStringTest() {
		InputView inputView = new InputView();
		String input = "  2 +  3 * 4";
		String[] expected = {"2", "+", "3", "*", "4"};

		String[] result = inputView.splitString(input);

		assertArrayEquals(result, expected);
	}
}
