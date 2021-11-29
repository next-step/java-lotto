package view;

import domain.Lottos;

public interface OutputView {
    void showTotalNumberOfLottos(int numberOfLottos);
    void showRandomGeneratedLottos(Lottos lottos);
    void showLottoResult(int matchingNumber, int reward, int count);
    void showProfitRate(double profitRate);
}
