package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PurchaseInfoTest {

  @DisplayName("로또 한 장의 가격보다 적은 금액으로 로또를 구매할 수 없다.")
  @Test
  void testPurchaseAmountCannotBeLessThanLottoPrice() {
    int money = Lotto.PRICE - 100;

    assertThatThrownBy(() -> new PurchaseInfo(money))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 한 장의 가격보다 적은 금액으로 로또를 구매할 수 없습니다.");
  }

  @DisplayName("0 미만의 금액으로 로또를 구매할 수 없다.")
  @Test
  void testPurchaseAmountCannotBeNegative() {
    int money = -1000;

    assertThatThrownBy(() -> new PurchaseInfo(money))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("0 미만의 금액으로 로또를 구매할 수 없습니다.");
  }

  @DisplayName("로또 구매 가격과 총 당첨금의 수익률을 계산하는 테스트")
  @Test
  void testCalculateProfitRate() {
    PurchaseInfo purchaseInfo = new PurchaseInfo(14000);
    int totalPrizeMoney = 28000;

    double profitRate = purchaseInfo.calculateProfitRate(totalPrizeMoney);
    assertEquals(2, profitRate);
  }

  @DisplayName("수동 로또 개수가 총 로또 개수보다 많으면 예외를 발생시킨다.")
  @Test
  void testManualLottoCountCannotBeGreaterThanTotalLottoCount() {
    int money = 14000;
    int manualLottoCount = 15;

    assertThatThrownBy(() -> new PurchaseInfo(money, manualLottoCount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("수동 로또 개수가 총 로또 개수보다 많습니다.");
  }

  @DisplayName("0 미만의 수동 로또 개수로 로또를 구매할 수 없다.")
  @Test
  void testManualLottoCountCannotBeNegative() {
    int money = 14000;
    int manualLottoCount = -1;

    assertThatThrownBy(() -> new PurchaseInfo(money, manualLottoCount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("0 미만의 수동 로또 개수로 로또를 구매할 수 없습니다.");
  }
}