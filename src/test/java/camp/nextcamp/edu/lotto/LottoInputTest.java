package camp.nextcamp.edu.lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextcamp.edu.lotto.entity.LottoInput;

public class LottoInputTest {

	@ParameterizedTest
	@DisplayName("로또 가격 parameter로 ticket 얻어오기")
	@CsvSource(value = {"14000=14", "5000=5", "2000=2"}, delimiter = '=')
	void lotto_생성(String input, int expected) {
		LottoInput lottoInput = new LottoInput(input);

		assertThat(lottoInput.getLottoTicketCount())
			.isEqualTo(expected);
	}

	@ParameterizedTest
	@DisplayName("로또 input 실패케이스")
	@ValueSource(strings = {"a223", "333e", "1!@#"})
	void LottoInput_실패케이스(String input) {
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> new LottoInput(input))
			.withMessageMatching("숫자만 가능합니다.");
	}

}
