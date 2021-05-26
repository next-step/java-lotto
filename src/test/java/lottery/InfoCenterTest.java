package lottery;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InfoCenterTest {

	private InfoCenter sut;

	@BeforeEach
	void setUp() {
		sut = new InfoCenter();
	}

	@Test
	void 지난주_당첨번호를_입력받는다() {
		WinningTicket lastWinningNumber = new WinningTicket(
			Ticket.of(LottoNumbers.from(Sets.newLinkedHashSet(1, 2, 3, 4, 5, 6))), 10);
		sut.setLastWeekWinningTicket(lastWinningNumber);

		assertThat(sut.lastWeekWinningNumbers()).isEqualTo(lastWinningNumber);
	}

	@Test
	void 로또_3개자리_일치() {
		Ticket buyerTicket = Ticket.of(LottoNumbers.from(Sets.newLinkedHashSet(1, 2, 3, 11, 12, 13)));
		WinningTicket lastWinningNumber = new WinningTicket(
			Ticket.of(LottoNumbers.from(Sets.newLinkedHashSet(1, 2, 3, 4, 5, 6))), 7);
		sut.setLastWeekWinningTicket(lastWinningNumber);

		Result result = sut.confirmTicket(Tickets.of(Lists.list(buyerTicket)));
		assertEqualMatchCount(result, 1, 0, 0, 0, 0);
	}

	@Test
	void 로또_4개자리_일치() {
		Ticket buyerTicket = Ticket.of(LottoNumbers.from(Sets.newLinkedHashSet(1, 2, 3, 4, 12, 13)));
		WinningTicket lastWinningNumber = new WinningTicket(
			Ticket.of(LottoNumbers.from(Sets.newLinkedHashSet(1, 2, 3, 4, 5, 6))), 7);
		sut.setLastWeekWinningTicket(lastWinningNumber);

		Result result = sut.confirmTicket(Tickets.of(Lists.list(buyerTicket)));
		assertEqualMatchCount(result, 0, 1, 0, 0, 0);
	}

	@Test
	void 로또_5개자리_일치() {
		Ticket buyerTicket = Ticket.of(LottoNumbers.from(Sets.newLinkedHashSet(1, 2, 3, 4, 5, 13)));
		WinningTicket lastWinningNumber = new WinningTicket(
			Ticket.of(LottoNumbers.from(Sets.newLinkedHashSet(1, 2, 3, 4, 5, 6))), 7);
		sut.setLastWeekWinningTicket(lastWinningNumber);

		Result result = sut.confirmTicket(Tickets.of(Lists.list(buyerTicket)));
		assertEqualMatchCount(result, 0, 0, 1, 0, 0);
	}

	@Test
	void 로또_6개자리_일치() {
		Ticket buyerTicket = Ticket.of(LottoNumbers.from(Sets.newLinkedHashSet(1, 2, 3, 4, 5, 6)));
		WinningTicket lastWinningNumber = new WinningTicket(
			Ticket.of(LottoNumbers.from(Sets.newLinkedHashSet(1, 2, 3, 4, 5, 6))), 7);
		sut.setLastWeekWinningTicket(lastWinningNumber);

		Result result = sut.confirmTicket(Tickets.of(Lists.list(buyerTicket)));
		assertEqualMatchCount(result, 0, 0, 0, 1, 0);
	}

	@Test
	void 복수의_로또티켓을_체크할수_있다() {
		Tickets tickets = getTickets(Sets.newLinkedHashSet(1, 2, 3, 4, 5, 6));
		WinningTicket lastWinningNumber = new WinningTicket(
			Ticket.of(LottoNumbers.from(Sets.newLinkedHashSet(1, 2, 3, 4, 5, 6))), 7);
		sut.setLastWeekWinningTicket(lastWinningNumber);

		Result result = sut.confirmTicket(tickets);

		assertEqualMatchCount(result, 0, 0, 0, 1, 0);
	}

	@Test
	void 수익률을_계산한다() {
		Tickets tickets = getTickets(Sets.newLinkedHashSet(1, 2, 3, 9, 10, 11),
			Sets.newLinkedHashSet(1, 2, 3, 9, 10, 11),
			Sets.newLinkedHashSet(1, 2, 3, 9, 10, 11)
		);

		Money money = Money.won(3000L);
		float expected = 5.0f;

		WinningTicket lastWinningNumber = new WinningTicket(
			Ticket.of(LottoNumbers.from(Sets.newLinkedHashSet(1, 2, 3, 4, 5, 6))), 7);
		sut.setLastWeekWinningTicket(lastWinningNumber);
		;

		Result result = sut.confirmTicket(tickets);
		float totalYield = result.getTotalYield(money);
		assertThat(totalYield).isEqualTo(expected);
	}

	@Test
	void 보너스점수로_당첨될_경우() {
		Tickets tickets = getTickets(
			Sets.newLinkedHashSet(1, 2, 3, 4, 5, 11),
			Sets.newLinkedHashSet(1, 2, 3, 4, 5, 11),
			Sets.newLinkedHashSet(1, 2, 3, 4, 5, 11)
		);
		WinningTicket lastWinningNumber = new WinningTicket(
			Ticket.of(LottoNumbers.from(Sets.newLinkedHashSet(1, 2, 3, 4, 5, 6))), 11);
		sut.setLastWeekWinningTicket(lastWinningNumber);

		Result result = sut.confirmTicket(tickets);

		assertEqualMatchCount(result, 0, 0, 0, 0, 3);
	}

	private void assertEqualMatchCount(Result result, int threeMatchNumber, int fourMatchNumber, int fiveMatchNumber,
		int sixMatchNumber, int bonus) {

		Map<LotteryMatchType, Integer> resultMap = result.getResultMap();

		assertThat(resultMap.getOrDefault(LotteryMatchType.THREE_MATCH, 0)).isEqualTo(threeMatchNumber);
		assertThat(resultMap.getOrDefault(LotteryMatchType.FOUR_MATCH, 0)).isEqualTo(fourMatchNumber);
		assertThat(resultMap.getOrDefault(LotteryMatchType.FIVE_MATCH, 0)).isEqualTo(fiveMatchNumber);
		assertThat(resultMap.getOrDefault(LotteryMatchType.FIVE_MATCH_WITH_BONUS, 0)).isEqualTo(bonus);
		assertThat(resultMap.getOrDefault(LotteryMatchType.SIX_MATCH, 0)).isEqualTo(sixMatchNumber);
	}

	private Tickets getTickets(LinkedHashSet<Integer>... numbers) {
		List<Ticket> tickets = new ArrayList<>();
		for (LinkedHashSet<Integer> number : numbers) {
			tickets.add(Ticket.of(LottoNumbers.from(number)));
		}
		return Tickets.of(tickets);
	}
}
