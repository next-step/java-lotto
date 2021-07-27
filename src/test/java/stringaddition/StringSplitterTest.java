package stringaddition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StringSplitterTest {

	@ParameterizedTest(name = "지정된 기본 구분자로 문자열 분리 {index} [{arguments}]")
	@MethodSource(value = "splitStrings")
	@DisplayName("지정된 기본 구분자로 문자열 분리")
	void split(String text, String[] texts) throws Exception {
		//given
		StringSplitter splitter = new StringSplitter();

		//when
		String[] result = splitter.split(text);

		//then
		assertThat(result).containsExactly(texts);

	}

	private static Stream<Arguments> splitStrings() {
		return Stream.of(
				Arguments.of("1,2:3", new String[]{"1", "2", "3"}),
				Arguments.of("1:2:3", new String[]{"1", "2", "3"}),
				Arguments.of("1,2,3", new String[]{"1", "2", "3"}),
				Arguments.of("1,2 3", new String[]{"1", "2 3"}),
				Arguments.of(":123,", new String[]{"", "123"}),
				Arguments.of("1", new String[]{"1"}),
				Arguments.of(",", new String[]{}),
				Arguments.of(",,", new String[]{})
		);
	}

}
