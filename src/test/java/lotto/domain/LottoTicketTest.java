package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTicketTest {

	@DisplayName("로또 1장은 중복되지 않는 6개의 번호를 갖는다.")
	@Test
	void lottoTicketHasNonDuplicateSixNumber() {
		LottoMachine lottoMachine = new LottoMachine();
		LottoTicket lottoTicket = LottoTicket.from(lottoMachine.pickRandomNumbers());
		assertThat(lottoTicket.getNumbers()).hasSize(6).doesNotHaveDuplicates();
	}

	@DisplayName("지난 주 당첨 번호로 로또를 생성한다.")
	@ValueSource(strings = "1,2,3,4,5,6")
	@ParameterizedTest
	void winningLottoTicket(String winningNumbers) {
		LottoTicket winningLottoTicket = LottoTicket.from(winningNumbers);
		assertThat(winningLottoTicket.getNumbers()).contains(1, 2, 3, 4, 5, 6);
	}

}