package lotto.domain;

import java.util.Objects;
import java.util.regex.Pattern;
import lotto.exception.InvalidLottoNumberException;

public class LottoNumber {

  private final int value;
  public static final int MIN = 1;
  public static final int MAX = 45;
  private static final Pattern CONTAINS_ONLY_NUMBER_PATTERN = Pattern.compile("^\\d+$");

  public LottoNumber(int value) {
    if (checkBound(value)) {
      throw new InvalidLottoNumberException(String.valueOf(value));
    }
    this.value = value;
  }

  public LottoNumber(String value) {
    if (!CONTAINS_ONLY_NUMBER_PATTERN.matcher(value).find()) {
      throw new InvalidLottoNumberException(value);
    }
    this.value = Integer.parseInt(value);
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

  public int getValue() {
    return value;
  }

  private boolean checkBound(int value) {
    return value < MIN || value > MAX;
  }
}
