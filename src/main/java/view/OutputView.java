package view;

import domain.Lottos;

public interface OutputView {
    void showTotalNumberOfLottos(int numberOfLottos);
    void showRandomGeneratedLottos(Lottos lottos);
    void showLottoResult();
    void showProfitRate(double profitRate);
}
