package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {

  public static final int MIN_NUMBER = 1;
  public static final int MAX_NUMBER = 45;
  public static final int LOTTO_NUMBER_COUNT = 6;

  private static final String ERROR_INVALID_COUNT = "로또 번호는 6개여야 한다";
  private static final String ERROR_DUPLICATE_NUMBER = "로또 번호에 중복이 있을 수 없습니다.";
  private static final String ERROR_INVALID_FORMAT = "숫자 형식이 올바르지 않습니다: ";

  private final Set<LottoNumber> numbers;

  public Lotto(String numbersString) {
    this(toLottoNumbers(parseNumbers(numbersString)));
  }

  public Lotto(Integer... numbers) {
    this(toLottoNumbers(List.of(numbers)));
  }

  public Lotto(List<LottoNumber> numbers) {
    validateNumbersCount(numbers);
    this.numbers = new TreeSet<>(numbers);
  }

  public static Lotto fromIntegers(List<Integer> numbers) {
    return new Lotto(toLottoNumbers(numbers));
  }

  public List<LottoNumber> numbers() {
    return Collections.unmodifiableList(new ArrayList<>(numbers));
  }

  public boolean contains(LottoNumber number) {
    return numbers.contains(number);
  }

  private static List<LottoNumber> toLottoNumbers(List<Integer> numbers) {
    return numbers.stream()
        .map(LottoNumber::of)
        .toList();
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
      throw new IllegalArgumentException(ERROR_INVALID_FORMAT + s);
    }
  }

  private static void validateNumbersCount(List<LottoNumber> numbers) {
    if (numbers.size() != LOTTO_NUMBER_COUNT) {
      throw new IllegalArgumentException(ERROR_INVALID_COUNT);
    }

    long distinctCount = numbers.stream().distinct().count();
    if (distinctCount != LOTTO_NUMBER_COUNT) {
      throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBER);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Lotto lotto = (Lotto) o;
    return Objects.equals(numbers, lotto.numbers);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(numbers);
  }

  @Override
  public String toString() {
    return numbers.toString();
  }
}
