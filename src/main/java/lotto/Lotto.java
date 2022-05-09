package lotto;

import static util.Validator.validateArgument;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {

  public static final int LOTTO_PRICE = 1000;

  private static final String ERROR_MESSAGE_FOR_INVALID_NUMBERS = "로또를 구성하는 숫자가 중복되었거나 %s개가 아닙니다.";
  private static final String OUTPUT_LOTTO_NUMBER_DELIMITER = ", ";
  private static final String LOTTO_NUMBER_DELIMITER = ",";
  private static final int LOTTO_NUMBER_BOUND = 46;
  private static final int LOTTO_NUMBER_SIZE = 6;

  private static final List<LottoNumber> ENTIRE_LOTTO_NUMBERS = new ArrayList<>();

  static {
    for (int lottoNumber = 1; lottoNumber < LOTTO_NUMBER_BOUND; lottoNumber++) {
      ENTIRE_LOTTO_NUMBERS.add(new LottoNumber(lottoNumber));
    }
  }

  private final Set<LottoNumber> lotto;

  private Lotto(Set<LottoNumber> numbers) {
    validateNumbers(numbers);
    lotto = new TreeSet<>(numbers);
  }

  public int getMatchedCount(Lotto other) {
    return (int) other.lotto.stream()
        .filter(this.lotto::contains)
        .count();
  }

  public boolean hasNumber(LottoNumber number) {
    return lotto.contains(number);
  }

  @Override
  public String toString() {
    StringJoiner joiner = new StringJoiner(OUTPUT_LOTTO_NUMBER_DELIMITER);
    for (LottoNumber number : lotto) {
      joiner.add(number.toString());
    }
    return joiner.toString();
  }

  public static Lotto create() {
    Collections.shuffle(ENTIRE_LOTTO_NUMBERS);
    Set<LottoNumber> lotto = ENTIRE_LOTTO_NUMBERS.subList(0, LOTTO_NUMBER_SIZE)
        .stream()
        .collect(Collectors.toUnmodifiableSet());
    return new Lotto(lotto);
  }

  public static Lotto create(Set<Integer> numberSet) {
    return new Lotto(numberSet.stream()
        .map(LottoNumber::new)
        .collect(Collectors.toUnmodifiableSet()));
  }

  public static Lotto create(String text) {
    return create(Stream.of(text.split(LOTTO_NUMBER_DELIMITER))
        .map(String::strip)
        .map(Integer::parseInt)
        .collect(Collectors.toSet()));
  }

  private void validateNumbers(Set<LottoNumber> numbers) {
    validateArgument(
        numbers,
        (arg) -> numbers.size() == LOTTO_NUMBER_SIZE,
        String.format(ERROR_MESSAGE_FOR_INVALID_NUMBERS, LOTTO_NUMBER_SIZE)
    );
  }
}
