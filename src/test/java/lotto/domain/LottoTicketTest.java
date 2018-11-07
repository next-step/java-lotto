package lotto.domain;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.enums.Prize;
import org.junit.Test;

public class LottoTicketTest {

	@Test
	public void 당첨번호_확인_검증() {
		Lotto lotto1 = new Lotto(asList(1, 2, 3, 4, 5, 6)); // 3개 매치
		Lotto lotto2 = new Lotto(asList(1, 3, 5, 13, 14, 17)); // 6개 매치
		Lotto lotto3 = new Lotto(asList(1, 8, 9, 10, 11, 12)); // 1개 매치
		LottoTicket lottoTicket = new LottoTicket(asList(lotto1, lotto2, lotto3));

		WinningLotto winningNumber = new WinningLotto(asList(1, 3, 5, 13, 14, 17), 19);
		WinningResult winningResult = lottoTicket.match(winningNumber);

		assertThat(winningResult).extracting("prizes")
				.containsExactlyInAnyOrder(asList(Prize.FIFTH, Prize.FIRST, Prize.NO_MATCH));
	}
}