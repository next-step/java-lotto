package step2.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static step2.domain.var.LottoConstant.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoShopTest {
	@Test
	@DisplayName("구입 금액 1000원당 1장의 로또를 발급하는지 확인하는 테스트")
	public void playLottoTest() {
		Money money = new Money(5 * LOTTO_PRICE);
		List<Lotto> lottos = LottoShop.buyLottos(money);
		assertThat(lottos.size()).isEqualTo(5);
	}
}
