package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SeparatorTest {

	@DisplayName("구분자 또는 커스텀 구분자로 입력 값을 구분한다")
	@ParameterizedTest
	@MethodSource("ExactedResult")
	void CUSTOM_SPLIT_TEST(String input, List<String> expected) {
		assertThat(new Separator(input).getSeparatedText()).isEqualTo(expected);
	}

	public static Stream<Arguments> ExactedResult() {
		return Stream.of(
			Arguments.of("//:\n1:2:3", Arrays.asList("1", "2", "3")),
			Arguments.of("//a\n10a20a30", Arrays.asList("10", "20", "30")),
			Arguments.of("//&\n10&20&100", Arrays.asList("10", "20", "100")),
			Arguments.of("1,2,3,4,5", Arrays.asList("1", "2", "3", "4", "5")),
			Arguments.of("100,200,300", Arrays.asList("100", "200", "300")));
	}
}
