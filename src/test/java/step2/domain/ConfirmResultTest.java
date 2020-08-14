package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import step2.constants.PrizeGrade;

import static org.assertj.core.api.Assertions.assertThat;

class ConfirmResultTest {

	@DisplayName("객체 생성 테스트")
	@ParameterizedTest
	@EnumSource(value = PrizeGrade.class, names = {"FAIL"}, mode = EnumSource.Mode.EXCLUDE)
	void testConstruct(PrizeGrade input) {
		assertThat(new ConfirmResult(input.getMatchCount())).isEqualTo(new ConfirmResult(input));
	}
}