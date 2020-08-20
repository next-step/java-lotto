package lotto.constants;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static lotto.constants.PrizeGrade.*;

class PrizeGradeTest {

	@DisplayName("객체 생성 테스트")
	@ParameterizedTest
	@MethodSource("provide")

	void testConstruct(int matchCount, boolean isBonusMatch, PrizeGrade result) {
		assertThat(PrizeGrade.of(matchCount, isBonusMatch)).isEqualTo(result);
	}

	static Stream<Arguments> provide() {
		return Stream.of(
				Arguments.of(3, false, FIFTH),
				Arguments.of(4, false, FOURTH),
				Arguments.of(5, false, THIRD),
				Arguments.of(5, true, SECOND),
				Arguments.of(6, false, FIRST),
				Arguments.of(6, true, FIRST)
		);
	}
}
