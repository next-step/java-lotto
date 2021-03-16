package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotto {

  private List<LottoNumber> lottoNumberList;
  private static final int IS_MATCHED = 1;
  private static final int IS_NOT_MATCHED = 0;

  public Lotto(List<LottoNumber> lottoNumberList) {
    this.lottoNumberList = lottoNumberList;
  }

  public static Lotto of(List<Integer> numbers) {
    List<LottoNumber> lottoNumberList = new ArrayList<>();
    for (Integer number : numbers) {
      lottoNumberList.add(LottoNumber.of(number));
    }
    return new Lotto(lottoNumberList);
  }

  public int containsCount(Lotto lastWeekWinningLotto) {
    int count = 0;
    for (LottoNumber lottoNumber : lottoNumberList) {
      count += (lastWeekWinningLotto.contains(lottoNumber) ? IS_MATCHED : IS_NOT_MATCHED);
    }
    return count;
  }

  private boolean contains(LottoNumber lottoNumber) {
    return lottoNumberList.contains(lottoNumber);
  }

  public List<LottoNumber> getLottoNumberList() {
    return lottoNumberList;
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

}
