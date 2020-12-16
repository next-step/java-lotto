package lotto.modal;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LottoGameTest {

	@Test
	void initLottoGameTest() {

		LottoGame lottoGame = new LottoGame(new Money("10000"));

		assertThat(lottoGame).isNotNull();
		assertThat(lottoGame.getLottoPackage().size()).isEqualTo(10);
	}
}
