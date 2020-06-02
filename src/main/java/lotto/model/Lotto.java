package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

  private final List<LottoNumbers> lottoList;

  public Lotto(List<LottoNumbers> lottoList) {
    this.lottoList = new ArrayList<>(lottoList);
  }

  public List<LottoNumbers> getLottoList() {
    return new ArrayList<>(lottoList);
  }

}
