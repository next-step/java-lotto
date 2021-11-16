package view;

import domain.LottoResult;
import domain.Lottos;

public interface OutputView {
    void showTotalNumberOfLottos(int numberOfLottos);
    void showRandomGeneratedLottos(Lottos lottos);
    void showLottoResult(LottoResult lottoResult);
    void showProfitRate(double profitRate);
}
