package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Lotto {

  private final List<LottoNumber> lottoNumbers;
  private static final int IS_MATCHED = 1;
  private static final int IS_NOT_MATCHED = 0;

  public Lotto(final List<LottoNumber> lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public static Lotto of(List<Integer> numbers) {
    List<LottoNumber> lottoNumbers = new ArrayList<>();
    for (Integer number : numbers) {
      lottoNumbers.add(new LottoNumber(number));
    }
    return new Lotto(lottoNumbers);
  }

  public boolean contains(LottoNumber lottoNumber) {
    return lottoNumbers.contains(lottoNumber);
  }

  public int containsCount(Lotto lotto) {
    int count = 0;
    for (LottoNumber lottoNumber : lottoNumbers) {
      count += (lotto.contains(lottoNumber) ? IS_MATCHED : IS_NOT_MATCHED);
    }
    return count;
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

  public List<LottoNumber> getLottoNumbers() {
    return lottoNumbers;
  }


}
