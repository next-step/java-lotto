package lotto;

import static lotto.LottoGameConstant.MAXIMUM_LOTTO_NUMBER;
import static lotto.LottoGameConstant.MINIMUM_LOTTO_NUMBER;
import static lotto.LottoGameConstant.NUMBERS_PER_TICKET;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberPool {

  private static final List<LottoNumber> randomBox = IntStream
      .range(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER + 1)
      .mapToObj(LottoNumber::get)
      .collect(Collectors.toList());

  private NumberPool() {
  }

  public static LottoTicket publishTicket() {
    PublishStrategy strategy = () -> {
      List<LottoNumber> numbers = new ArrayList<>();
      Collections.shuffle(randomBox);
      for (int i = 0; i < NUMBERS_PER_TICKET; i++) {
        numbers.add(randomBox.get(i));
      }
      return LottoTicket.of(numbers);
    };

    return publishTicket(strategy);
  }

  public static LottoTicket publishTicket(PublishStrategy publishStrategy) {
    return publishStrategy.publish();
  }

  public static LottoTickets purchaseTickets(int numTicket) {
    return purchaseTickets(numTicket, NumberPool::publishTicket);
  }

  public static LottoTickets purchaseTickets(int numTicket, PublishStrategy publishStrategy) {
    List<LottoTicket> tickets = new ArrayList<>();
    for (int i = 0; i < numTicket; i++) {
      tickets.add(publishTicket(publishStrategy));
    }
    return LottoTickets.of(tickets);
  }
}
