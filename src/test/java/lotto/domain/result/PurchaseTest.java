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
    LottoTickets tickets = createTickets(ticketCount);
    Purchase purchase = new Purchase(new Money(pricePerTicket), tickets);
    assertThat(purchase.getPurchaseAmount()).isEqualTo(new Money(expectedAmount));
  }


  private LottoTickets createTickets(int count) {
    List<LottoTicket> tickets = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      tickets.add(new LottoTicket(1, 2, 3, 4, 5, 6));
    }
    return new LottoTickets(tickets);
  }
}