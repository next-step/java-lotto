package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinLottoTest {

	@DisplayName("당첨 번호 목록에 보너스 번호가 포함되는 경우 - 예외 케이스")
	@Test
	void test1() {
		WinLotto winLotto = new WinLotto(new WinNumbers("1, 2, 3, 4, 5, 6"), new LottoNumber(1));
		assertThatIllegalArgumentException().isThrownBy(() -> winLotto.calculateScore(new PurchasedLottos()));
	}
}
