package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.generator.FixedGenerator;

class StatisticsTest {
	private static final int FIXED_NUMBER_OF_PURCHASES = 1;

	private static final String[] FIXED_WINNING_NUMBERS = {"1", "2", "3", "4", "5", "6"};
	private static final int FIXED_BONUS = 6;
	private static final int NOT_MATCHED_FIXED_BONUS = 30;

	@DisplayName("Statistics 생성을 검증한다.")
	@Test
	void create() {
		// given
		Tickets tickets = Tickets.create(new FixedGenerator(), FIXED_NUMBER_OF_PURCHASES, Collections.emptyList());
		WinningTicket winningTicket = WinningTicket.create(FIXED_WINNING_NUMBERS, FIXED_BONUS);

		// when
		Statistics statistics = Statistics.create(tickets, winningTicket);

		// then
		assertThat(statistics).isNotNull();
	}

	@DisplayName("Rank 에 맞는 당첨 티켓수를 미리 계산하여 Rank 전달시에 현재 당첨 티켓수를 반환한다.")
	@ParameterizedTest(name = "{index}. winningTicket : {0}, rank : {1}")
	@MethodSource("provideWinningTicketWithRank")
	void getMatchedResult(WinningTicket winningTicket, Rank rank) {
		// given
		Tickets tickets = Tickets.create(new FixedGenerator(), FIXED_NUMBER_OF_PURCHASES, Collections.emptyList());
		Statistics statistics = Statistics.create(tickets, winningTicket);

		// when
		Map<Rank, Integer> matchedResult = statistics.getMatchedResult();

		// then
		assertThat(matchedResult.get(rank)).isEqualTo(FIXED_NUMBER_OF_PURCHASES);
	}

	@DisplayName("구매한 로또 금액 대비 당첨 금액 수익률을 반환한다.")
	@ParameterizedTest(name = "{index}. winningNumberTicket : {0}, profitRatio : {1}")
	@MethodSource("provideWinningTicketAndProfitRatio")
	void getProfitRatio(WinningTicket winningTicket, double profitRatio) {
		// given
		Tickets tickets = Tickets.create(new FixedGenerator(), FIXED_NUMBER_OF_PURCHASES, Collections.emptyList());
		Statistics statistics = Statistics.create(tickets, winningTicket);

		// when
		double result = statistics.getProfitRatio();

		// then
		assertThat(result).isEqualTo(profitRatio);
	}

	private static Stream<Arguments> provideWinningTicketWithRank() {
		return Stream.of(
			arguments(WinningTicket.create(FIXED_WINNING_NUMBERS, NOT_MATCHED_FIXED_BONUS), Rank.FIRST),
			arguments(WinningTicket.create(convertToWinningNumbers(1, 2, 3, 4, 5, 45), FIXED_BONUS),
				Rank.SECOND),
			arguments(WinningTicket.create(convertToWinningNumbers(1, 2, 3, 4, 5, 45), NOT_MATCHED_FIXED_BONUS),
				Rank.THIRD),
			arguments(WinningTicket.create(convertToWinningNumbers(1, 2, 3, 4, 44, 45), NOT_MATCHED_FIXED_BONUS),
				Rank.FOURTH),
			arguments(WinningTicket.create(convertToWinningNumbers(1, 2, 3, 43, 44, 45), NOT_MATCHED_FIXED_BONUS),
				Rank.FIFTH)
		);
	}

	private static Stream<Arguments> provideWinningTicketAndProfitRatio() {
		return Stream.of(
			arguments(WinningTicket.create(FIXED_WINNING_NUMBERS, 45), 2000000.0),
			arguments(WinningTicket.create(convertToWinningNumbers(1, 2, 3, 4, 5, 45), FIXED_BONUS),
				30000.0),
			arguments(WinningTicket.create(convertToWinningNumbers(1, 2, 3, 4, 44, 45), NOT_MATCHED_FIXED_BONUS), 50.0),
			arguments(WinningTicket.create(convertToWinningNumbers(1, 2, 3, 43, 44, 45), NOT_MATCHED_FIXED_BONUS), 5.0)
		);
	}

	private static String[] convertToWinningNumbers(int... numbers) {
		return Arrays.stream(numbers)
			.mapToObj(String::valueOf)
			.toArray(String[]::new);
	}
}
