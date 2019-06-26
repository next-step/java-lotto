package lotto;

import lotto.exception.DuplicateNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoTicketTest {

	@DisplayName("중복된 번호 입력 테스트")
	@Test
	void addSameNumber() {

		LottoTicket ticket = new LottoTicket();
		ticket.add(1);

		assertThatExceptionOfType(DuplicateNumberException.class).isThrownBy(() -> {
			ticket.add(1);
		});
	}
}