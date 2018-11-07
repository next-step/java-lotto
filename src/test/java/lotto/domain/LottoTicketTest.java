package lotto.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hspark on 07/11/2018.
 */
public class LottoTicketTest {

	@Test
	public void test_로또_번호_1등() {
		LottoTicket lottoTicket = LottoTicket.newInstanceByAutomation(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoTicket manualLottoTicket = LottoTicket.newInstanceByManual(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoWinnerType winnerType = lottoTicket.matchNumber(manualLottoTicket);

		assertThat(winnerType).isEqualTo(LottoWinnerType.FIRST_WINNER);
	}

	@Test
	public void test_로또_번호_2등() {
		LottoTicket lottoTicket = LottoTicket.newInstanceByAutomation(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoTicket manualLottoTicket = LottoTicket.newInstanceByManual(Arrays.asList(1, 2, 3, 4, 5, 7));
		LottoWinnerType winnerType = lottoTicket.matchNumber(manualLottoTicket);

		assertThat(winnerType).isEqualTo(LottoWinnerType.SECOND_WINNER);
	}

	@Test
	public void test_로또_번호_3등() {
		LottoTicket lottoTicket = LottoTicket.newInstanceByAutomation(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoTicket manualLottoTicket = LottoTicket.newInstanceByManual(Arrays.asList(1, 2, 3, 4, 8, 7));
		LottoWinnerType winnerType = lottoTicket.matchNumber(manualLottoTicket);

		assertThat(winnerType).isEqualTo(LottoWinnerType.THIRD_WINNER);
	}

	@Test
	public void test_로또_번호_4등() {
		LottoTicket lottoTicket = LottoTicket.newInstanceByAutomation(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoTicket manualLottoTicket = LottoTicket.newInstanceByManual(Arrays.asList(1, 2, 3, 9, 8, 7));
		LottoWinnerType winnerType = lottoTicket.matchNumber(manualLottoTicket);

		assertThat(winnerType).isEqualTo(LottoWinnerType.FOURTH_WINNER);
	}

	@Test
	public void test_로또_번호_꽝_2개() {
		LottoTicket lottoTicket = LottoTicket.newInstanceByAutomation(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoTicket manualLottoTicket = LottoTicket.newInstanceByManual(Arrays.asList(1, 2, 10, 9, 8, 7));
		LottoWinnerType winnerType = lottoTicket.matchNumber(manualLottoTicket);

		assertThat(winnerType).isEqualTo(LottoWinnerType.LOSING_TICKET);
	}

	@Test
	public void test_로또_번호_꽝_1개() {
		LottoTicket lottoTicket = LottoTicket.newInstanceByAutomation(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoTicket manualLottoTicket = LottoTicket.newInstanceByManual(Arrays.asList(1, 11, 10, 9, 8, 7));
		LottoWinnerType winnerType = lottoTicket.matchNumber(lottoTicket);

		assertThat(winnerType).isEqualTo(LottoWinnerType.LOSING_TICKET);
	}
}