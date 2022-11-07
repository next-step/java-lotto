package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.domain.Lotto;
import lotto.domain.Reward;
import lotto.domain.WinningLotto;

class RewardTest {

	static Stream<Arguments> providerOfSecondPlaceLottos() {
		return Stream.of(
			Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 44, 45), 5),
			Arguments.arguments(List.of(1, 2, 3, 4, 6, 7), List.of(1, 2, 3, 4, 44, 45), 6),
			Arguments.arguments(List.of(1, 2, 3, 4, 7, 8), List.of(1, 2, 3, 4, 44, 45), 7),
			Arguments.arguments(List.of(1, 2, 3, 4, 8, 9), List.of(1, 2, 3, 4, 44, 45), 8),
			Arguments.arguments(List.of(1, 2, 3, 4, 9, 10), List.of(1, 2, 3, 4, 44, 45), 9),
			Arguments.arguments(List.of(1, 2, 3, 4, 10, 11), List.of(1, 2, 3, 4, 44, 45), 10)
		);
	}

	@DisplayName("총 일치 숫자 5개 중 1개가 보너스 숫자면 2등이다.")
	@ParameterizedTest
	@MethodSource("providerOfSecondPlaceLottos")
	void Should_Be_Second_Place_When_Provided_Matching_Numbers_Of_Five_With_Bonus_Number(List<Integer> numbers,
		List<Integer> winningNumbers, int bonusNumber) {
		Lotto lotto = new Lotto(numbers);
		WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

		assertThat(lotto.getMatchingCount(winningLotto.getWholeNumbers())).isEqualTo(5);
		assertThat(Reward.getRewardByMatchCount(winningLotto.getWholeNumbers().lotto.hasBonusNumber())).is(
			Reward.SECOND);
	}
}
