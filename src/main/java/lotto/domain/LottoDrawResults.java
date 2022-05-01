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

  public LottoDrawResults filterBonusBall(boolean bonusMatch) {
    List<LottoDrawResult> lottoDrawResults = new ArrayList<>();
    for (LottoDrawResult lottoDrawResult : values) {
      addBonusMatch(lottoDrawResult, lottoDrawResults, bonusMatch);
    }
    return new LottoDrawResults(lottoDrawResults);
  }

  private void addBonusMatch(LottoDrawResult lottoDrawResult,
      List<LottoDrawResult> lottoDrawResults, boolean bonusMatch) {
    if (bonusMatch == lottoDrawResult.isBonusMatch()) {
      lottoDrawResults.add(lottoDrawResult);
    }
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
