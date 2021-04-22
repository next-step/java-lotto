package lotto.domain;

import calculator.util.StringUtil;
import lotto.function.GenerateNumbers;

import java.util.Objects;
import java.util.stream.Collectors;

public class WiningLottery {
  private final Lottery value;

  private WiningLottery(Lottery value) {
    this.value = value;
  }

  public static WiningLottery generate(final GenerateNumbers generateNumbers) {
    return new WiningLottery(Lottery.generateSixNumbers(generateNumbers));
  }

  public static WiningLottery generate(final String winningNumbersString) {
    return generate(() -> StringUtil.splitToList(winningNumbersString)
            .stream()
            .map(StringUtil::trim)
            .map(Integer::parseInt)
            .map(LottoNumber::generate)
            .collect(Collectors.toList()));
  }

  public int countOfMatch(final Lottery other) {
    return value.matchLottoNumber(other);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    WiningLottery that = (WiningLottery) o;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}
