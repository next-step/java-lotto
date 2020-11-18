package lotto;

import static lotto.LottoGameConstant.MAXIMUM_LOTTO_NUMBER;
import static lotto.LottoGameConstant.MINIMUM_LOTTO_NUMBER;
import static lotto.LottoGameConstant.NUMBERS_PER_TICKET;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberPool {

  private static final List<LottoNumber> numberPool = new ArrayList<>();

  static {
    for (int i = MINIMUM_LOTTO_NUMBER; i <= MAXIMUM_LOTTO_NUMBER; i++) {
      numberPool.add(LottoNumber.of(i));
    }
  }

  private NumberPool() {
  }

  public static LottoTicket publishTicket() {
    PublishStrategy strategy = () -> {
      List<LottoNumber> numbers = new ArrayList<>();
      Collections.shuffle(numberPool);
      for (int i = 0; i < NUMBERS_PER_TICKET; i++) {
        numbers.add(numberPool.get(i));
      }
      return LottoTicket.of(numbers);
    };

    return publishTicket(strategy);
  }

  public static LottoTicket publishTicket(PublishStrategy publishStrategy) {
    return publishStrategy.publish();
  }

  public static LottoTickets purchaseTickets(int numTicket) {
    List<LottoTicket> tickets = new ArrayList<>();
    for (int i = 0; i < numTicket; i++) {
      tickets.add(NumberPool.publishTicket());
    }
    return LottoTickets.of(tickets);
  }
}
