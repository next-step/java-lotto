package step3.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.utils.StringUtils;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

	@DisplayName("콤마로 분리 테스트")
	@ParameterizedTest
	@MethodSource("provide")
	void testRemoveSpace(String input, String[] expect) {
		assertThat(StringUtils.splitByDelimiter(input)).isEqualTo(expect);
	}

	static Stream<Arguments> provide() {
		return Stream.of(
				Arguments.of("1,2,3", new String[]{"1","2","3"}),
				Arguments.of("1 ,2, 3 ", new String[]{"1","2","3"})
		);
	}
}
