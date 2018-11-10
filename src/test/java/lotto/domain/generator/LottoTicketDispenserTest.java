package lotto.domain.generator;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.common.Money;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hspark on 06/11/2018.
 */
public class LottoTicketDispenserTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void test_16000원_구매() {
		LottoTicketDispenser lottoTicketDispenser = new ShuffleLottoTicketDispenser(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
		PurchaseLottoTicketRequestInfo requestInfo = new PurchaseLottoTicketRequestInfo(Money.of(16000), Arrays.asList());
		PurchaseLottoTicketResultInfo resultInfo = lottoTicketDispenser.purchase(requestInfo);
		assertThat(resultInfo.getTickets()).hasSize(16);
	}

	@Test
	public void test_16000원_구매_수동2개구매() {
		LottoTicketDispenser lottoTicketDispenser = new ShuffleLottoTicketDispenser(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
		PurchaseLottoTicketRequestInfo requestInfo = new PurchaseLottoTicketRequestInfo(Money.of(16000),
			Arrays.asList(lottoTicket(1, 2, 3, 4, 5, 6),
				lottoTicket(1, 2, 3, 4, 5, 6)));
		PurchaseLottoTicketResultInfo resultInfo = lottoTicketDispenser.purchase(requestInfo);

		assertThat(resultInfo.getAutoTickets()).hasSize(14);
		assertThat(resultInfo.getManualTickets()).hasSize(2);
		assertThat(resultInfo.getTickets()).hasSize(16);
	}

	private LottoTicket lottoTicket(int a, int b, int c, int d, int e, int f) {
		return LottoTicket.newInstanceByManual(lottoNumber(a, b, c, d, e, f));
	}

	private List<LottoNumber> lottoNumber(int a, int b, int c, int d, int e, int f) {
		return Arrays.asList(LottoNumber.of(a), LottoNumber.of(b)
			, LottoNumber.of(c), LottoNumber.of(d)
			, LottoNumber.of(e), LottoNumber.of(f));
	}
}