package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoAgencyTest {
  @Test
  @DisplayName("금액 / 1000이 구매 로또 개수와 일치하는가")
  public void buy() throws Exception {
    LottoAgency agency = new LottoAgency(new Money(14455));

    //when
    agency.purchaseLotto();

    //then
    assertEquals(agency.getPurchaseQuantity(), 14);
  }

  @Test
  @DisplayName("로또 매치 결과를 얻을 수 있는가")
  public void updateWinnerNumber() throws Exception {
    //given
    Lotto winningNumbers = Lotto.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    LottoAgency agency = new LottoAgency(new Money(5000));

    //when
    agency.purchaseLotto();

    //then
    assertAll(
        () -> assertEquals(winningNumbers.toNumbers().size(), 6),
        () -> assertEquals(agency.getPurchaseQuantity(), 5),
        () -> assertNotNull(agency.getLottoResult(new WinningNumber(winningNumbers, new Number(6))))
    );
  }

  @Test
  @DisplayName("입력된 개수에 따라 구매한 로또의 가격이 나오는가")
  public void purchaseLottoPrice() throws Exception {
    //given
    LottoAgency agency = new LottoAgency(new Money(10000));

    //when
    Money money = agency.lottoPurchaseMoney(new Number(8));

    //then
    assertEquals(new Money(8000), money);
  }

  @Test
  @DisplayName("updateBalance를 통해서 현재까지 구매한 금액을 제외하고 더 구매할 수 있는 수량을 구할 수 있는가")
  public void updateMoney() throws Exception {
    //given
    LottoAgency agency = new LottoAgency(new Money(10000));

    //when
    Money money = agency.lottoPurchaseMoney(new Number(8));
    agency.updateBalance(money);

    //then
    assertEquals(agency.getPurchaseQuantity(), 2);
  }
}