package view;

import domain.Lottos;
import domain.Prizes;

public interface OutputView {
    void showTotalNumberOfLottos(int numberOfLottos);
    void showRandomGeneratedLottos(Lottos lottos);
    void showLottoResult(Prizes prizes);
    void showProfitRate(double profitRate);
}
