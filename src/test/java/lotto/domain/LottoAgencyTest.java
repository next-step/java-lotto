package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoAgencyTest {
  @Test
  @DisplayName("구매 후 몇 개를 더 구매할 수 있는지 알아낼 수 있는가")
  public void updateBalance() throws Exception {
    //given
    LottoCoupon coupon = LottoCoupon.createLottoCoupon(10);
    LottoAgency agency = new LottoAgency(new Money(14000), coupon);

    //when
    agency.purchaseLotto();

    //then
    assertEquals(agency.availablePurchaseQuantity(), 4);
  }

  @Test
  @DisplayName("전체 구매 금액을 알아낼 수 있는가")
  public void originMoney() throws Exception {
    //given
    LottoCoupon coupon = LottoCoupon.createLottoCoupon(10);
    LottoAgency agency = new LottoAgency(new Money(14000), coupon);
    //when
    //then
    assertEquals(agency.originMoney(), new Money(14000));
  }

  @Test
  @DisplayName("로또 결과를 얻어올 수 있는가")
  public void getLottoMatchResult() throws Exception {
    //given
    LottoCoupon coupon = LottoCoupon.createLottoCoupon(10);
    LottoAgency agency = new LottoAgency(new Money(14000), coupon);
    //when
    WinningNumber winningNumbers = WinningNumber
        .createWinningNumbers(Lotto.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6))
            , new Number(7));
    //then
    assertNotNull(agency.getLottoResult(winningNumbers));
  }
}