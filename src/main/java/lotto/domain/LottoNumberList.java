package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoNumberList {

  private List<LottoNumber> lottoNumbers;
  private static final int IS_MATCHED = 1;
  private static final int IS_NOT_MATCHED = 0;

  public LottoNumberList(List<LottoNumber> lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public int containsCount(Lotto lastWeekWinningLotto) {
    int count = 0;
    for (LottoNumber lottoNumber : lottoNumbers) {
      count += (lastWeekWinningLotto.contains(lottoNumber) ? IS_MATCHED : IS_NOT_MATCHED);
    }
    return count;
  }

  public boolean contains(LottoNumber lottoNumber) {
    return lottoNumbers.contains(lottoNumber);
  }

  public List<LottoNumber> getLottoNumbers() {
    return lottoNumbers;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoNumberList that = (LottoNumberList) o;
    return Objects.equals(lottoNumbers, that.lottoNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoNumbers);
  }
}
