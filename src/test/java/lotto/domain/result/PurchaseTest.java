package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.lotto.Money;
import lotto.domain.lotto.Purchase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PurchaseTest {

  @ParameterizedTest
  @CsvSource({
      "0, 1, 1000, 1000",
      "2, 5, 1000, 5000",
      "5, 10, 1000, 10000",
      "1, 3, 2000, 6000"
  })
  void getPurchaseAmount(int manualCount, int totalCount, int pricePerTicket, int expectedAmount) {
    Purchase purchase = new Purchase(manualCount, totalCount, new Money(pricePerTicket));
    assertThat(purchase.getPurchaseAmount()).isEqualTo(new Money(expectedAmount));
  }

  @ParameterizedTest
  @CsvSource({
      "3, 10, 7",
      "0, 10, 10",
      "5, 10, 5"
  })
  void getAutoCount(int manualCount, int totalCount, int expectedAutoCount) {
    Purchase purchase = new Purchase(manualCount, totalCount, new Money(1000));
    assertThat(purchase.getAutoCount()).isEqualTo(expectedAutoCount);
  }
}