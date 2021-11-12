package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningTicketTest {
	@DisplayName("당첨번호, 보너스를 통해 WinningTicket 객체를 생성한다.")
	@Test
	void create() {
		// given
		String[] winningNumber = {"12", "17", "26", "36", "38", "40"};
		int bonus = 5;

		// when
		WinningTicket winningTicket = WinningTicket.create(winningNumber, bonus);

		// then
		assertThat(winningTicket).isNotNull();
	}
}
