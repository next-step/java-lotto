package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

  public final static Money PRICE = new Money(1000);
  public final static int SIZE = 6;

  private final List<LottoNumbers> lottoList;

  public Lotto(List<LottoNumbers> lottoList) {
    this.lottoList = new ArrayList<>(lottoList);
  }

  public List<LottoNumbers> getLottoList() {
    return new ArrayList<>(lottoList);
  }

}
