package lotto.domain.input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoBuyCountTest {

	@Test
	void 수동_자동_로또_구매_개수_확인() {
		LottoBuyCount lottoTotalBuyCount = new LottoBuyCount(10);
		LottoBuyCount manualLottoCount = new LottoBuyCount(3);
		assertThat(lottoTotalBuyCount.getAutoLottoCount(manualLottoCount).getLottoBuyCount()).isEqualTo(7);

	}
}