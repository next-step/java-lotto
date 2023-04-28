package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

  private static final int LOTTO_NUMBERS_COUNT = 6;
  public static final List<Integer> POSSIBLE_NUMBER_RANGE = IntStream.rangeClosed(1, 45)
                                                                     .boxed()
                                                                     .collect(Collectors.toList());
  private final List<LottoNumber> numbers;

  public LottoNumbers(List<LottoNumber> numbers) {
    validNumberCount(numbers);
    validDuplicationNumber(numbers);
    this.numbers = numbers.stream()
                          .sorted()
                          .collect(Collectors.toList());
  }

  private static void validNumberCount(List<LottoNumber> numbers) {
    if (numbers.size() != LOTTO_NUMBERS_COUNT) {
      throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
    }
  }

  private static void validDuplicationNumber(List<LottoNumber> numbers) {
    if (validDuplicates(numbers)) {
      throw new IllegalArgumentException("로또 번호는 중복이 없어야 합니다.");
    }
  }

  private static boolean validDuplicates(List<LottoNumber> numbers) {
    return numbers.size() != new HashSet<>(numbers).size();
  }

  public MatchNumbersCount matchCount(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
    return MatchNumbersCount.of(this, winningNumbers, bonusNumber);
  }

  public boolean contains(LottoNumber lottoNumber) {
    return numbers.contains(lottoNumber);
  }

  public List<LottoNumber> getNumbers() {
    return numbers;
  }
}
