package calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class StringSeparatorTest {

	@Test
	void 부여된_DELIMITER에_따라_문자열을_분해한다() {
		StringSeparator separator = new BlankSeparator();
		String input = "1 + 2 + 3";

		List<String> actual = separator.separate(input);
		List<String> expected = List.of(input.split(BlankSeparator.DELIMITER));

		assertThat(actual).isEqualTo(expected);
	}

	@ParameterizedTest
	@NullAndEmptySource
	void null_또는_공백문자_입력_시_IllegalArgumentException를_던진다(String input) {
		StringSeparator separator = new BlankSeparator();

		assertThatIllegalArgumentException().isThrownBy(() -> {
			separator.separate(input);
		});
	}

}
