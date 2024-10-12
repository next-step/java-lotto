package lotto.ui;

import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.ProfitStatus;

public interface ResultView {
    void showLottoCount(int count);
    void showLottos(Lottos lottos);
    void showLottoResult(LottoResult lottoResult);
    void showLottoProfit(double profitRate);
    void showProfitStatus(ProfitStatus status);
}
