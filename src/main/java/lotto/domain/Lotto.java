package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

  private static final int LOTTO_NUMBERS_SIZE = 6;

  private final Set<LottoNumber> lottoNumbers;

  public Lotto(List<Integer> lottoNumbers) {
    this(toLottoNumbers(lottoNumbers));
  }

  public Lotto(Set<LottoNumber> lottoNumbers) {
    if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
      throw new IllegalArgumentException("로또 번호가 6자리가 아닙니다.");
    }
    this.lottoNumbers = lottoNumbers;
  }

  public long countByMatch(Lotto lotto) {
    return lottoNumbers.stream()
        .filter(lotto::contains)
        .count();
  }

  public boolean contains(LottoNumber lottoNumber) {
    return lottoNumbers.contains(lottoNumber);
  }

  private static Set<LottoNumber> toLottoNumbers(List<Integer> lottoNumbers) {
    return lottoNumbers.stream()
        .map(LottoNumber::from)
        .collect(Collectors.toSet());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Lotto lotto = (Lotto) o;
    return Objects.equals(lottoNumbers, lotto.lottoNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoNumbers);
  }

  @Override
  public String toString() {
    return String.valueOf(lottoNumbers);
  }
}
