package lotto;

import static lotto.LottoGameConstant.NUMBERS_PER_BUNDLE;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import lotto.lottoexception.DuplicatedNumberException;
import lotto.lottoexception.InvalidLottoFormatException;

public class LottoNumberBundle implements Iterable<LottoNumber> {

  private final List<LottoNumber> numbers;

  private LottoNumberBundle(List<LottoNumber> numbers) {
    this.numbers = numbers;
  }

  public static LottoNumberBundle of(String rawInput) {
    List<LottoNumber> parsedInput = Arrays.stream(rawInput.split(", "))
        .map(Integer::parseInt)
        .map(LottoNumber::get)
        .collect(Collectors.toList());

    return of(parsedInput);
  }

  public static LottoNumberBundle of(List<LottoNumber> parsedInput) {
    validateParsedInput(parsedInput);
    return new LottoNumberBundle(parsedInput);
  }

  private static void validateParsedInput(List<LottoNumber> parsedInput) {
    if (parsedInput == null || parsedInput.size() != NUMBERS_PER_BUNDLE) {
      throw new InvalidLottoFormatException();
    }

    Collections.sort(parsedInput);

    // 중복 체킹. sort 되어 있으므로 붙어 있는 번호가 동일하면 예외
    for (int i = 0; i < NUMBERS_PER_BUNDLE - 1; i++) {
      checkEquality(parsedInput.get(i), parsedInput.get(i + 1));
    }
  }

  private static void checkEquality(LottoNumber number1, LottoNumber number2) {
    if (number1.equals(number2)) {
      throw new DuplicatedNumberException();
    }
  }

  public boolean contains(LottoNumber o) {
    return this.numbers.contains(o);
  }

  public String toString() {
    return this.numbers.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoNumberBundle that = (LottoNumberBundle) o;
    return Objects.equals(numbers, that.numbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numbers);
  }

  @Override
  public Iterator<LottoNumber> iterator() {
    return this.numbers.iterator();
  }

  @Override
  public void forEach(Consumer<? super LottoNumber> action) {
    this.numbers.forEach(action);
  }

  @Override
  public Spliterator<LottoNumber> spliterator() {
    return this.numbers.spliterator();
  }
}
