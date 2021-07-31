package lotto.domain;

import static lotto.domain.LottoPrize.*;
import static lotto.domain.LottoTicketsTest.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoPrizesTest {

	@DisplayName("로또 당첨 결과를 생성한다.")
	@Test
	void create() {
		List<LottoTicket> tickets = createLottoTickets();
		LottoTickets lottoTickets = LottoTickets.from(tickets);
		LottoPrizes lottoPrizes = lottoTickets.getLottoPrizes(LottoTicket.from(Arrays.asList(1, 2, 3, 4, 5, 6)));
		assertThat(lottoPrizes.size()).isEqualTo(tickets.size());
	}

	@DisplayName("각 등수별 당첨 통계를 계산한다.")
	@MethodSource("countLottoPrizesPerRankArguments")
	@ParameterizedTest
	void countLottoPrizesPerRank(LottoPrizes totalLottoPrizes, LottoPrize lottoPrize, int count, int winningMoney) {
		LottoPrizes lottoPrizes = totalLottoPrizes.prizesOf(lottoPrize);
		assertThat(lottoPrizes.size()).isEqualTo(count);
		assertThat(lottoPrizes.winningMoney()).isEqualTo(winningMoney);
	}

	@DisplayName("구입한 금액과 구매한 로또의 당첨금으로 총 수익률을 계산한다.")
	@MethodSource("earningsRateArguments")
	@ParameterizedTest
	void earningsRate(LottoPrizes lottoPrizes, int money, double earningsRate) {
		assertThat(lottoPrizes.earningsRate(money)).isEqualTo(earningsRate);
	}

	private static Stream<Arguments> earningsRateArguments() {
		return Stream.of(
			Arguments.of(LottoPrizes.from(Arrays.asList(FIFTH, FOURTH)), 100_000, 0.55),
			Arguments.of(LottoPrizes.from(Arrays.asList(FOURTH, FIRST)), 200_000, 10_000.25)
		);
	}

	private static Stream<Arguments> countLottoPrizesPerRankArguments() {
		List<LottoPrize> totalLottoPrizes = createLottoPrizes();
		return Stream.of(
			createArgumentsFrom(totalLottoPrizes, FIFTH, 2),
			createArgumentsFrom(totalLottoPrizes, FOURTH, 3),
			createArgumentsFrom(totalLottoPrizes, THIRD, 4),
			createArgumentsFrom(totalLottoPrizes, FIRST, 2)
		);
	}

	private static Arguments createArgumentsFrom(List<LottoPrize> totalLottoPrizes, LottoPrize lottoPrize, int count) {
		return Arguments.of(LottoPrizes.from(totalLottoPrizes), lottoPrize, count, lottoPrize.prizeMoney() * count);
	}

	private static List<LottoPrize> createLottoPrizes() {
		List<LottoPrize> lottoPrizes = new ArrayList<>();
		lottoPrizes.add(NONE);
		lottoPrizes.add(NONE);
		lottoPrizes.add(FIFTH);
		lottoPrizes.add(FIFTH);
		lottoPrizes.add(FOURTH);
		lottoPrizes.add(FOURTH);
		lottoPrizes.add(FOURTH);
		lottoPrizes.add(THIRD);
		lottoPrizes.add(THIRD);
		lottoPrizes.add(THIRD);
		lottoPrizes.add(THIRD);
		lottoPrizes.add(FIRST);
		lottoPrizes.add(FIRST);
		return lottoPrizes;
	}

}
