package nextstep.step2.domain;

import org.junit.jupiter.api.DisplayName;
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

	private static Stream<Arguments> provideReward() {
		return Stream.of(
				Arguments.of(LottoReward.getReword(6), LottoReward.FIRST),
				Arguments.of(LottoReward.getReword(5), LottoReward.SECOND),
				Arguments.of(LottoReward.getReword(4), LottoReward.FOURTH),
				Arguments.of(LottoReward.getReword(3), LottoReward.FIFTH),
				Arguments.of(LottoReward.getReword(0), LottoReward.LOST)
		);
	}
}
