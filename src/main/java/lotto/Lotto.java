package lotto;

import static util.Validator.validateArgument;

import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;

public class Lotto {

  private static final String ERROR_MESSAGE_FOR_INVALID_NUMBERS = "로또를 생성할 숫자의 갯수가 적절하지 않습니다.";
  private static final String LOTTO_BEGIN_STRING = "[";
  private static final String LOTTO_END_STRING = "]";
  private static final String LOTTO_NUMBER_DELIMITER = ", ";
  private static final int LOTTO_NUMBER_SIZE = 6;

  private final TreeSet<LottoNumber> lottoNumbersSet = new TreeSet<>();


  Lotto() {
    do {
      lottoNumbersSet.add(new LottoNumber());
    } while (lottoNumbersSet.size() < LOTTO_NUMBER_SIZE );
  }

  Lotto(Set<Integer> numbers) {
    validateNumbers(numbers);
    numbers.forEach(number -> lottoNumbersSet.add(new LottoNumber(number)));
  }

  public boolean matches(int expectedMatchedCount, Lotto other) {
    return expectedMatchedCount == other.lottoNumbersSet.stream()
        .filter(this.lottoNumbersSet::contains)
        .count();
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LOTTO_BEGIN_STRING);

    StringJoiner stringJoiner = new StringJoiner(LOTTO_NUMBER_DELIMITER);
    lottoNumbersSet.forEach(lottoNumber -> stringJoiner.add(lottoNumber.toString()));

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
