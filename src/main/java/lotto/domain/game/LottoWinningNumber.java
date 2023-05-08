package lotto.domain.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.number.LottoNumber;

public class LottoWinningNumber {
  private final List<LottoNumber> numbers;
  private final LottoNumber bonusNumber;

  public LottoWinningNumber(List<Integer> numbers, int bonusNumber) {
    this.bonusNumber = new LottoNumber(bonusNumber);
    this.numbers = numbers.stream()
        .map(LottoNumber::new)
        .collect(Collectors.toList());
  }

  public boolean containsWinningNumbers(LottoNumber lottoNumber) {
    return this.numbers.contains(lottoNumber);
  }

  public LottoNumber getBonusNumber() {
    return bonusNumber;
  }

  public boolean containsDuplicateNumber() {
    final int allNumberCnt = numbers.size() + 1;
    final List<LottoNumber> allNumbers = new ArrayList<>(allNumberCnt);
    allNumbers.addAll(numbers);
    allNumbers.add(bonusNumber);

    long distinctNumberCnt = allNumbers.stream()
        .distinct()
        .count();

    return distinctNumberCnt != allNumberCnt;
  }
}
