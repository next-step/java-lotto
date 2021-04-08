package lotto.domain;

import lotto.function.GenerateNumbers;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {
  private static final int LOTTO_NUMBER_TOTAL_COUNT = 6;
  private static final String EXCEPTION_MESSAGE = "로또는 6자리 숫자로 생성해야 됩니다.";

  private final List<LottoNumber> list;

  private LottoNumbers(List<LottoNumber> list) {
    this.list = Collections.unmodifiableList(list);
  }

  public static LottoNumbers generateSixNumbers(final GenerateNumbers generateNumbers) {
    List<LottoNumber> lottoNumbers = generateNumbers.get();
    if (lottoNumbers.size() != LOTTO_NUMBER_TOTAL_COUNT) {
      throw new IllegalArgumentException(EXCEPTION_MESSAGE);
    }
    return new LottoNumbers(lottoNumbers);
  }

  public int size() {
    return list.size();
  }

  public int matchLottoNumber(final LottoNumbers otherNumber) {
    return list.stream()
            .filter(lottoNumber -> otherNumber.list.contains(lottoNumber))
            .collect(Collectors.toList())
            .size();
  }

  public List<LottoNumber> getList() {
    return list;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoNumbers that = (LottoNumbers) o;
    return Objects.equals(list, that.list);
  }

  @Override
  public int hashCode() {
    return Objects.hash(list);
  }

  @Override
  public String toString() {
    return String.valueOf(list);
  }
}
