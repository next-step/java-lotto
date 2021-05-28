package lottery;

import static lottery.LottoNumber.*;
import static lottery.fixture.Const.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InfoCenterTest {

	private InfoCenter sut;
	private WinningTicket 당첨번호_1_2_3_4_5_6_보너스_7;
	@BeforeEach
	void setUp() {
		sut = new InfoCenter();
		당첨번호_1_2_3_4_5_6_보너스_7 = new WinningTicket(
			Ticket.of(LottoNumbers.from(
				Sets.newLinkedHashSet(of(1), of(2), of(3), of(4), of(5), of(6))), TicketType.WINNING), 보너스_7);
	}

	@Test
	void 지난주_당첨번호를_입력받는다() {
		sut.setLastWeekWinningTicket(당첨번호_1_2_3_4_5_6_보너스_7);
		assertThat(sut.lastWeekWinningNumbers()).isEqualTo(당첨번호_1_2_3_4_5_6_보너스_7);
	}

	@Test
	void 로또_3개자리_일치() {

		Ticket buyerTicket = Ticket.of(LottoNumbers.from(buyer_로또번호_1_2_3_11_12_13),
			TicketType.MANUAL);
		sut.setLastWeekWinningTicket(당첨번호_1_2_3_4_5_6_보너스_7);

		Result result = sut.confirmTicket(Tickets.of(Lists.list(buyerTicket)));
		assertEqualMatchCount(result, 1, 0, 0, 0, 0);
	}

	@Test
	void 로또_4개자리_일치() {
		Ticket buyerTicket = Ticket.of(LottoNumbers.from(buyer_로또번호_1_2_3_4_12_13), TicketType.MANUAL);
		sut.setLastWeekWinningTicket(당첨번호_1_2_3_4_5_6_보너스_7);

		Result result = sut.confirmTicket(Tickets.of(Lists.list(buyerTicket)));
		assertEqualMatchCount(result, 0, 1, 0, 0, 0);
	}

	@Test
	void 로또_5개자리_일치() {
		Ticket buyerTicket = Ticket.of(LottoNumbers.from(buyer_로또번호_1_2_3_4_5_13), TicketType.MANUAL);
		sut.setLastWeekWinningTicket(당첨번호_1_2_3_4_5_6_보너스_7);

		Result result = sut.confirmTicket(Tickets.of(Lists.list(buyerTicket)));
		assertEqualMatchCount(result, 0, 0, 1, 0, 0);
	}

	@Test
	void 로또_6개자리_일치() {
		Ticket buyerTicket = Ticket.of(LottoNumbers.from(buyer_로또번호_1_2_3_4_5_6), TicketType.MANUAL);
		sut.setLastWeekWinningTicket(당첨번호_1_2_3_4_5_6_보너스_7);

		Result result = sut.confirmTicket(Tickets.of(Lists.list(buyerTicket)));
		assertEqualMatchCount(result, 0, 0, 0, 1, 0);
	}

	@Test
	void 복수의_로또티켓을_체크할수_있다() {
		Tickets tickets = getTickets(buyer_로또번호_1_2_3_4_5_6);
		sut.setLastWeekWinningTicket(당첨번호_1_2_3_4_5_6_보너스_7);

		Result result = sut.confirmTicket(tickets);

		assertEqualMatchCount(result, 0, 0, 0, 1, 0);
	}

	@Test
	void 수익률을_계산한다() {
		Tickets tickets = getTickets(buyer_로또번호_1_2_3_9_10_11,
			buyer_로또번호_1_2_3_9_10_11,
			buyer_로또번호_1_2_3_9_10_11);

		Money money = Money.won(3000L);
		float expected = 5.0f;

		sut.setLastWeekWinningTicket(당첨번호_1_2_3_4_5_6_보너스_7);
		;

		Result result = sut.confirmTicket(tickets);
		float totalYield = result.getTotalYield(money);
		assertThat(totalYield).isEqualTo(expected);
	}

	@Test
	void 보너스점수로_당첨될_경우() {
		Set<LottoNumber> 로또번호_1_2_3_4_5_7 = Sets.newLinkedHashSet(of(1), of(2), of(3), of(4), of(5), of(7));
		Tickets tickets = getTickets(
			로또번호_1_2_3_4_5_7,
			로또번호_1_2_3_4_5_7,
			로또번호_1_2_3_4_5_7
		);
		sut.setLastWeekWinningTicket(당첨번호_1_2_3_4_5_6_보너스_7);

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

	private Tickets getTickets(Set<LottoNumber>... numbers) {
		List<Ticket> tickets = new ArrayList<>();
		for (Set<LottoNumber> number : numbers) {
			tickets.add(Ticket.of(LottoNumbers.from(number), TicketType.MANUAL));
		}
		return Tickets.of(tickets);
	}
}
