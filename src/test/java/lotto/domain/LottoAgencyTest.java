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
        () -> assertEquals(winningNumbers.getNumbers().size(), 6),
        () -> assertEquals(agency.getPurchaseQuantity(), 5),
        () -> assertNotNull(agency.getLottoResult(winningNumbers, new Number(10)))
    );
  }
}