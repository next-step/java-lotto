package lotto;

import java.util.Collections;
import java.util.List;

public class LottoStatistics {

  private final List<LottoResult> lottoResultList;

  public LottoStatistics(List<LottoResult> lottoResultList) {
    this.lottoResultList = lottoResultList;
  }

  public List<LottoResult> getLottoResultList() {
    return Collections.unmodifiableList(lottoResultList);
  }
}
