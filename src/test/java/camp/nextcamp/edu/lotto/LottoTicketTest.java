package camp.nextcamp.edu.lotto;

import static camp.nextcamp.edu.lotto.exception.UserExceptionMesssage.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextcamp.edu.lotto.entity.LottoTicket;
import camp.nextcamp.edu.lotto.exception.UserException;

public class LottoTicketTest {

	@ParameterizedTest
	@DisplayName("로또 가격 parameter로 ticket 얻어오기")
	@CsvSource(value = {"14000=14", "5000=5", "2000=2"}, delimiter = '=')
	void lotto_생성(String input, int expected) {
		LottoTicket lottoInput = new LottoTicket(input);

		assertThat(lottoInput.getTicketCount())
			.isEqualTo(expected);
	}

	@ParameterizedTest
	@DisplayName("로또 input 실패케이스")
	@ValueSource(strings = {"a223", "333e", "1!@#"})
	void LottoInput_실패케이스(String input) {
		assertThatExceptionOfType(UserException.class)
			.isThrownBy(() -> new LottoTicket(input))
			.withMessageMatching(ONLY_NUMBER.getMessage());
	}

}
