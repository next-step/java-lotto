package lotto.domain;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.generator.FixedGenerator;

class StatisticsTest {
	private static final int FIXED_NUMBER_OF_PURCHASES = 10;

	@DisplayName("Statistics 생성을 검증한다.")
	@Test
	void create() {
		// given
		Tickets tickets = Tickets.create(new FixedGenerator(), FIXED_NUMBER_OF_PURCHASES);
		Ticket winningNumberTicket = Ticket.create(FixedGenerator.FIXED_NUMBERS);

		// when
		Statistics statistics = Statistics.create(tickets, winningNumberTicket);

		// then
		assertThat(statistics).isNotNull();
	}

	@DisplayName("Rank 에 맞는 당첨 티켓수를 미리 계산하여 Rank 전달시에 현재 당첨 티켓수를 반환한다.")
	@ParameterizedTest(name = "{index}. winningNumberTicket : {0}, rank : {1}")
	@MethodSource("provideWinningNumberTicketWithRank")
	void getMatchedResult(Ticket winningNumberTicket, Rank rank) {
		// given
		Tickets tickets = Tickets.create(new FixedGenerator(), FIXED_NUMBER_OF_PURCHASES);
		Statistics statistics = Statistics.create(tickets, winningNumberTicket);

		// when
		Map<Rank, Integer> matchedResult = statistics.getMatchedResult();

		// then
		assertThat(matchedResult.get(rank)).isEqualTo(FIXED_NUMBER_OF_PURCHASES);
	}

	@DisplayName("구매한 로또 금액 대비 당첨 금액 수익률을 반환한다.")
	@ParameterizedTest(name = "{index}. winningNumberTicket : {0}, profitRatio : {1}")
	@MethodSource("provideWinningNumberTicketAndProfitRatio")
	void getProfitRatio(Ticket winningNumberTicket, double profitRatio) {
		// given
		Tickets tickets = Tickets.create(new FixedGenerator(), FIXED_NUMBER_OF_PURCHASES);
		Statistics statistics = Statistics.create(tickets, winningNumberTicket);

		// when
		double result = statistics.getProfitRatio();

		// then
		assertThat(result).isEqualTo(profitRatio);
	}

	private static Stream<Arguments> provideWinningNumberTicketWithRank() {
		return Stream.of(
			arguments(Ticket.create(FixedGenerator.FIXED_NUMBERS), Rank.FIRST),
			arguments(Ticket.create(convertToLottoNumbers(1, 2, 3, 4, 5, 45)), Rank.SECOND),
			arguments(Ticket.create(convertToLottoNumbers(1, 2, 3, 4, 44, 45)), Rank.THIRD),
			arguments(Ticket.create(convertToLottoNumbers(1, 2, 3, 43, 44, 45)), Rank.FORTH)
		);
	}

	private static Stream<Arguments> provideWinningNumberTicketAndProfitRatio() {
		return Stream.of(
			arguments(Ticket.create(FixedGenerator.FIXED_NUMBERS), 2000000.0),
			arguments(Ticket.create(convertToLottoNumbers(1, 2, 3, 4, 5, 45)), 1500.0),
			arguments(Ticket.create(convertToLottoNumbers(1, 2, 3, 4, 44, 45)), 50.0),
			arguments(Ticket.create(convertToLottoNumbers(1, 2, 3, 43, 44, 45)), 5.0)
		);
	}

	private static List<LottoNumber> convertToLottoNumbers(int... numbers) {
		return Arrays.stream(numbers)
			.mapToObj(LottoNumber::create)
			.collect(toList());
	}
}
