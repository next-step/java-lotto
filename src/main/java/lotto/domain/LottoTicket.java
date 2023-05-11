package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
  private final List<LottoNumber> numbers;

  private LottoTicket(List<LottoNumber> numbers) {
    this.numbers = numbers;
  }

  public static LottoTicket bySize(int size) {
    LottoTicket ticket = new LottoTicket(LottoNumbers.collectBySize(size));
    Collections.sort(ticket.numbers);

    return ticket;
  }

  public List<LottoNumber> numbers() {
    return this.numbers;
  }

  public int sameCount(List<LottoNumber> lastWeekNumbers) {
    return (int) numbers.stream()
        .filter(lastWeekNumbers::contains)
        .count();
  }
}
