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
		List<LottoNumber> lottoTicketList = lotto.purchaseLottoTickets(16000);
		assertThat(lottoTicketList).hasSize(16);
	}
}