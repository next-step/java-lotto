package lotto.domain.result;

import lotto.domain.Lotto;
import lotto.domain.LottoSet;

public interface LottoResultAnalyzer {
  LottoResult analyze(LottoSet lottoSet, Lotto winningLotto);
}
