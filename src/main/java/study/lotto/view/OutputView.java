package study.lotto.view;

import study.lotto.model.Lotto;
import study.lotto.model.LottoStatistics;

public interface OutputView {
  void purchaseView(Lotto lotto);

  void winningStatistics(LottoStatistics lottoStatistics);
}
