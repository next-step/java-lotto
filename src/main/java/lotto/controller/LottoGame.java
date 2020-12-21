package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class LottoGame {

    public void run() {
        int totalLottoSize = readTotalPurchasingAmount() / Lotto.PRICE;
        int manualPurchasingSize = readManualPurchasingSize();
        int automatedPurchasingSize = totalLottoSize - manualPurchasingSize;
        Lottos lottos = new Lottos(automatedPurchasingSize, readManualPurchasingLottos(manualPurchasingSize));
        printPurchasedLottoSize(manualPurchasingSize, automatedPurchasingSize);
        printNumbersOfPurchasedLottos(lottos);
        printStatisticsForLottos(lottos.retrieveStatistics(readWinningLotto()));
    }
}
