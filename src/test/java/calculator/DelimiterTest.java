package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class DelimiterTest {

	@DisplayName("null 이나 빈 문자열을 전달하면 기본 구분자를 반환하는지 확인하는 테스트")
	@ParameterizedTest
	@NullAndEmptySource
	void get_default(String input) {
		// when
		Delimiter delimiter = new Delimiter(input);

		// then
		assertThat(delimiter.get()).isEqualTo(Delimiter.DEFAULT_DELIMITER);
	}

	@DisplayName("지정한 구분자를 전달하면 그 구분자를 그대로 반환하는지 확인하는 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"!", ",", ":"})
	void get(String input) {
		// when
		Delimiter delimiter = new Delimiter(input);

		// then
		assertThat(delimiter.get()).isEqualTo(input);
	}

}
