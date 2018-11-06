package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LottoMachineTest {

	@Test
	public void 자동으로_구매한_로또_확인() {
		final int lottoCount = 6;
		LottoMachine lottoMachine = new LottoMachine(lottoCount * LottoMachine.LOTTO_PRICE);
		LottoTicket lottoTicket = lottoMachine.getLottos();

		assertThat(lottoTicket.getLottos()).hasSize(lottoCount);
	}

	@Test(expected = IllegalArgumentException.class)
	public void 잘못된_구매_개수_검증() {
		new LottoMachine(LottoMachine.LOTTO_PRICE - LottoMachine.LOTTO_PRICE);
	}
}