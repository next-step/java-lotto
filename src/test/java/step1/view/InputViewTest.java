package step1.view;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
	private final InputView inputView = new InputView();
	private static final String BLANK = "\\s";

	@DisplayName("주어진 문자열을 구분자로 분리한다.")
	@Test
	void Given_String_Then_splitWithSeparator() {
		List<String> result = inputView.splitInput("a b c", BLANK);

		Assertions.assertThat(result).isEqualTo(List.of(new String[] {"a", "b", "c"}));
	}
}