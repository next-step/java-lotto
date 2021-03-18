package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Lotto {

  private final List<LottoNumber> lottoNumberList;
  private static final int IS_MATCHED = 1;
  private static final int IS_NOT_MATCHED = 0;

  public Lotto(List<LottoNumber> lottoNumberList) {
    this.lottoNumberList = lottoNumberList;
  }

  public static Lotto of(List<Integer> numbers) {
    List<LottoNumber> lottoNumbers = new ArrayList<>();
    for (Integer number : numbers) {
      lottoNumbers.add(new LottoNumber(number));
    }
    return new Lotto(lottoNumbers);
  }

  public boolean contains(LottoNumber lottoNumber) {
    return lottoNumberList.contains(lottoNumber);
  }

  public int containsCount(LastWinningLotto lastWeekWinningLotto) {
    int count = 0;
    for (LottoNumber lottoNumber : lottoNumberList) {
      count += (lastWeekWinningLotto.contains(lottoNumber) ? IS_MATCHED : IS_NOT_MATCHED);
    }
    return count;
  }

  public boolean matchBonusBall(LastWinningLotto lastWeekWinningLotto) {
    int match = 0;
    for (LottoNumber lottoNumber : lottoNumberList) {
      match += lastWeekWinningLotto.matchBonusBall(lottoNumber) ? IS_MATCHED : IS_NOT_MATCHED;
    }
    return match > IS_NOT_MATCHED ;
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
    return Objects.equals(lottoNumberList, lotto.lottoNumberList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoNumberList);
  }

  public List<LottoNumber> getLottoNumberList() {
    return lottoNumberList;
  }

}
