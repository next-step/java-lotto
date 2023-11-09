import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
	@Test
	void inputExpression_validInput_throwsException() {
		String inputExpression = "2 + 3 - 4";
		String[] actual = inputExpression.split(" ");

		String[] expected = InputView.inputExpression(inputExpression);

		assertThat(actual).containsExactly(expected);
	}

	@ParameterizedTest
	@NullAndEmptySource
	void inputExpression_nullAndEmpty_throwsException(String emptyString) {
		assertThatThrownBy(
				() -> InputView.inputExpression(emptyString)
		).isInstanceOf(IllegalArgumentException.class);
	}
}
