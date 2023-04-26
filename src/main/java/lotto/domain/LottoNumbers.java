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
  private final List<Integer> numbers;

  public LottoNumbers(List<Integer> numbers) {
    validNumberCount(numbers);
    validDuplicationNumber(numbers);
    validNumberRange(numbers);
    this.numbers = numbers.stream()
                          .sorted()
                          .collect(Collectors.toList());
  }

  private static void validNumberCount(List<Integer> numbers) {
    if (numbers.size() != LOTTO_NUMBERS_COUNT) {
      throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
    }
  }

  private static void validDuplicationNumber(List<Integer> numbers) {
    if (validDuplicates(numbers)) {
      throw new IllegalArgumentException("로또 번호는 중복이 없어야 합니다.");
    }
  }

  private static void validNumberRange(List<Integer> numbers) {
    if (!new HashSet<>(POSSIBLE_NUMBER_RANGE).containsAll(numbers)) {
      throw new IllegalArgumentException("로또 번호는 1~45 사이의 숫자여야 합니다.");
    }
  }

  private static boolean validDuplicates(List<Integer> numbers) {
    return numbers.size() != new HashSet<>(numbers).size();
  }

  public int matchCount(LottoNumbers winningNumbers) {
    return (int) numbers.stream()
                        .filter(winningNumbers::contains)
                        .count();
  }

  public boolean contains(int number) {
    return numbers.contains(number);
  }

  public List<Integer> getNumbers() {
    return numbers;
  }
}
