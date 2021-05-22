package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoDrawerTest {
	@Test
	@DisplayName("입력받은 가격만큼의 로또를 발행한다")
	void drawLottosTest() {
		BigDecimal receivedMoney = BigDecimal.valueOf(14000);
		LottoDrawer lottoDrawer = new LottoDrawer();

		Lottos lottos = lottoDrawer.draw(receivedMoney);
		assertThat(lottos.size()).isEqualTo(14);
	}

	@Test
	@DisplayName("로또 번호를 생성한다")
	void drawLottoTest() {
		LottoDrawer lottoDrawer = new LottoDrawer();
		Lotto lotto = lottoDrawer.draw();
		assertThat(lotto.numbers().size()).isEqualTo(6);
	}
}
