package calculator.view;

import static org.assertj.core.api.Assertions.*;

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
}
