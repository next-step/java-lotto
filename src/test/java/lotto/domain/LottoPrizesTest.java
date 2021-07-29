package lotto.domain;

import static lotto.domain.LottoPrize.*;
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
		assertThat(totalLottoPrizes.countOf(lottoPrize).size()).isEqualTo(count);
		assertThat(totalLottoPrizes.countOf(lottoPrize).winningMoney()).isEqualTo(winningMoney);
	}

	private static Stream<Arguments> countLottoPrizesPerRankArguments() {
		List<LottoPrize> totalLottoPrizes = createLottoPrizes();
		return Stream.of(
			createArgumentsFrom(totalLottoPrizes, ONE_NUMBER, 1),
			createArgumentsFrom(totalLottoPrizes, TWO_NUMBERS, 1),
			createArgumentsFrom(totalLottoPrizes, THREE_NUMBERS, 2),
			createArgumentsFrom(totalLottoPrizes, FOUR_NUMBERS, 3),
			createArgumentsFrom(totalLottoPrizes, FIVE_NUMBERS, 4),
			createArgumentsFrom(totalLottoPrizes, SIX_NUMBERS, 2)
		);
	}

	private static Arguments createArgumentsFrom(List<LottoPrize> totalLottoPrizes, LottoPrize lottoPrize, int count) {
		return Arguments.of(LottoPrizes.from(totalLottoPrizes), lottoPrize, count, lottoPrize.prizeMoney() * count);
	}

	private static List<LottoPrize> createLottoPrizes() {
		List<LottoPrize> lottoPrizes = new ArrayList<>();
		lottoPrizes.add(ONE_NUMBER);
		lottoPrizes.add(TWO_NUMBERS);
		lottoPrizes.add(THREE_NUMBERS);
		lottoPrizes.add(THREE_NUMBERS);
		lottoPrizes.add(FOUR_NUMBERS);
		lottoPrizes.add(FOUR_NUMBERS);
		lottoPrizes.add(FOUR_NUMBERS);
		lottoPrizes.add(FIVE_NUMBERS);
		lottoPrizes.add(FIVE_NUMBERS);
		lottoPrizes.add(FIVE_NUMBERS);
		lottoPrizes.add(FIVE_NUMBERS);
		lottoPrizes.add(SIX_NUMBERS);
		lottoPrizes.add(SIX_NUMBERS);
		return lottoPrizes;
	}

	private List<LottoTicket> createLottoTickets() {
		return Arrays.asList(
			LottoTicket.from(Arrays.asList(1, 2, 3, 4, 5, 6)),
			LottoTicket.from(Arrays.asList(7, 8, 9, 10, 11, 12))
		);
	}

}
