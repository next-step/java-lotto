package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTicket {
  private final List<LottoNumber> numbers;

  private LottoTicket(List<LottoNumber> numbers) {
    this.numbers = numbers;
  }

  public static LottoTicket bySize(int size) {
    LottoTicket ticket = new LottoTicket(LottoNumbers.pick(size));
    Collections.sort(ticket.numbers);

    return ticket;
  }

  public List<LottoNumber> numbers() {
    return this.numbers;
  }
}
