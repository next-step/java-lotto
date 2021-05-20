package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

class StringSplitterTest {

	@DisplayName("null 이나 빈 문자열을 구분자로 전달하면 구분자 기본 값으로 문자열을 분리하는지 확인하는 테스트")
	@ParameterizedTest
	@NullAndEmptySource
	void default_delimiter(String delimiter) {
		// given
		String numberText = "1,2,3";

		// when
		StringSplitter separator = new StringSplitter(delimiter);

		// then
		assertThat(separator.split(numberText)).containsExactly("1", "2", "3");
	}

	@DisplayName("구분자를 지정해서 전달하면 숫자 패턴을 구분자로 문자열을 분리하는지 확인하는 테스트")
	@Test
	void custom_delimiter() {
		// given
		String delimiterText = "!";
		String numberText = "4!5!6";

		// when
		StringSplitter separator = new StringSplitter(delimiterText);

		// then
		assertThat(separator.split(numberText)).containsExactly("4", "5", "6");
	}

}
