package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {

  private static final String ERROR_INVALID_COUNT = "로또 번호는 6개여야 한다";
  private static final String ERROR_OUT_OF_RANGE = "로또 번호는 1~45 범위의 숫자여야 한다";

  private final Set<Integer> numbers;

  public Lotto(String numbersString) {
    this(parseNumbers(numbersString));
  }

  public Lotto(Integer... numbers) {
    this(List.of(numbers));
  }

  public Lotto(List<Integer> numbers) {
    validate(numbers);
    this.numbers = new TreeSet<>(numbers);
  }

  private static List<Integer> parseNumbers(String numbersString) {
    String[] numberStrings = numbersString.split(",");
    List<Integer> nums = new ArrayList<>();
    for (String s : numberStrings) {
      nums.add(parseIntOrThrow(s));
    }
    return nums;
  }

  private static int parseIntOrThrow(String s) {
    try {
      return Integer.parseInt(s.trim());
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("숫자 형식이 올바르지 않습니다: " + s);
    }
  }

  private static void validate(List<Integer> numbers) {
    validateNumbersCount(numbers);
    validateNumberRange(numbers);
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
    return Collections.unmodifiableList(new ArrayList<>(numbers));
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
