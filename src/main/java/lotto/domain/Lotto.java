package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Lotto {

  private LottoNumberList lottoNumberList;


  public Lotto(LottoNumberList lottoNumberList) {
    this.lottoNumberList = lottoNumberList;
  }

  public static Lotto of(List<Integer> numbers) {
    List<LottoNumber> lottoNumbers = new ArrayList<>();
    for (Integer number : numbers) {
      lottoNumbers.add(new LottoNumber(number));
    }
    return new Lotto(new LottoNumberList(lottoNumbers));
  }

  public int containsCount(Lotto lastWeekWinningLotto) {
    return lottoNumberList.containsCount(lastWeekWinningLotto);
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

  public boolean contains(LottoNumber lottoNumber) {
    return lottoNumberList.contains(lottoNumber);
  }

  public LottoNumberList getLottoNumberList() {
    return lottoNumberList;
  }
}
