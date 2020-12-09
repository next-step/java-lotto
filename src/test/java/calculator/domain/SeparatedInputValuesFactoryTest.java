package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class SeparatedInputValuesFactoryTest {

	@DisplayName("문자열 합계 테스트")
	@ParameterizedTest
	@MethodSource("ExactedResult")
	void CUSTOM_SPLIT_SUM_TEST(String input, int expected) {
		SeparatedInputValuesFactory factory = new SeparatedInputValuesFactory(input);
		assertThat(factory.getSeparatedInputValues().sum()).isEqualTo(expected);
	}

	public static Stream<Arguments> ExactedResult() {
		return Stream.of(
			Arguments.of("//:\n1:2:3", 6),
			Arguments.of("//a\n10a20a30", 60),
			Arguments.of("//&\n10&20&100", 130),
			Arguments.of("1,2,3,4,5", 15),
			Arguments.of("100,200,300", 600));
	}
}
