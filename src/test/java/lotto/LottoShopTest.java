package lotto;

import lotto.LottoGeneratorTest.TestLottoGenerator;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoShopTest {

  @DisplayName("금액을 지불하면 가격에 맞는 로또 티켓들을 생성해주는 기능을 테스트한다.")
  @Test
  void testBuyLottoTicket() {
    PurchaseAmount purchaseAmount = new PurchaseAmount(10000);

    LottoShop lottoShop = new LottoShop(new TestLottoGenerator());
    Lottos lottos = lottoShop.buyLottos(purchaseAmount);

    assertEquals(10, lottos.getCount());
  }
}
