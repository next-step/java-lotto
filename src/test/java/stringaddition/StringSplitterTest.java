package stringaddition;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringSplitterTest {

	private StringSplitter splitter;

	@BeforeEach
	void setUp() {
		splitter = new StringSplitter();
	}

	@ParameterizedTest(name = "지정된 기본 구분자로 문자열 분리 {index} [{arguments}]")
	@MethodSource(value = "splitStrings")
	@DisplayName("지정된 기본 구분자로 문자열 분리")
	void split(String text, String[] texts) throws Exception {
		//given

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
				Arguments.of("1", new String[]{"1"}),
				Arguments.of(",", new String[]{}),
				Arguments.of(",,", new String[]{})
		);
	}

	@ParameterizedTest(name = "빈 문자열 {index} [{arguments}]")
	@MethodSource(value = "nullOrBlank")
	@DisplayName("null 또는 빈 문자열인 경우 0 반환")
	void null_or_blank_text(String text) throws Exception {
		//given

		//when
		String[] result = splitter.split(text);

		//then
		assertThat(result).containsExactly("0");

	}

	private static Stream<Arguments> nullOrBlank() {
		return Stream.of(
				Arguments.of((String)null),
				Arguments.of(""),
				Arguments.of(" ")
		);
	}

	@ParameterizedTest(name = "음수 포함 여부 {index} [{arguments}]")
	@ValueSource(strings = {
			"-1",
			"1,2:3,-4"
	})
	@DisplayName("음수를 포함한 문자열을 입력한 경우 RuntimeException")
	void negative_text(String text) throws Exception {
		//given

		//when, then
		assertThatThrownBy(() -> splitter.split(text)).isInstanceOf(NationalNumberException.class)
		                                              .hasMessage("음수를 포함한 문자열은 계산할 수 없습니다.");

	}

	@ParameterizedTest(name = "숫자가 아닌 문자 포함 여부 {index} [{arguments}]")
	@ValueSource(strings = {
			"일,이",
			"1:2,삼"
	})
	@DisplayName("숫자가 아닌 문자를 포함한 문자열을 입력한 경우 RuntimeException")
	void wrong_text(String text) throws Exception {
		//given

		//when, then
		assertThatThrownBy(() -> splitter.split(text)).isInstanceOf(NationalNumberException.class)
		                                              .hasMessage("숫자가 아닌 문자를 포함하는 문자열은 계산할 수 없습니다.");

	}

	@ParameterizedTest
	@MethodSource("customDelimiters")
	@DisplayName("커스텀 구분자로 분리하여 문자열 반환")
	void custom_delimiter(String customDelimiter) throws Exception {
		//given

		//when
		String[] split = splitter.split(customDelimiter);

		//then
		assertThat(split).containsExactly("1", "2", "3");
	}

	private static Stream<Arguments> customDelimiters() {
		return Stream.of(
				Arguments.of("//;\n1;2;3"),
				Arguments.of("//_\n1_2_3"),
				Arguments.of("///\n1/2/3")
		);
	}

}
