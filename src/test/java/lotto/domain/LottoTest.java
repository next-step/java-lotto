package lotto.domain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hspark on 06/11/2018.
 */
public class LottoTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void test_16000원_구매() {
		Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
		PurchaseLottoTickets purchaseLottoTickets = lotto.purchaseLottoTickets(16000, Arrays.asList());
		assertThat(purchaseLottoTickets.getAutoTickets()).hasSize(16);
		assertThat(purchaseLottoTickets.getTickets()).hasSize(16);
	}

	@Test
	public void test_수동_및_자동_구매() {
		Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
		List<LottoTicket> lottoTickets = Arrays.asList(
			lottoTicket(1, 2, 3, 4, 5, 6),
			lottoTicket(1, 2, 3, 4, 5, 6),
			lottoTicket(1, 2, 3, 4, 5, 6)
		);
		PurchaseLottoTickets purchaseLottoTickets = lotto.purchaseLottoTickets(16000, lottoTickets);
		assertThat(purchaseLottoTickets.getAutoTickets()).hasSize(13);
		assertThat(purchaseLottoTickets.getManualTickets()).hasSize(3);
		assertThat(purchaseLottoTickets.getTickets()).hasSize(16);
	}

	private LottoTicket lottoTicket(int a, int b, int c, int d, int e, int f) {
		return LottoTicket.newInstanceByManual(Arrays.asList(a, b, c, d, e, f));
	}
}