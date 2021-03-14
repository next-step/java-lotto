package camp.nextcamp.edu.lotto.entity;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import camp.nextcamp.edu.lotto.entity.LottoTicket;

public class LottoTicketTest {

	@ParameterizedTest
	@DisplayName("로또 가격 parameter로 ticket 얻어오기")
	@CsvSource(value = {"14=14", "5=5", "2=2"}, delimiter = '=')
	void lotto_생성(int input, int expected) {
		LottoTicket lottoInput = new LottoTicket(input);

		assertThat(lottoInput.getTicketCount())
			.isEqualTo(expected);
	}
}
