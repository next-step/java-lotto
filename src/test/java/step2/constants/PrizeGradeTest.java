package step2.constants;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeGradeTest {

	@DisplayName("객체 생성 테스트")
	@ParameterizedTest
	@ValueSource(ints = {3, 4, 5, 6})
	void testConstruct(int matchCount) {
		assertThat(PrizeGrade.of(matchCount) != PrizeGrade.FAIL).isTrue();
	}
}