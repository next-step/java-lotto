package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

  private static final int LOTTO_NUMBER_COUNT = 6;
  private static final int MIN_NUMBER = 1;
  private static final int MAX_NUMBER = 45;

  private static final String ERROR_DUPLICATE = "로또 번호는 중복될 수 없습니다";
  private static final String ERROR_INVALID_COUNT = "로또 번호는 6개여야 한다";
  private static final String ERROR_OUT_OF_RANGE = "로또 번호는 1~45 범위의 숫자여야 한다";

  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    validate(numbers);
    List<Integer> sortedNumbers = new ArrayList<>(numbers);
    Collections.sort(sortedNumbers);
    this.numbers = sortedNumbers;
  }

  private static void validate(List<Integer> numbers) {
    validateNumbersCount(numbers);
    validateNumberRange(numbers);
    validateNoDuplicates(numbers);
  }

  private static void validateNoDuplicates(List<Integer> numbers) {
    Set<Integer> uniqueNumbers = new HashSet<>(numbers);
    if (uniqueNumbers.size() != numbers.size()) {
      throw new IllegalArgumentException(ERROR_DUPLICATE);
    }
  }

  private static void validateNumbersCount(List<Integer> numbers) {
    if (numbers.size() != LottoConstants.LOTTO_NUMBER_COUNT) {
      throw new IllegalArgumentException(ERROR_INVALID_COUNT);
    }
  }

  private static void validateNumberRange(List<Integer> numbers) {
    for (int number : numbers) {
      checkRange(number);
    }
  }

  private static void checkRange(int number) {
    if (number < LottoConstants.MIN_NUMBER || number > LottoConstants.MAX_NUMBER) {
      throw new IllegalArgumentException(ERROR_OUT_OF_RANGE);
    }
  }

  public List<Integer> numbers() {
    return new ArrayList<>(numbers);
  }

  public int countMatchingNumbers(Lotto winningNumbers) {
    int count = 0;
    for (Integer number : numbers) {
      if (winningNumbers.contains(number)) {
        count++;
      }
    }
    return count;
  }

  private boolean contains(Integer number) {
    return numbers.contains(number);
  }

  @Override
  public String toString() {
    return numbers.toString();
  }
}
