package nextstep.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRewardTest {

	@ParameterizedTest
	@DisplayName("로또 리워드를 얻을 수 있다.")
	@MethodSource("provideReward")
	public void getRewordTest(LottoReward lottoReward, LottoReward expected) {
		assertThat(lottoReward).isEqualTo(expected);
	}

	@Test
	@DisplayName("로또 2등은 보너스번호를 가지고 있어야 한다")
	public void findLottoRewardByBonusTest() {
		assertThat(LottoReward.findLottoRewardByBonus(LottoReward.SECOND, true)).isEqualTo(LottoReward.SECOND);
		assertThat(LottoReward.findLottoRewardByBonus(LottoReward.SECOND, false)).isEqualTo(LottoReward.THIRD);
		assertThat(LottoReward.findLottoRewardByBonus(LottoReward.THIRD, false)).isEqualTo(LottoReward.THIRD);
		assertThat(LottoReward.findLottoRewardByBonus(LottoReward.THIRD, true)).isEqualTo(LottoReward.THIRD);
	}

	private static Stream<Arguments> provideReward() {
		return Stream.of(
				Arguments.of(LottoReward.getReword(6, false), LottoReward.FIRST),
				Arguments.of(LottoReward.getReword(5, true), LottoReward.SECOND),
				Arguments.of(LottoReward.getReword(5, false), LottoReward.THIRD),
				Arguments.of(LottoReward.getReword(4, false), LottoReward.FOURTH),
				Arguments.of(LottoReward.getReword(3, false), LottoReward.FIFTH),
				Arguments.of(LottoReward.getReword(2, true), LottoReward.LOST),
				Arguments.of(LottoReward.getReword(1, false), LottoReward.LOST),
				Arguments.of(LottoReward.getReword(0, true), LottoReward.LOST)
		);
	}
}
