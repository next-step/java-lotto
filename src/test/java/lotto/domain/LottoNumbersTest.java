package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoNumbersTest {
	LottoTicket lottoTicket = new LottoTicket();

	@Test
	public void generateLottoNumbersTest() {
		int expected = 6;
		int actual = lottoTicket.generateLottoNumbers(6, new LottoNumberGenerator()).getLottoTicket().size();
		assertThat(expected).isEqualTo(actual);
	}
}