package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoDrawResults {

  private final List<LottoDrawResult> values;

  public LottoDrawResults(List<LottoDrawResult> values) {
    this.values = values;
  }

  public int getRewordAll() {
    int rewordAll = 0;
    for (LottoDrawResult lottoDrawResult : values) {
      rewordAll += lottoDrawResult.getReword();
    }
    return rewordAll;
  }

  public LottoDrawResults getDrawResultsByMatchCount(int matchCount) {
    List<LottoDrawResult> lottoDrawResults = new ArrayList<>();
    for (LottoDrawResult lottoDrawResult : values) {
      addIfMatchCountEqual(lottoDrawResult, lottoDrawResults, matchCount);
    }
    return new LottoDrawResults(lottoDrawResults);
  }

  public List<LottoDrawResult> getValues() {
    return Collections.unmodifiableList(values);
  }

  private void addIfMatchCountEqual(LottoDrawResult lottoDrawResult,
      List<LottoDrawResult> lottoDrawResults, int matchCount) {
    if (lottoDrawResult.isMatchCountEqual(matchCount)) {
      lottoDrawResults.add(lottoDrawResult);
    }
  }
}
