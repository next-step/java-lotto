package step2.lotto.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import step2.lotto.LottoFixedNumberGenerator;
import step2.lotto.LottoNumberGenerator;
import step2.lotto.LottoRandomNumberGenerator;

public class LottoTicketTest {
	private LottoNumberGenerator fixedLottoNumberGenerator = LottoFixedNumberGenerator.createSequential(0);

	private LottoTicket answerLottoTicket = LottoTicket.from(fixedLottoNumberGenerator);

	private LottoRandomNumberGenerator lottoRandomNumberGenerator = LottoRandomNumberGenerator.create();

	@Test
	void 생성_테스트() {
		LottoTicket lotto = LottoTicket.from(lottoRandomNumberGenerator);

		assertAll(
			() -> assertThat(lotto).isInstanceOf(LottoTicket.class)
		);
	}

	@Test
	void 번호_생성_테스트() {
		LottoNumberGenerator unmatchedLottoNumberGenerator = LottoFixedNumberGenerator.createSequential(1);

		LottoTicket answerLotto = LottoTicket.from(fixedLottoNumberGenerator);
		LottoTicket wrongLotto = LottoTicket.from(unmatchedLottoNumberGenerator);

		assertAll(
			() -> assertThat(answerLotto.countMatch(answerLottoTicket)).isEqualTo(6),
			() -> assertThat(wrongLotto.countMatch(answerLottoTicket)).isEqualTo(5)
		);
	}
}

