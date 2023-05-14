package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

  private final List<LottoNumber> numbers;

  private LottoTicket(List<LottoNumber> numbers) {
    validateDuplicate(numbers);
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

  public Winning score(List<LottoNumber> lastWeekNumbers, LottoNumber bonusNumber) {
    int sameCount = (int) numbers.stream()
        .filter(lastWeekNumbers::contains)
        .count();

    return Winning.of(sameCount, numbers.contains(bonusNumber));
  }

  private static void validateDuplicate(List<LottoNumber> numbers) {
    int count = (int) numbers.stream()
        .distinct()
        .count();

    if (count != numbers.size()) {
      String reason = numbers.stream()
          .map(number -> String.valueOf(number.value()))
          .collect(Collectors.joining(",", "[", "]"));

      throw new IllegalArgumentException("로또 티켓에 중복된 숫자가 존재합니다. 입력된 값 : " + reason);
    }
  }
}
