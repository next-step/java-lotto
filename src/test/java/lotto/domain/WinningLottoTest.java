package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

	@DisplayName("당첨 번호 목록에 보너스 번호가 포함되는 경우 - 예외 케이스")
	@Test
	void test1() {
		WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6");
		PurchasedLottos purchasedLottos = new PurchasedLottos();
		assertThatIllegalArgumentException().isThrownBy(() -> winningLotto.calculateScore(purchasedLottos, LottoNumber.of(1)));
	}
}
