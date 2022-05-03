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

  private static final String ERROR_MESSAGE_FOR_INVALID_NUMBERS = "로또를 생성할 숫자의 갯수가 적절하지 않습니다.";
  private static final String LOTTO_BEGIN_STRING = "[";
  private static final String LOTTO_END_STRING = "]";
  private static final String LOTTO_NUMBER_DELIMITER = ", ";
  private static final String NUMBERS_DELIMITER = ", ";
  private static final int LOTTO_NUMBER_BOUND = 46;
  private static final int LOTTO_NUMBER_SIZE = 6;

  private static final List<LottoNumber> ENTIRE_LOTTO_NUMBERS = new ArrayList<>();

  static {
    for (int lottoNumber = 1; lottoNumber < LOTTO_NUMBER_BOUND; lottoNumber++) {
      ENTIRE_LOTTO_NUMBERS.add(new LottoNumber(lottoNumber));
    }
  }

  private final Set<LottoNumber> lotto;

  Lotto() {
    Collections.shuffle(ENTIRE_LOTTO_NUMBERS);
    lotto = new TreeSet<>(ENTIRE_LOTTO_NUMBERS.subList(0, LOTTO_NUMBER_SIZE)
        .stream()
        .collect(Collectors.toUnmodifiableSet()));
  }

  Lotto(Set<Integer> numbers) {
    validateNumbers(numbers);
    lotto = new TreeSet<>(numbers.stream()
        .map(number -> new LottoNumber(number))
        .collect(Collectors.toUnmodifiableSet()));
  }

  Lotto(String text) {
    this(Stream.of(text.split(NUMBERS_DELIMITER))
        .map(Integer::parseInt)
        .collect(Collectors.toSet()));
  }

  public int getMatchedCount(Lotto other) {
    return (int) other.lotto.stream()
        .filter(this.lotto::contains)
        .count();
  }

  public String toStringForPrinting() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LOTTO_BEGIN_STRING);

    StringJoiner stringJoiner = new StringJoiner(LOTTO_NUMBER_DELIMITER);
    lotto.forEach(lottoNumber -> stringJoiner.add(lottoNumber.toString()));

    stringBuilder.append(stringJoiner);
    stringBuilder.append(LOTTO_END_STRING);
    return stringBuilder.toString();
  }

  private void validateNumbers(Set<Integer> numbers) {
    validateArgument(
        numbers,
        (arg) -> numbers.size() == LOTTO_NUMBER_SIZE,
        ERROR_MESSAGE_FOR_INVALID_NUMBERS
    );
  }
}
