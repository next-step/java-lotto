package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LottoNumberList {

  private List<LottoNumber> lottoNumbers;
  private static final int IS_MATCHED = 1;
  private static final int IS_NOT_MATCHED = 0;

  public LottoNumberList(List<LottoNumber> lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public static LottoNumberList of(List<Integer> numbers) {
    List<LottoNumber> lottoNumbers = new ArrayList<>();
    for (Integer number : numbers) {
      lottoNumbers.add(new LottoNumber(number));
    }
    return new LottoNumberList(lottoNumbers);
  }


  public int containsCount(LastWinningLotto lastWeekWinningLotto) {
    int count = 0;
    for (LottoNumber lottoNumber : lottoNumbers) {
      count += (lastWeekWinningLotto.contains(lottoNumber) ? IS_MATCHED : IS_NOT_MATCHED);
    }
    return count;
  }

  public boolean contains(LottoNumber lottoNumber) {
    return lottoNumbers.contains(lottoNumber);
  }

  public boolean matchBonusBall(LastWinningLotto lastWeekWinningLotto) {
    boolean match = false;
    for (LottoNumber lottoNumber : lottoNumbers) {
     match = matchBonusBallDetail(lastWeekWinningLotto,lottoNumber);
     if (match) {
       break;
     }
    }
    return match;
  }

  private boolean matchBonusBallDetail(LastWinningLotto lastWinningLotto,LottoNumber lottoNumber) {
    return lastWinningLotto.matchBonusBall(lottoNumber);
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
