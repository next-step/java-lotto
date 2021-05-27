package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WinningLottoTest {

	@Test
	void constructor() {
		// given
		LottoTicket winningLottoTicket = LottoTicketConverter.convert("1,2,3,4,5,6");
		LottoNumber bonusLottoNumber = LottoNumber.of(7);

		// when
		WinningLotto winningLotto = new WinningLotto(winningLottoTicket, bonusLottoNumber);

		// then
		assertThat(winningLotto).isNotNull();
	}

	@Test
	void invalid() {
		// given
		LottoTicket winningLottoTicket = LottoTicketConverter.convert("1,2,3,4,5,6");
		LottoNumber bonusLottoNumber = LottoNumber.of(6);

		// when
		Throwable throwable = catchThrowable(() -> new WinningLotto(winningLottoTicket, bonusLottoNumber));

		// then
		assertThat(throwable).as("당첨번호에 보너스 번호가 없음").isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void rank() {
		// given
		LottoTicket winningLottoTicket = LottoTicketConverter.convert("1,2,3,4,5,6");
		LottoNumber bonusLottoNumber = LottoNumber.of(7);

		// when
		WinningLotto winningLotto = new WinningLotto(winningLottoTicket, bonusLottoNumber);
		LottoRank lottoRank = winningLotto.rank(LottoTicketConverter.convert("1,2,3,4,5,6"));

		//then
		assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
	}
}
