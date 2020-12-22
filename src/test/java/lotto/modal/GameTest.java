package lotto.modal;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {

	@Test
	@DisplayName("로또 게임: 로또 구매 금액 입력 객체 생성 테스트")
	void initLottoGameTest() {

		Game lottoGame = new Game(new ManualLotto(new ArrayList<Lotto>()), 10);

		assertThat(lottoGame).isNotNull();
		assertThat(lottoGame.getLottoPackage().size()).isEqualTo(10);
	}
}
