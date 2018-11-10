package lotto.domain.validator;

import lotto.domain.LottoNumber;
import lotto.domain.WinningLottoTicket;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hspark on 08/11/2018.
 */
public class WinningLottoTicketValidatorTest {
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void test_보너스_볼_중복() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("보너스 볼 중복");
		WinningLottoTicket winningLottoTicket = new WinningLottoTicket(lottoNumber(1, 2, 3, 4, 5, 6), LottoNumber.of(1));
		WinningLottoTicketValidator.BONUS_NUMBER_OVERLAP.getValidator().valid(winningLottoTicket);
	}

	private List<LottoNumber> lottoNumber(int a, int b, int c, int d, int e, int f) {
		return Arrays.asList(LottoNumber.of(a), LottoNumber.of(b)
			, LottoNumber.of(c), LottoNumber.of(d)
			, LottoNumber.of(e), LottoNumber.of(f));
	}
}