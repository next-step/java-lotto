package lotto.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hspark on 06/11/2018.
 */
public class LottoTest {
	@Test(expected = IllegalArgumentException.class)
	public void test_1000원_이하로_구매() {
		Lotto lotto = new Lotto(new ShuffleLottoMachine());
		lotto.purchaseLottoTickets(400);
	}

	@Test
	public void test_1000단위가_아닐때() {
		Lotto lotto = new Lotto(new ShuffleLottoMachine());
		List<LottoTicket> lottoTicketList = lotto.purchaseLottoTickets(1500);
		assertThat(lottoTicketList).hasSize(1);
	}

	@Test
	public void test_16000원_구매() {
		Lotto lotto = new Lotto(new ShuffleLottoMachine());
		List<LottoTicket> lottoTicketList = lotto.purchaseLottoTickets(16000);
		assertThat(lottoTicketList).hasSize(16);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_이전_당첨번호가_6자리가_아닐때() {
		Lotto lotto = new Lotto(new ShuffleLottoMachine());
		lotto.purchaseLottoTickets(1000);
		List<Integer> previousLottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		lotto.matchNumber(previousLottoNumber);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_이전_로또번호가_46_이상일때() {
		Lotto lotto = new Lotto(new ShuffleLottoMachine());
		lotto.purchaseLottoTickets(1000);
		List<Integer> previousLottoNumber = Arrays.asList(46, 47, 48, 49, 50, 51);
		lotto.matchNumber(previousLottoNumber);
	}

	@Test
	public void test_로또_1등_당첨() {
		Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
		lotto.purchaseLottoTickets(1000);
		List<Integer> previousLottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
		LottoMatchingResult lottoMatchingResult = lotto.matchNumber(previousLottoNumber);

		assertThat(lottoMatchingResult.getFirstWinners()).hasSize(1);
		assertThat(lottoMatchingResult.getFirstWinners().get(0))
			.extracting("lottoNumbers").contains(1, 2, 3, 4, 5, 6);
	}
}