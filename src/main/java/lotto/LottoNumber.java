package lotto;

import static util.RandomNumberGenerator.generateRandomNumberInRange;
import static util.Validator.validateArgument;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

  private static final String MESSAGE_FOR_INVALID_LOTTO_NUMBER = "잘못된 로또 번호입니다.";
  private static final int MIN_LOTTO_NUMBER = 1;
  private static final int LOTTO_NUMBER_BOUND = 46;
  private final int value;


  LottoNumber() {
    int lottoNumber = generateRandomNumberInRange(MIN_LOTTO_NUMBER, LOTTO_NUMBER_BOUND);
    validate(lottoNumber);
    this.value = lottoNumber;
  }

  LottoNumber(int number) {
    validate(number);
    this.value = number;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoNumber that = (LottoNumber) o;
    return value == that.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public int compareTo(LottoNumber o) {
    return Integer.compare(this.value, o.value);
  }

  private void validate(int value) {
    validateArgument(
        value,
        (arg) -> MIN_LOTTO_NUMBER <= arg && arg < LOTTO_NUMBER_BOUND,
        MESSAGE_FOR_INVALID_LOTTO_NUMBER
    );
  }
}
