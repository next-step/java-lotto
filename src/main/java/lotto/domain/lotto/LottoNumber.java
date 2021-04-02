package lotto.domain.lotto;

import static lotto.io.InputView.NOT_A_NUMBER_FORMAT;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.exception.InvalidLottoNumberException;
import lotto.exception.LottoException;

public final class LottoNumber implements Comparable<LottoNumber> {

  public static final int MIN = 1;
  public static final int MAX = 45;
  public static final List<LottoNumber> LOTTO_NUMBER_POOL;

  static {
    LOTTO_NUMBER_POOL = Collections.unmodifiableList(
        IntStream.rangeClosed(MIN, MAX)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList()));
  }

  private final int lottoNumber;

  private LottoNumber(int lottoNumber) {
    this.lottoNumber = lottoNumber;
  }

  public static LottoNumber valueOf(int lottoNumber) {
    validateLottoNumber(lottoNumber);
    int lottoNumberIndex = lottoNumber - 1;
    return LOTTO_NUMBER_POOL.get(lottoNumberIndex);
  }

  private static void validateLottoNumber(int lottoNumber) {
    if (lottoNumber < MIN || lottoNumber > MAX) {
      throw new InvalidLottoNumberException();
    }
  }

  public static LottoNumber valueOf(String lottoNumber) {
    try {
      return valueOf(Integer.parseInt(lottoNumber));
    } catch (NumberFormatException e) {
      throw new LottoException(NOT_A_NUMBER_FORMAT);
    }
  }

  public String toStringValue() {
    return String.valueOf(lottoNumber);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof LottoNumber)) {
      return false;
    }
    LottoNumber that = (LottoNumber) o;
    return lottoNumber == that.lottoNumber;
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoNumber);
  }

  @Override
  public int compareTo(LottoNumber o) {
    return this.lottoNumber - o.lottoNumber;
  }
}
