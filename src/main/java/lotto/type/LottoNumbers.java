package lotto.type;

import lotto.strategy.LottoCreateStrategy;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {

  private static final int LOTTO_SIZE = 6;
  private final List<LottoNumber> value;

  public LottoNumbers(List<LottoNumber> lottoNumbers) {
    if (new HashSet<>(lottoNumbers).size() != LOTTO_SIZE) {
      throw new IllegalArgumentException("로또 번호 수가 유효하지 않습니다.");
    }

    this.value = lottoNumbers;
  }

  public LottoNumbers(String expression) {
    List<String> expressionToken = List.of(expression.split(","));

    List<LottoNumber> lottoNumbers = expressionToken.stream()
        .map(token -> new LottoNumber(Integer.parseInt(token.trim())))
        .collect(Collectors.toList());

    if (new HashSet<>(lottoNumbers).size() != LOTTO_SIZE) {
      throw new IllegalArgumentException("로또 번호 수가 유효하지 않습니다.");
    }

    this.value = lottoNumbers;
  }

  public static LottoNumbers generate(LottoCreateStrategy lottoCreateStrategy) {
    List<LottoNumber> res = new ArrayList<>();

    while (res.size() < LOTTO_SIZE) {
      LottoNumber newLottoNumber = LottoNumber.byStrategy(lottoCreateStrategy);
      if (!res.contains(newLottoNumber)) {
        res.add(newLottoNumber);
      }
    }

    res = lottoCreateStrategy.shuffle(res);
    res = res.subList(0, LOTTO_SIZE);
    Collections.sort(res);

    return new LottoNumbers(res);
  }

  public int getMatchCount(LottoNumbers other) {
    return (int) value.stream()
        .filter(other::contains).count();
  }

  public boolean isMatch(LottoNumber bonusLottoNumber) {
    return value.stream().anyMatch(bonusLottoNumber::equals);
  }

  public boolean contains(LottoNumber lottoNumber) {
    return value.contains(lottoNumber);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoNumbers that = (LottoNumbers) o;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }

  @Override
  public String toString() {
    return value.stream()
        .map(String::valueOf)
        .collect(Collectors.joining(", ", "[", "]"));
  }
}
