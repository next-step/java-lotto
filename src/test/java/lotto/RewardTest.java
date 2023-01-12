package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.domain.Lotto;
import lotto.domain.LottoNum;
import lotto.domain.Reward;
import lotto.domain.WinningLotto;

class RewardTest {

	static Stream<Arguments> providerOfSecondPlaceLottos() {
		return Stream.of(
			Arguments.arguments(
				Stream.of(1, 2, 3, 4, 5, 6)
					.map(LottoNum::of)
					.collect(Collectors.toList()),
				Stream.of(1, 2, 3, 4, 5, 45)
					.map(LottoNum::of)
					.collect(Collectors.toList()), LottoNum.of(6)),
			Arguments.arguments(
				Stream.of(1, 2, 3, 4, 6, 7)
					.map(LottoNum::of)
					.collect(Collectors.toList()),
				Stream.of(1, 2, 3, 4, 6, 45)
					.map(LottoNum::of)
					.collect(Collectors.toList()), LottoNum.of(7)),
			Arguments.arguments(
				Stream.of(1, 2, 3, 4, 7, 8)
					.map(LottoNum::of)
					.collect(Collectors.toList()),
				Stream.of(1, 2, 3, 4, 7, 45)
					.map(LottoNum::of)
					.collect(Collectors.toList()), LottoNum.of(8)),
			Arguments.arguments(
				Stream.of(1, 2, 3, 4, 8, 9)
					.map(LottoNum::of)
					.collect(Collectors.toList()),
				Stream.of(1, 2, 3, 4, 8, 45)
					.map(LottoNum::of)
					.collect(Collectors.toList()), LottoNum.of(9)),
			Arguments.arguments(
				Stream.of(1, 2, 3, 4, 9, 10)
					.map(LottoNum::of)
					.collect(Collectors.toList()),
				Stream.of(1, 2, 3, 4, 9, 45)
					.map(LottoNum::of)
					.collect(Collectors.toList()), LottoNum.of(10)),
			Arguments.arguments(
				Stream.of(1, 2, 3, 4, 10, 11)
					.map(LottoNum::of)
					.collect(Collectors.toList()),
				Stream.of(1, 2, 3, 4, 10, 45)
					.map(LottoNum::of)
					.collect(Collectors.toList()), LottoNum.of(11))
		);
	}

	@DisplayName("총 일치 숫자 5개 중 1개가 보너스 숫자면 2등이다.")
	@ParameterizedTest
	@MethodSource("providerOfSecondPlaceLottos")
	void Should_Be_Second_Place_When_Provided_Matching_Numbers_Of_Five_With_Bonus_Number(List<LottoNum> numbers,
		List<LottoNum> winningNumbers, LottoNum bonusNumber) {
		Lotto lotto = new Lotto(numbers);
		WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

		assertThat(lotto.getMatchingCount(winningLotto.getNumbers())).isEqualTo(5);
		assertThat(
			Reward.getRewardByMatchCount(lotto.getMatchingCount(winningLotto.getNumbers()),
				lotto.hasBonusNumber(bonusNumber)))
			.isEqualTo(Reward.SECOND);
	}
}
