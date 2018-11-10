package lotto.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hspark on 07/11/2018.
 */
public class LottoTicketTest {

	@Test
	public void test_로또_번호_1등() {
		LottoTicket lottoTicket = LottoTicket.newInstanceByAutomation(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
		WinningLottoTicket winningLottoTicket = new WinningLottoTicket(lottoNumber(1, 2, 3, 4, 5, 6), new LottoNumber(7));
		LottoWinnerType winnerType = winningLottoTicket.matchNumber(lottoTicket);

		assertThat(winnerType).isEqualTo(LottoWinnerType.FIRST_WINNER);
	}

	@Test
	public void test_로또_번호_2등() {
		LottoTicket lottoTicket = LottoTicket.newInstanceByAutomation(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
		WinningLottoTicket winningLottoTicket = new WinningLottoTicket(lottoNumber(1, 2, 3, 4, 5, 7), new LottoNumber(6));
		LottoWinnerType winnerType = winningLottoTicket.matchNumber(lottoTicket);

		assertThat(winnerType).isEqualTo(LottoWinnerType.SECOND_WINNER);
	}

	@Test
	public void test_로또_번호_3등() {
		LottoTicket lottoTicket = LottoTicket.newInstanceByAutomation(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
		WinningLottoTicket winningLottoTicket = new WinningLottoTicket(lottoNumber(1, 2, 3, 4, 5, 7), new LottoNumber(9));
		LottoWinnerType winnerType = winningLottoTicket.matchNumber(lottoTicket);

		assertThat(winnerType).isEqualTo(LottoWinnerType.THIRD_WINNER);
	}

	@Test
	public void test_로또_번호_4등() {
		LottoTicket lottoTicket = LottoTicket.newInstanceByAutomation(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
		WinningLottoTicket winningLottoTicket = new WinningLottoTicket(lottoNumber(1, 2, 3, 4, 8, 7), new LottoNumber(6));
		LottoWinnerType winnerType = winningLottoTicket.matchNumber(lottoTicket);

		assertThat(winnerType).isEqualTo(LottoWinnerType.FOURTH_WINNER);
	}

	@Test
	public void test_로또_번호_5등() {
		LottoTicket lottoTicket = LottoTicket.newInstanceByAutomation(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
		WinningLottoTicket winningLottoTicket = new WinningLottoTicket(lottoNumber(1, 2, 3, 9, 8, 7), new LottoNumber(6));
		LottoWinnerType winnerType = winningLottoTicket.matchNumber(lottoTicket);

		assertThat(winnerType).isEqualTo(LottoWinnerType.FIFTH_WINNER);
	}

	@Test
	public void test_로또_번호_꽝_2개() {
		LottoTicket lottoTicket = LottoTicket.newInstanceByAutomation(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
		WinningLottoTicket winningLottoTicket = new WinningLottoTicket(lottoNumber(1, 2, 10, 9, 8, 7), new LottoNumber(6));
		LottoWinnerType winnerType = winningLottoTicket.matchNumber(lottoTicket);

		assertThat(winnerType).isEqualTo(LottoWinnerType.LOSING_TICKET);
	}

	@Test
	public void test_로또_번호_꽝_1개() {
		LottoTicket lottoTicket = LottoTicket.newInstanceByAutomation(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
		WinningLottoTicket winningLottoTicket = new WinningLottoTicket(lottoNumber(1, 11, 10, 9, 8, 7), new LottoNumber(2));
		LottoWinnerType winnerType = winningLottoTicket.matchNumber(lottoTicket);

		assertThat(winnerType).isEqualTo(LottoWinnerType.LOSING_TICKET);
	}

	private List<LottoNumber> lottoNumber(int a, int b, int c, int d, int e, int f) {
		return Arrays.asList(new LottoNumber(a), new LottoNumber(b)
			, new LottoNumber(c), new LottoNumber(d)
			, new LottoNumber(e), new LottoNumber(f));
	}
}