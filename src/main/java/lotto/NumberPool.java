package lotto;

import static lotto.LottoGameConstant.MAXIMUM_LOTTO_NUMBER;
import static lotto.LottoGameConstant.MINIMUM_LOTTO_NUMBER;
import static lotto.LottoGameConstant.NUMBERS_PER_TICKET;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberPool {

  private static final List<LottoNumber> numberPool = new ArrayList<>();
  private static final Map<Integer, LottoNumber> integerLottoNumberMapper = new HashMap<>();

  static {
    for (int i = MINIMUM_LOTTO_NUMBER; i <= MAXIMUM_LOTTO_NUMBER; i++) {
      LottoNumber number = LottoNumber.of(i);
      numberPool.add(number);
      integerLottoNumberMapper.put(i, number);
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
    return purchaseTickets(numTicket, NumberPool::publishTicket);
  }

  public static LottoTickets purchaseTickets(int numTicket, PublishStrategy publishStrategy) {
    List<LottoTicket> tickets = new ArrayList<>();
    for (int i = 0; i < numTicket; i++) {
      tickets.add(publishTicket(publishStrategy));
    }
    return LottoTickets.of(tickets);
  }

  public static WinningNumber publishWinningNumber(String input) {
    String[] tokenizedInputs = input.split(", ");
    List<LottoNumber> numbers = new ArrayList<>();

    for (String tokenizedInput : tokenizedInputs) {
      int castedInput = Integer.parseInt(tokenizedInput);
      numbers.add(integerLottoNumberMapper.get(castedInput));
    }

    return WinningNumber.of(numbers);
  }
}
