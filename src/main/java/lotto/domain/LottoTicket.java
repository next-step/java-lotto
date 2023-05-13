package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTicket {

  private final List<LottoNumber> numbers;

  private LottoTicket(List<LottoNumber> numbers) {
    this.numbers = numbers;
  }

  public static LottoTicket bySize(int size, LottoNumbersSelector selector) {
    LottoTicket ticket = new LottoTicket(selector.selectBy(size));
    Collections.sort(ticket.numbers);

    return ticket;
  }

  public List<LottoNumber> numbers() {
    return this.numbers;
  }

  public boolean notContains(LottoNumber lottoNumber) {
    return !numbers.contains(lottoNumber);
  }

  public Winning score(List<LottoNumber> lastWeekNumbers, LottoNumber bonusNumber) {
    int sameCount = (int) numbers.stream()
        .filter(lastWeekNumbers::contains)
        .count();

    return Winning.of(sameCount, numbers.contains(bonusNumber));
  }
}
