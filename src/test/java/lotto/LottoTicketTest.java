package lotto;

import lotto.exception.DuplicateNumberException;
import lotto.exception.OutOfCountException;
import lotto.exception.OutOfMaxNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoTicketTest {

	@DisplayName("중복된 번호 입력")
	@Test
	void addSameNumber() {

		LottoTicket ticket = new LottoTicket();
		ticket.add(1);

		assertThatExceptionOfType(DuplicateNumberException.class).isThrownBy(() -> {
			ticket.add(1);
		});
	}

	@DisplayName("허용된 개수 이상 입력")
	@Test
	void addOverCount() {
		int[] numbers = {1, 2, 3, 4, 5, 6};
		LottoTicket ticket = new LottoTicket();

		for(int number : numbers){
			ticket.add(number);
		}

		assertThatExceptionOfType(OutOfCountException.class).isThrownBy(() -> {
			ticket.add(7);
		});
	}

	@DisplayName("허용된 숫자 이상 입력")
	@Test
	void addOverLimit() {
		LottoTicket ticket = new LottoTicket();

		assertThatExceptionOfType(OutOfMaxNumberException.class).isThrownBy(() -> {
			ticket.add(LottoTicket.MAX_NUMBER + 1);
		});
	}
}