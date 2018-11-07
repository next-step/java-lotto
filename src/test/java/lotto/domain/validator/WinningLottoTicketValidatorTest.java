package lotto.domain.validator;

import lotto.domain.WinningLottoTicket;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.junit.Assert.*;

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
		WinningLottoTicket winningLottoTicket = new WinningLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 1);
		WinningLottoTicketValidator.BONUS_NUMBER_OVERLAP.getValidator().valid(winningLottoTicket);
	}
}