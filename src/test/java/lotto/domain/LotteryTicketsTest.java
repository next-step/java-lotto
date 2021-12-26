package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LotteryTicketsTest {

  @Test
  @DisplayName("Test buy N tickets.")
  void testTicketCount() {
    final long price = LotteryTicket.PRICE;
    final int count = 7;

    assertEquals(count, LotteryTickets.buy(new Money(price * count)).getLotteryTickets().size());
    assertEquals(count, LotteryTickets.buy(new Money((price * count) + (price - 1))).getLotteryTickets().size());
  }

  @Test
  @DisplayName("Test throw exception when buy a ticket less than 0.")
  void testThrows() {
    assertThrows(IllegalArgumentException.class, () -> new LotteryTickets(-1));
  }
}
