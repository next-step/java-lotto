package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.lotto.Money;
import lotto.domain.lotto.Purchase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PurchaseTest {

  @ParameterizedTest
  @CsvSource({
      "1000, 1, 1000",
      "1000, 5, 5000",
      "1000, 10, 10000",
      "2000, 3, 6000"
  })
  void getPurchaseAmount(int pricePerTicket, int ticketCount, int expectedAmount) {
    Purchase purchase = new Purchase(new Money(pricePerTicket), ticketCount);
    assertThat(purchase.getPurchaseAmount()).isEqualTo(new Money(expectedAmount));
  }

}