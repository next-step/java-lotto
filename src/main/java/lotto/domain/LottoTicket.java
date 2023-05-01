package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTicket {
  private final List<LottoNumber> numbers;

  private LottoTicket(List<LottoNumber> numbers) {
    this.numbers = numbers;
  }

  public static LottoTicket bySize(int size) {
    LottoTicket ticket = new LottoTicket(LottoNumbers.pickBySize(size));
    Collections.sort(ticket.numbers);

    return ticket;
  }

  public List<LottoNumber> numbers() {
    return this.numbers;
  }

  public int sameCount(List<LottoNumber> lastWeekNumbers) {
    int count = 0;
    for (LottoNumber lastWeekNumber : lastWeekNumbers) {
      count = numbers.contains(lastWeekNumber) ? count + 1 : count;
    }

    return count;
  }
}
