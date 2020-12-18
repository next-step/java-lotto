package lotto.modal;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGameTest {

	@Test
	@DisplayName("로또 게임: 로또 구매 금액 입력 객체 생성 테스트")
	void initLottoGameTest() {

		LottoGame lottoGame = new LottoGame(new Money("10000"));

		assertThat(lottoGame).isNotNull();
		assertThat(lottoGame.getLottoPackage().size()).isEqualTo(10);
	}
}
