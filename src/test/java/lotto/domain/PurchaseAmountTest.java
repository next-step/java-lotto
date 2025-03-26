package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PurchaseAmountTest {

  @DisplayName("로또 한 장의 가격보다 적은 금액으로 로또를 구매할 수 없다.")
  @Test
  void testPurchaseAmountCannotBeLessThanLottoPrice() {
    int money = Lotto.PRICE - 100;

    assertThatThrownBy(() -> new PurchaseAmount(money))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 한 장의 가격보다 적은 금액으로 로또를 구매할 수 없습니다.");
  }

  @DisplayName("0 미만의 금액으로 로또를 구매할 수 없다.")
  @Test
  void testPurchaseAmountCannotBeNegative() {
    int money = -1000;

    assertThatThrownBy(() -> new PurchaseAmount(money))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("0 미만의 금액으로 로또를 구매할 수 없습니다.");
  }

  @DisplayName("로또 구매 가격과 총 당첨금의 수익률을 계산하는 테스트")
  @Test
  void testCalculateProfitRate() {
    PurchaseAmount purchaseAmount = new PurchaseAmount(14000);
    int totalPrizeMoney = 28000;

    double profitRate = purchaseAmount.calculateProfitRate(totalPrizeMoney);
    assertEquals(2, profitRate);
  }
}