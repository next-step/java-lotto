package lotto.domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {

  private static final int LOTTO_CNT = 6;
  private final List<LottoNumber> numbers;

  public LottoTicket(List<Integer> numbers) {
    validate(numbers);
    this.numbers = convert(numbers);
  }

  private void validate(List<Integer> numbers) {
    if (numbers.size() != LOTTO_CNT) {
      throw new IllegalArgumentException("로또 티켓은 6개의 숫자로 이루어져있습니다.");
    }
  }

  private List<LottoNumber> convert(List<Integer> numbers) {
    return numbers.stream()
        .map(LottoNumber::of)
        .collect(Collectors.toList());
  }

  public int countMatchingNumbers(List<LottoNumber> winningNumbers) {
    int count = 0;
    Set<LottoNumber> winnings = new HashSet<>(winningNumbers);
    for (LottoNumber number : numbers) {
      if (winnings.contains(number)) {
        count += 1;
      }
    }
    return count;
  }

  @Override
  public String toString() {
    return numbers.toString();
  }
}