package lotto.domain.input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoBuyCountTest {

	@Test
	void 수동_자동_로또_구매_개수_확인() {
		LottoBuyCount lottoTotalBuyCount = new LottoBuyCount(new Money(10000), 8);
		assertThat(lottoTotalBuyCount.getAutoLottoCount()).isEqualTo(2);
		assertThat(lottoTotalBuyCount.getManualLottoCount()).isEqualTo(8);

	}
}